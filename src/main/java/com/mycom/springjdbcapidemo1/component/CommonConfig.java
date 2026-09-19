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

	@PreDestroy
	public void stop() {
		log.info("@PreDestroy");
	}
}