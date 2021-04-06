package dev.thelunardi.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import dev.thelunardi.exception.DynamoGeneralException;
import dev.thelunardi.model.driver.Driver;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@ApplicationScoped
public class DynamoDBServiceImpl implements DynamoDBService {
    private static final Logger LOG = Logger.getLogger(DynamoDBServiceImpl.class);
    private DynamoDBMapper mapper;
    private static volatile DynamoDBServiceImpl instance;
    private String region = "us-east-1";
    private String tableName = "drivers";

    public DynamoDBServiceImpl() {

    }

    static DynamoDBServiceImpl instance() {
        if (instance == null) {
            synchronized (DynamoDBServiceImpl.class) {
                if (instance == null) {
                    instance = new DynamoDBServiceImpl();
                }
            }
        }
        return instance;
    }

    DynamoDBMapper getMapperInstance() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("teste", "teste");
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(
                "http://localhost:8000", "us-east-1"
        );
        AmazonDynamoDBClient client = (AmazonDynamoDBClient) AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withEndpointConfiguration(endpointConfiguration)
                .build();
        return new DynamoDBMapper(client);
    }

    private DynamoDBMapperConfig getDynamoDBMapperConfig() {
        return new DynamoDBMapperConfig
                .Builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(this.tableName))
                .build();
    }

    @Override
    public Driver load(String driverId) throws DynamoGeneralException {
        LOG.infof("Searching for the driver: %s", driverId);
        try {
            DynamoDBMapperConfig config = getDynamoDBMapperConfig();
            Driver driver = getMapperInstance().load(Driver.class, driverId, config);
            if (Objects.isNull(driver)) {
                LOG.errorf("Driver not found: %s", driverId);
                throw new DynamoGeneralException("Driver not found");
            }
            return driver;
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage());
            throw new DynamoGeneralException("Error: " + e.getMessage());
        }
    }
}
