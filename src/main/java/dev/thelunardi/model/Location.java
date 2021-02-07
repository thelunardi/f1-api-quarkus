package dev.thelunardi.model;

import javax.json.bind.annotation.JsonbProperty;

public class Location {
    @JsonbProperty("lat")
    public String latitude;
    @JsonbProperty("long")
    public String longitude;
    public String locality;
    public String country;
}
