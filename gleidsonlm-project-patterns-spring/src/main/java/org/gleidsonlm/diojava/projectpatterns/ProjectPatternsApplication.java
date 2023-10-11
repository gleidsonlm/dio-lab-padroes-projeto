package org.gleidsonlm.diojava.projectpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author @gleidsonlm
 */

 @EnableFeignClients // Habilita o uso do Feign
@SpringBootApplication
public class ProjectPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPatternsApplication.class, args);
	}

}
