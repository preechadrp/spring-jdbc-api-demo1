package com.mycom.springjdbcapidemo1.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Component("AppConfig")
@Getter
@Slf4j
public class AppConfig {

	/*
	 * ตัวอย่างการอ่าน config แบบ @Value("${....}")
	 */

	private static AppConfig instance;

	@Value("${app.common.name}")
	private String name;

	@Value("${app.common.db1-url}")
	private String db1Url;

	@Value("${app.common.db1-driver-class-name}")
	private String db1DriverClassName;

	@Value("${app.common.db1-username}")
	private String db1Username;

	@Value("${app.common.db1-password}")
	private String db1Password;

	@PostConstruct
	public void init() {
		instance = this;//ช่วยให้ code แบบเก่าสามารถดึงไปใช้งานโดยไม่ต้องใช้หลักการ injection ของ spring

		log.info("==== AppConfig ====");
		log.info("name = {}", instance.getName());
		log.info("db1Url = {}", instance.getDb1Url());
		log.info("db1DriverClassName = {}", instance.getDb1DriverClassName());
		log.info("db1Username = {}", instance.getDb1Username());
		log.info("db1Password = {}", instance.getDb1Password());

	}

	public static AppConfig getInstance() {
		//ตัวอย่างการใช้งานเช่น   AppConfig.getInstance().getDb1Url(); เป็นต้น
		return instance;
	}
}
