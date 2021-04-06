package dev.thelunardi.model.driver;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@DynamoDBTable(tableName = "drivers")
public class Driver {
    @DynamoDBHashKey
    private String driverId;

    @DynamoDBAttribute
    private String url;

    @DynamoDBAttribute
    private String givenName;

    @DynamoDBAttribute
    private String familyName;

    @DynamoDBAttribute
    private String dateOfBirth;

    @DynamoDBAttribute
    private String nationality;

    public Driver() {

    }

    public Driver(String driverId, String url, String givenName, String familyName, String dateOfBirth, String nationality) {
        this.driverId = driverId;
        this.url = url;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getUrl() {
        return url;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
