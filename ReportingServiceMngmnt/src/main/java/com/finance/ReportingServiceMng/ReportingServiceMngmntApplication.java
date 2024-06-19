package com.finance.ReportingServiceMng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = {"com.finance.TransactionMngmnt.model"})
public class ReportingServiceMngmntApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingServiceMngmntApplication.class, args);
	}

}
