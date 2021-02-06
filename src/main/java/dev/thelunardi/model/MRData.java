package dev.thelunardi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.json.bind.annotation.JsonbProperty;

@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class MRData {
    @JsonbProperty("xmlns")
    public String xmlns;
    public String limit;
    public String offset;
    public String total;
    @JsonbProperty("DriverTable")
    public DriverTable driverTable;

    public DriverTable getDriverTable() {
        return driverTable;
    }
}
