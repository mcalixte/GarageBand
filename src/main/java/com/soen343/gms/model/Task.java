package com.soen343.gms.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String taskDescription;
    boolean isComplete;

    @ManyToOne
    Job job;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskDescription='" + taskDescription + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
