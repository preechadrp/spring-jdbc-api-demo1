package com.mycom.springjdbcapidemo1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mycom.springjdbcapidemo1.component.CommonConfig;
import com.mycom.springjdbcapidemo1.component.ShareConfig;
import com.mycom.springjdbcapidemo1.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HelloWorldService {

	//private static final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

	@Value("${app.common.name}")
	private String commonName;

	private final CommonConfig commonConfig;

	//ใช้ constructor เพื่อเรียก bean ตัวอื่นมาใช้งาน
	public HelloWorldService(CommonConfig commonConfig) {
		this.commonConfig = commonConfig;
	}

	public String hello() {
		try {
			//....todo something
			log.info("HelloWorldService.hello() called");
			log.info("commonName = {}", commonName);
			log.info("this.commonConfig.getName() = {}", this.commonConfig.getName());

			//แบบไม่ต้องใส่ตอน constructor class
			log.info("ShareConfig.getInstance().getName() = {}", ShareConfig.getInstance().getName());

			return "Hello World!";
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException(500, e.getMessage(), true);
		}
	}
}