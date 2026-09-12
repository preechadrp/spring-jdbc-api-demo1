package com.mycom.springjdbcapidemo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mycom.springjdbcapidemo1.model.CustOrder;
import com.mycom.springjdbcapidemo1.repository.CustOrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringJdbcApiDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApiDemo1Application.class, args);
	}

	@Bean
	CommandLineRunner custOrder(CustOrderRepository custOrderRepository) {
		return (args) -> {
			log.info("Running CommandLineRunner.....test");
			var datas = custOrderRepository.findByCustomerName("customer_name" + 2011);
			if (datas.size() == 0) {
				log.info("Not found data.");
				return;
			}
			for (CustOrder data : datas) {
				log.info("custOrder={}", data.toString());
			}
		};
	}

}
