package dev.thelunardi.model.driver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.json.bind.annotation.JsonbProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverResponse {
    @JsonbProperty("MRData")
    public MRDataDriver mrData;

    public MRDataDriver getMRDataDriver() {
        return mrData;
    }
}
