package dev.thelunardi.service;

import dev.thelunardi.model.circuit.Circuit;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface CircuitService {
    List<Circuit> getCircuits() throws Exception;
}
