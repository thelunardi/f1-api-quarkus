package dev.thelunardi.utils;

import dev.thelunardi.client.ApiClient;
import dev.thelunardi.client.ApiRequestMapper;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.net.MalformedURLException;
import java.net.URL;

@ApplicationScoped
public class CircuitClientBuilder {
    public ApiClient build(String url) throws MalformedURLException {
        return RestClientBuilder
                .newBuilder()
                .baseUrl(new URL(url))
                .register(ApiRequestMapper.class)
                .build(ApiClient.class);
    }
}
