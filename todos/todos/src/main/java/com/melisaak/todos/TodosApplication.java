package com.melisaak.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)

//Audit:
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")// Belirlenen kişileri kontrol et

public class TodosApplication {

	public static void main(String[] args) {
		//DevTools
		System.setProperty("spring.devtools.restart.enabled","false");

		// AWT: JOptionPanel set ayarı
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(TodosApplication.class, args);
	}

}

