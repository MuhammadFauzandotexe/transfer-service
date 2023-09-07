package org.zan.tranferservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the application.
 *
 * @author Muhammad Fauzan
 */
@ConfigurationProperties(prefix = "app.config")
@Setter
@Getter
public class AppProperties {
    private String company;
    private String client;
}