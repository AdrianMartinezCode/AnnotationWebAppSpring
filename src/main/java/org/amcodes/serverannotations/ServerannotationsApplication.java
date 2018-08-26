package org.amcodes.serverannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages= {
		"org.amcodes.serverannotations.config",
		"org.amcodes.serverannotations.controller",
		//"org.amcodes.serverannotations.exception",
		//"org.amcodes.serverannotations.model",
		//"org.amcodes.serverannotations.payload",
		//"org.amcodes.serverannotations.repository",
		"org.amcodes.serverannotations.security"
})
@ComponentScan(basePackages= {
		"org.amcodes.serverannotations.config",
		"org.amcodes.serverannotations.controller",
		"org.amcodes.serverannotations.service",
		"org.amcodes.serverannotations.exception",
		"org.amcodes.serverannotations.payload",
		//"org.amcodes.serverannotations.repository",
		"org.amcodes.serverannotations.security"
})
@EnableJpaRepositories(basePackages= {
		"org.amcodes.serverannotations.repository"
})
/*@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories*/
public class ServerannotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerannotationsApplication.class, args);
	}
}
