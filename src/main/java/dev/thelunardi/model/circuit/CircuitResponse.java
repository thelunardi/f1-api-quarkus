package dev.thelunardi.model.circuit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.json.bind.annotation.JsonbProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CircuitResponse {
    @JsonbProperty("MRData")
    public MRDataCircuit mrData;

    public MRDataCircuit getMRDataCircuit() {
        return mrData;
    }
}
