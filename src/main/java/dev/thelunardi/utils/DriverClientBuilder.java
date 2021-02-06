package dev.thelunardi.utils;

import dev.thelunardi.client.DriverClient;
import dev.thelunardi.client.DriverRequestMapper;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.net.MalformedURLException;
import java.net.URL;

@ApplicationScoped
public class DriverClientBuilder {
    public DriverClient build(String url) throws MalformedURLException {
        return RestClientBuilder
                .newBuilder()
                .baseUrl(new URL(url))
                .register(DriverRequestMapper.class)
                .build(DriverClient.class);
    }
}
