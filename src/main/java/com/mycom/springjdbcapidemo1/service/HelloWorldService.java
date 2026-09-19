package com.mycom.springjdbcapidemo1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycom.springjdbcapidemo1.component.AppConfig;
import com.mycom.springjdbcapidemo1.component.CommonConfig;
import com.mycom.springjdbcapidemo1.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloWorldService {

	//private static final Logger logx = LoggerFactory.getLogger(HelloWorldService.class);

	@Value("${app.common.name}")
	private String commonName;

	private final CommonConfig commonProperties;

	//ใช้ constructor เพื่อเรียก bean ตัวอื่นมาใช้งาน
	public HelloWorldService(CommonConfig commonProperties) {
		this.commonProperties = commonProperties;
	}

	public String hello() {
		try {
			//....todo something
			log.info("HelloWorldService.hello() called");
			log.info("commonName = {}", commonName);
			log.info("this.commonProperties.getName() = {}", this.commonProperties.getName());
			log.info("CommonProperties.getInstance().getName() = {}", CommonConfig.getInstance().getName());//ไม่ต้องใส่ตอน constructor class
			log.info("AppConfig.getInstance().getName() = {}", AppConfig.getInstance().getName()); //ไม่ต้องใส่ตอน constructor class

			return "Hello World!";
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(500, e.getMessage(), true);
		}
	}
}