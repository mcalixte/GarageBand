package com.soen343.gms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("A"),
    SERVICE("S"),
    MECHANIC("M"),
    GOD("G");
    private String code;
    @Override
    public String toString() {
        return this.name();
    }
}
