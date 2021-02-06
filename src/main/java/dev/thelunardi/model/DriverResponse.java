package dev.thelunardi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.json.bind.annotation.JsonbProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverResponse {
    @JsonbProperty("MRData")
    public MRData MRData;

    public MRData getMRData() {
        return MRData;
    }
}
