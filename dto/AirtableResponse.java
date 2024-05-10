package com.freespacenow.airtable.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AirtableResponse<T> {
    private List<Record<T>> records;
    private String offset;

    @JsonCreator
    public AirtableResponse() {}

    public List<Record<T>> getRecords() {
        return records;
    }

    public void setRecords(List<Record<T>> records) {
        this.records = records;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
