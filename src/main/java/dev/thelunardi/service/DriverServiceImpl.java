package dev.thelunardi.service;

import dev.thelunardi.client.ApiClient;
import dev.thelunardi.exception.DriverException;
import dev.thelunardi.exception.DynamoGeneralException;
import dev.thelunardi.helpers.ConstantHelper;
import dev.thelunardi.model.driver.Driver;
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

    @Inject
    DynamoDBService dynamoDBService;

    @Override
    public List<Driver> getDrivers() throws MalformedURLException {
        try {
            ApiClient driverClient = driverClientBuilder.build(constantHelper.getF1Url());
            return driverClient.getDrivers().getMRDataDriver().getDriverTable().getDrivers();
        } catch (MalformedURLException | DriverException e) {
            LOG.errorf("Erro ao listar os pilotos", e.getMessage());
            throw e;
        } catch (Exception e) {
            LOG.errorf("Erro interno ao listar os pilotos", e.getMessage());
            throw e;
        }
    }

    @Override
    public Driver getInternalDriverById(String driverId) throws DynamoGeneralException {
        try {
            return dynamoDBService.load(driverId);
        } catch (DynamoGeneralException e) {
            LOG.errorf("Erro ao listar os pilotos", e.getMessage());
            throw new DriverException("Erro ao listar os pilotos " + e.getMessage());
        } catch (Exception e) {
            LOG.errorf("Erro ao listar os pilotos", e.getStackTrace());
            throw e;
        }
    }
}
