package com.example.pfeesprit.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.example.pfeesprit.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class MailService {
	private JavaMailSender javaMailSender;


	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(User user) {


		SimpleMailMessage mail = new SimpleMailMessage();
	//	mail.setTo(user.getMail());
		//mail.setSubject("Testing Mail API");
		//mail.setText("u're hihih is done !!...");
		javaMailSender.send(mail);
	}


/*	public void sendEmailWithAttachment(User user) throws MessagingException{

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(user.getAddress());
		helper.setSubject("Testing Mail API with Attachment");
		helper.setText("Please find the attached document below.");

		ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
		helper.addAttachment(classPathResource.getFilename(), classPathResource);

		javaMailSender.send(mimeMessage);
	}*/

}