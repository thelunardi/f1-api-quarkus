package dev.thelunardi.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import dev.thelunardi.exception.DynamoGeneralException;
import dev.thelunardi.model.driver.Driver;

public interface DynamoDBService {
    Driver load(String id) throws DynamoGeneralException;

}
