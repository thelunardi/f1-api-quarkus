package dev.thelunardi.service;

import dev.thelunardi.client.DriverClient;
import dev.thelunardi.exception.DriverException;
import dev.thelunardi.helpers.ConstantHelper;
import dev.thelunardi.model.Driver;
import dev.thelunardi.utils.DriverClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import java.net.MalformedURLException;
import java.util.List;

@ApplicationScoped
public class DriverServiceImpl implements DriverService {
    private static final Logger LOG = Logger.getLogger(DriverServiceImpl.class);

    @Inject
    DriverClientBuilder driverClientBuilder;

    @Inject
    ConstantHelper constantHelper;

    @Override
    public List<Driver> getDrivers() throws MalformedURLException {
        try {
            DriverClient driverClient = driverClientBuilder.build(constantHelper.getF1Url());
            return driverClient.getDrivers().getMRData().getDriverTable().getDrivers();
        } catch (MalformedURLException | DriverException e) {
            LOG.errorf("Erro ao listar os pilotos", e.getMessage());
            throw e;
        } catch (Exception e) {
            LOG.errorf("Erro interno ao listar os pilotos", e.getMessage());
            throw e;
        }
    }
}
