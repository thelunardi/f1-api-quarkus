package dev.thelunardi.service;

import dev.thelunardi.client.ApiClient;
import dev.thelunardi.exception.DriverException;
import dev.thelunardi.helpers.ConstantHelper;
import dev.thelunardi.model.circuit.Circuit;
import dev.thelunardi.utils.CircuitClientBuilder;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.MalformedURLException;
import java.util.List;

@ApplicationScoped
public class CircuitServiceImpl implements CircuitService {
    private static final Logger LOG = Logger.getLogger(CircuitServiceImpl.class);

    @Inject
    CircuitClientBuilder circuitClientBuilder;

    @Inject
    ConstantHelper constantHelper;

    @Override
    public List<Circuit> getCircuits() throws MalformedURLException {
        try {
            ApiClient circuitClient = circuitClientBuilder.build(constantHelper.getF1Url());
            return circuitClient.getCircuits().getMRDataCircuit().getCircuitTable().getCircuits();
        } catch (MalformedURLException | DriverException e) {
            LOG.errorf("Erro ao listar os pilotos", e.getMessage());
            throw e;
        } catch (Exception e) {
            LOG.errorf("Erro interno ao listar os pilotos", e.getMessage());
            throw e;
        }
    }
}
