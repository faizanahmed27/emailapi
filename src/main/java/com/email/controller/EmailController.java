package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.email.service.EmailService;

@RestController
@RequestMapping("/api")
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@PostMapping("/sendMail")
	public ResponseEntity<?> sendMail(@RequestParam String to, @RequestParam String message, @RequestParam String subject){
		
		emailService.sendMail(to, message, subject);
		
		return ResponseEntity.ok("Mail sent successfully...!");
	}
}
