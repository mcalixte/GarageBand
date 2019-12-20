package com.soen343.gms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobState {
    Initial("I") {
        @Override
        public JobState nextState() { return InProgress; }
        @Override
        public JobState prevState() { return this; }
    },
    InProgress("IP") {
        @Override
        public JobState nextState() { return PendingApproval; }
        @Override
        public JobState prevState() { return this; }
        public JobState onHold() { return OnHold; }
    },
    OnHold("H") {
        @Override
        public JobState nextState() { return InProgress; }
        @Override
        public JobState prevState() { return InProgress; }
    },
    PendingApproval("PA") {
        @Override
        public JobState nextState() { return Complete; }
        @Override
        public JobState prevState() { return InProgress; }
    },
    Complete("C") {
        @Override
        public JobState nextState() { return Archived; }
        @Override
        public JobState prevState() { return InProgress; }
    },
    Archived("A") {
        @Override
        public JobState nextState() { return this; }
        @Override
        public JobState prevState() { return this; }
    };
    private String code;

    public abstract JobState nextState();
    public abstract JobState prevState();

    @Override
    public String toString() {return this.name();}
}
