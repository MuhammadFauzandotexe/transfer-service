package org.zan.tranferservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TranferserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranferserviceApplication.class, args);
	}

}
