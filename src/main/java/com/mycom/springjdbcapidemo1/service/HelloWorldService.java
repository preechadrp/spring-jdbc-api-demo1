package com.mycom.springjdbcapidemo1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycom.springjdbcapidemo1.component.CommonProperties;
import com.mycom.springjdbcapidemo1.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloWorldService {

	//private static final Logger logx = LoggerFactory.getLogger(HelloWorldService.class);

	@Value("${app.common.name}")
	private String commonName;

	private final CommonProperties commonProperties;

	public HelloWorldService(CommonProperties commonProperties) {
		this.commonProperties = commonProperties;
	}

	public String hello() {
		try {
			//....todo something
			log.info("HelloWorldService.hello() called");
			log.info("commonName: {}", commonName);
			log.info("commonName: {}", this.commonProperties.getName());
			return "Hello World!";
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(500, e.getMessage(), true);
		}
	}

}