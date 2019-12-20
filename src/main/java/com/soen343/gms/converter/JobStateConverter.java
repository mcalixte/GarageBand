package com.soen343.gms.converter;

import com.soen343.gms.model.JobState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class JobStateConverter implements AttributeConverter<JobState, String> {
    @Override
    public String convertToDatabaseColumn(JobState state) {
        if(state == null) {
            return null;
        }
        return state.getCode();
    }

    public JobState convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(JobState.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}