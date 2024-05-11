package com.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String mailFrom;
	
	Logger logger = LoggerFactory.getLogger(EmailService.class);
	
	public boolean sendMail(String to, String subject, String message) {
		
		logger.info("Inside sendMail method");
		
		try {
			
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(mailFrom);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(message);
			simpleMailMessage.setTo(to);
			
			mailSender.send(simpleMailMessage);
			
			String success = "SENT";
			if(success.equalsIgnoreCase("SENT")) {
				return true;
			}else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
