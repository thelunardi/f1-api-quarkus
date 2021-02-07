package dev.thelunardi.model.circuit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.json.bind.annotation.JsonbProperty;

@RegisterForReflection
@JsonIgnoreProperties(ignoreUnknown = true)
public class MRDataCircuit {
    public String xmlns;
    public String series;
    public String limit;
    public String offset;
    public String total;
    @JsonbProperty("CircuitTable")
    public CircuitTable circuitTable;

    public CircuitTable getCircuitTable() {
        return circuitTable;
    }
}
