package dev.thelunardi.model.circuit;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class CircuitTable {
    @JsonbProperty("Circuits")
    public List<Circuit> circuits;

    public List<Circuit> getCircuits() {
        return circuits;
    }
}
