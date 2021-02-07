package dev.thelunardi.model.circuit;

import dev.thelunardi.model.Location;

import javax.json.bind.annotation.JsonbProperty;

public class Circuit {
    public String circuitId;
    public String url;
    public String circuitName;
    @JsonbProperty("Location")
    public Location location;
}
