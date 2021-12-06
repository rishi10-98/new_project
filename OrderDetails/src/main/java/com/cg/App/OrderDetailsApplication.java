package com.cg.App;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrderDetailsApplication {
	
//	@Autowired
//	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(OrderDetailsApplication.class, args);
	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() 
//		{
//			emailSenderService.sendSimpleMail("singh.rishika1098@gmail.com",
//					"This is Email body", "This is Email subject");
//	}

}
