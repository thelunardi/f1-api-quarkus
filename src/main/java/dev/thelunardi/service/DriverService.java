package dev.thelunardi.service;

import dev.thelunardi.model.driver.Driver;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface DriverService {
    List<Driver> getDrivers() throws Exception;
    Driver getInternalDriverById(String driverId) throws Exception;
}
