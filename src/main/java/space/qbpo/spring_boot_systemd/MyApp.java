package space.qbpo.spring_boot_systemd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {

	public static void main(String[] args) {
		System.out.println("blar blar");
		SpringApplication.run(MyApp.class, args);
	}
}
