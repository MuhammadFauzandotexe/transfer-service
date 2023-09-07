package org.zan.tranferservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.zan.tranferservice.configuration.AppProperties;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(AppProperties.class)
public class TranferserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranferserviceApplication.class, args);
	}

}
