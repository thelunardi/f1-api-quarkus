package dev.thelunardi.helpers;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConstantHelper {
    @ConfigProperty(name = "f1.url")
    private String f1Url;

    public String getF1Url() {
        return this.f1Url;
    }
}
