package com.soen343.gms.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JobStateTest {

    @Test
    void nextJobStateFromInitialTest() {
        JobState jobState = JobState.Initial;
        JobState expected = JobState.InProgress;
        JobState actual = jobState.nextState();
        assertEquals(expected, actual, "The next method from Initial should return InProgress");
    }
    @Test
    void nextJobStateFromInProgressTest() {
        JobState jobState = JobState.InProgress;
        JobState expected = JobState.PendingApproval;
        JobState actual = jobState.nextState();
        assertEquals(expected, actual, "The next method from InProgress should return PendingApproval");
    }
    @Test
    void nextJobStateFromOnHoldTest() {
        JobState jobState = JobState.OnHold;
        JobState expected = JobState.InProgress;
        JobState actual = jobState.nextState();
        assertEquals(expected, actual, "The next method from OnHold should return InProgress");
    }
    @Test
    void nextJobStateFromPendingApprovalTest() {
        JobState jobState = JobState.PendingApproval;
        JobState expected = JobState.Complete;
        JobState actual = jobState.nextState();
        assertEquals(expected, actual, "The next method from Approval should return Complete");
    }
    @Test
    void nextJobStateFromCompleteTest() {
        JobState jobState = JobState.Complete;
        JobState expected = JobState.Archived;
        JobState actual = jobState.nextState();
        assertEquals(expected, actual, "The next method from Complete should return Archived");
    }
    @Test
    void nextJobStateFromArchivedTest() {
        JobState jobState = JobState.Archived;
        JobState expected = JobState.Archived;
        JobState actual = jobState.nextState();
        assertEquals(expected, actual, "The next method from Archived should return Archived");
    }

    @Test
    void prevJobStateFromInitialTest() {
        JobState jobState = JobState.Initial;
        JobState expected = JobState.Initial;
        JobState actual = jobState.prevState();
        assertEquals(expected, actual, "The prev method from Initial should return Initial");
    }
    @Test
    void prevJobStateFromInProgressTest() {
        JobState jobState = JobState.InProgress;
        JobState expected = JobState.InProgress;
        JobState actual = jobState.prevState();
        assertEquals(expected, actual, "The prev method from InProgress should return InProgress");
    }
    @Test
    void prevJobStateFromOnHoldTest() {
        JobState jobState = JobState.OnHold;
        JobState expected = JobState.InProgress;
        JobState actual = jobState.prevState();
        assertEquals(expected, actual, "The prev method from OnHold should return InProgress");
    }
    @Test
    void prevJobStateFromPendingApprovalTest() {
        JobState jobState = JobState.PendingApproval;
        JobState expected = JobState.InProgress;
        JobState actual = jobState.prevState();
        assertEquals(expected, actual, "The prev method from PendingApproval should return InProgress");
    }
    @Test
    void prevJobStateFromCompleteTest() {
        JobState jobState = JobState.Complete;
        JobState expected = JobState.InProgress;
        JobState actual = jobState.prevState();
        assertEquals(expected, actual, "The prev method from Complete should return InProgress");
    }
    @Test
    void prevJobStateFromArchivedTest() {
        JobState jobState = JobState.Archived;
        JobState expected = JobState.Archived;
        JobState actual = jobState.prevState();
        assertEquals(expected, actual, "The prev method from Archived should return Archived");
    }

    @Test
    void getCodeFromInitialTest() {
        JobState jobState = JobState.Initial;
        String expected = "I";
        String actual = jobState.getCode();
        assertEquals(expected, actual, "The getCode method from Initial should return \"I\"");
    }
    @Test
    void getCodeFromInProgressTest() {
        JobState jobState = JobState.InProgress;
        String expected = "IP";
        String actual = jobState.getCode();
        assertEquals(expected, actual, "The getCode method from InProgress should return \"IP\"");
    }
    @Test
    void getCodeFromOnHoldTest() {
        JobState jobState = JobState.OnHold;
        String expected = "H";
        String actual = jobState.getCode();
        assertEquals(expected, actual, "The getCode method from OnHold should return \"H\"");
    }
    @Test
    void getCodeFromPendingApprovalTest() {
        JobState jobState = JobState.PendingApproval;
        String expected = "PA";
        String actual = jobState.getCode();
        assertEquals(expected, actual, "The getCode method from PendingApproval should return \"PA\"");
    }
    @Test
    void getCodeFromCompleteTest() {
        JobState jobState = JobState.Complete;
        String expected = "C";
        String actual = jobState.getCode();
        assertEquals(expected, actual, "The getCode method from Complete should return \"C\"");
    }
    @Test
    void getCodeFromArchivedTest() {
        JobState jobState = JobState.Archived;
        String expected = "A";
        String actual = jobState.getCode();
        assertEquals(expected, actual, "The getCode method from Archived should return \"A\"");
    }


}