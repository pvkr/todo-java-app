package com.github.pvkr.todo.config.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoEndpointRuntimeContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> runtimeDetails = new HashMap<>();
        runtimeDetails.put("jre", getJREProperties());
        runtimeDetails.put("os", getOSProperties());

        builder.withDetail("runtime", runtimeDetails);
    }

    private static Map<String, String> getJREProperties() {
        return Map.of(
                "vendor", System.getProperty("java.vendor"),
                "version", System.getProperty("java.version")
        );
    }

    private static Map<String, String> getOSProperties() {
        return Map.of(
                "name", System.getProperty("os.name"),
                "version", System.getProperty("os.version"),
                "arch", System.getProperty("os.arch")
        );
    }
}
