package com.mycom.springjdbcapidemo1.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Data
@ConfigurationProperties(prefix = "app.common")
@Slf4j
public class CommonConfig {

	/*
	 * ตัวอย่างการอ่าน config แบบ @ConfigurationProperties(prefix = "app.common")
	 */

	private static CommonConfig instance;

	private String name;
	private String db1Url;
	private String db1DriverClassName;
	private String db1Username;
	private String db1Password;
	private String proxyHost;
	private int proxyPort;
	private String proxyUsername;
	private String proxyPassword;

	@PostConstruct
	public void init() {
		instance = this;//ช่วยให้ code แบบเก่าสามารถดึงไปใช้งานโดยไม่ต้องใช้หลักการ injection ของ spring

		log.info("===== CommonConfig =====");
		log.info("Name = {}", name);
		log.info("DB1 URL = {}", db1Url);
		log.info("DB1 DriverClassName = {}", db1DriverClassName);
		log.info("DB1 Username = {}", db1Username);
		log.info("DB1 Password = {}", db1Password);
		log.info("Proxy Host = {}", proxyHost);
		log.info("Proxy Port = {}", proxyPort);
		log.info("Proxy Username = {}", proxyUsername);
		log.info("Proxy Password = {}", proxyPassword);
	}

	public static CommonConfig getInstance() {
		//ตัวอย่างการใช้งานเช่น   CommonConfig.getInstance().getDb1Url(); เป็นต้น
		return instance;
	}

	@PreDestroy
	public void stop() {
		log.info("@PreDestroy");
	}
}