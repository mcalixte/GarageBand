package com.soen343.gms.controller;

import com.soen343.gms.model.Job;
import com.soen343.gms.model.JobState;
import com.soen343.gms.model.Task;
import com.soen343.gms.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping(value={"/home/job/createjob"}, method=RequestMethod.GET)
    public ModelAndView createjob(){
        ModelAndView model = new ModelAndView();
        model.setViewName("job/createjob");
        return model;
    }

    @RequestMapping(value={"/home/job/checkout"}, method=RequestMethod.GET)
    public ModelAndView checkout(){
        ModelAndView model = new ModelAndView();
        List<Job> jobs = jobService.findJobsByState(JobState.Complete);
        model.addObject("jobs", jobs);
        model.setViewName("job/checkout");
        return model;
    }

    @RequestMapping(value={"/home/job/jobbank"}, method=RequestMethod.GET)
    public ModelAndView jobbank(){
        ModelAndView model = new ModelAndView();
        model.setViewName("job/jobbank");
        List<Job> jobs = jobService.getAllJobs();
        model.addObject("jobs", jobs);
        return model;
    }

    @RequestMapping(value={"/home/job/archivedjobs"}, method=RequestMethod.GET)
    public ModelAndView archivedjobs(){
        ModelAndView model = new ModelAndView();
        List<Job> jobs = jobService.findJobsByState(JobState.Archived);
        model.addObject("jobs", jobs);
        model.setViewName("job/archivedjob");
        return model;
    }

    @RequestMapping(value={"/home/job/{vin}"}, method=RequestMethod.GET)
    public ModelAndView jobpage(@PathVariable("vin") long vin){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobsByVin(vin);
        model.setViewName("job/jobpage");
        model.addObject("job", job);
        return model;
    }

    @RequestMapping(value={"/home/job/{vin}/task"}, method=RequestMethod.GET)
    public ModelAndView taskpage(@PathVariable("vin") long vin){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobsByVin(vin);
        List<Task> tasks = job.getTasks();
        model.setViewName("task/task");
        model.addObject("tasks", tasks);
        return model;
    }

    @RequestMapping(value = "/home/job/createjob", method= RequestMethod.POST)
    @ResponseBody
    public ModelAndView createJob(@RequestParam("vin") float vin, @RequestParam("notes") String notes, @RequestParam("customer") String customer, @RequestParam("task") String[] tasks) {
        ModelAndView model = new ModelAndView();
        Job job = new Job();
        job.setVin((long)vin);
        job.setDescription(notes);
        job.setState(JobState.Initial);
        job.setCustomer(customer);
        job.setMechanic("John Doe");

        ArrayList<Task> taskList = new ArrayList<Task>();
        for(String taskString: tasks){
            Task t = new Task();
            t.setTaskDescription(taskString);
            taskList.add(t);
        }

        job.setTasks(taskList);
        jobService.saveJob(job);
        model.setViewName("/job/createjob");
        return model;
    }

    //Must probably be replaced with an update to DB, but not sure how to do that
    @RequestMapping(value="/home/job/archivejob", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView archiveJob(@RequestParam("vin") long vin){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobsByVin(vin);
        job.setState(JobState.Archived);
        job = jobService.update(job);
        model.addObject(job);
        model.setViewName("/job/checkout");
        return model;

    }

    //Must probably be replaced with an update to DB, but not sure how to do that
    @RequestMapping(value="/home/job/completejob", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView completeJob(@RequestParam("vin") long vin){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobsByVin(vin);
        job.setState(JobState.Complete);
        job = jobService.update(job);
        model.addObject(job);
        model.setViewName("/job/jobpage");
        return model;

    }

    @RequestMapping(value="/home/job/inprogress", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView initialToInProgress(@RequestParam("vin") long vin){
        ModelAndView model = new ModelAndView();
        Job job = jobService.findJobsByVin(vin);
        job.setState(JobState.InProgress);
        job = jobService.update(job);
        List<Job> jobs = jobService.getAllJobs();
        model.addObject("jobs", jobs);
        model.setViewName("/job/jobbank");
        return model;

    }


}
