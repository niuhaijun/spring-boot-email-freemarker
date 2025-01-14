package com.javatechie.email.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.email.api.dto.MailRequest;
import com.javatechie.email.api.dto.MailResponse;
import com.javatechie.email.api.service.EmailService;

@SpringBootApplication
@RestController
public class SpringBootEmailFreemarkerApplication {

	@Autowired
	private EmailService service;

	@GetMapping("/sendingEmail")
	public MailResponse sendEmail() {

		MailRequest request = new MailRequest();
		request.setFrom("nhjemail@sina.com");
		request.setName("牛海军");
		request.setTo("nhjemail@163.com");
		request.setSubject("第二种方式");


		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Bangalore,India");
		return service.sendEmail(request, model);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailFreemarkerApplication.class, args);
	}
}
