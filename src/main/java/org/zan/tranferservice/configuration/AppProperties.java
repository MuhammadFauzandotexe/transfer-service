package org.zan.tranferservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties class for the application.
 * This class is used to define configuration properties that can be
 * loaded from external configuration sources (e.g., application.properties or
 * application.yml) using the specified prefix "app.config".
 * Example usage in a Spring component:
 * {@literal @}Autowired
 * // ...
 * String company = appProperties.getCompany();
 * String client = appProperties.getClient();
 *
 *
 *
 * @author Muhammad Fauzan
 * @see ConfigurationProperties
 */
@ConfigurationProperties(prefix = "app.config")
@Setter
@Getter
public class AppProperties {
    private String company;
    private String client;
}
