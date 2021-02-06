package dev.thelunardi.model;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class DriverTable {
    @JsonbProperty("Drivers")
    public List<Driver> drivers;

    public List<Driver> getDrivers() {
        return drivers;
    }
}
