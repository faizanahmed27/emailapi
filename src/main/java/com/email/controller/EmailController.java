package com.email.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	 Logger logger = LoggerFactory.getLogger(EmailController.class);

	@PostMapping("/sendMail")
	public ResponseEntity<?> sendMail(@RequestBody EmailRequest emailRequest){
		
		logger.info("Inside sendMail API");
		
		boolean result = emailService.sendMail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage());
		if(result==true) {
			logger.info("Mail Sent Successfully...");

			return ResponseEntity.ok(new EmailResponse("Mail Sent Successfully..."));
		} else {
			logger.info("Error while Sending Mail");
			return ResponseEntity.badRequest().body(new EmailResponse("Error while Sending Mail"));
		}

	}
}
