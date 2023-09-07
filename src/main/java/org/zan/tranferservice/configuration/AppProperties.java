package org.zan.tranferservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the application.
 *
 * @author Muhammad Fauzan
 */
@ConfigurationProperties(prefix = "app.config")
@Data
public class AppProperties {
    private String company;
    private String client;
}