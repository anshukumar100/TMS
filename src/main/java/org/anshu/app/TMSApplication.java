/**
 * 
 */
package org.anshu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * This is the entry point for Transfer Management Service Application
 * @author Anshu Kumar
 *
 */

@SpringBootApplication(scanBasePackages = {"org.anshu"} , exclude = JpaRepositoriesAutoConfiguration.class)
@ComponentScan(basePackages="org.anshu") 
@EntityScan("org.anshu.entity")
@EnableJpaRepositories("org.anshu.dao")
public class TMSApplication {

	/**
	 * @param args list of input argument for starting of the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(TMSApplication.class, args);
	}

}
