package dev.thelunardi.service;

import dev.thelunardi.client.DriverClient;
import dev.thelunardi.exception.DriverException;
import dev.thelunardi.helpers.ConstantHelper;
import dev.thelunardi.model.Driver;
import dev.thelunardi.utils.DriverClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class DriverServiceImpl implements DriverService {
    private static final org.jboss.logging.Logger LOG = Logger.getLogger(DriverServiceImpl.class);

    @Inject
    DriverClientBuilder driverClientBuilder;

    @Inject
    ConstantHelper constantHelper;

    @Override
    public List<Driver> getDrivers() throws Exception {
        try {
            DriverClient driverClient = driverClientBuilder.build(constantHelper.getF1Url());
            return driverClient.getDrivers().getMRData().getDriverTable().getDrivers();
        } catch (DriverException e) {
            throw new Exception("Erro ao listar os pilotos");
        }
    }
}
