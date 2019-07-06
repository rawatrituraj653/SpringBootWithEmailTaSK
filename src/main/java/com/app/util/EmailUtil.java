package com.app.util;

import java.util.StringTokenizer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.EmailModel;


@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;
	public boolean send(EmailModel email,MultipartFile file) {
	
	
		MimeMessage message=sender.createMimeMessage();
		boolean flag=false;
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setTo(email.getUserTo());
			helper.setSubject(email.getSubject());
			helper.setText(email.getMessage());
			
			  if(email.getUserBcc()!=null) { 
				 /*StringTokenizer token=new StringTokenizer(email.getUserBcc(), ","); 
				 String[] bcc=new String[token.countTokens()]; 
				 int i=0; 
				 while(token.hasMoreTokens()) {
					bcc[i]=  token.nextToken(); 
					i++;
				  }*/   
				String[] bcc=email.getUserBcc().split(",");
			  helper.setBcc(bcc);
			  }
			
				
			if(email.getUserCc()!=null) {
				StringTokenizer token=new StringTokenizer(email.getUserCc(),",");
				String []cc=new String[token.countTokens()];
				int i=0;
				while(token.hasMoreTokens()){
				cc[i]=token.nextToken();
				}
			helper.setCc(cc);	
			}
			if(file!=null) {
				helper.addAttachment(file.getOriginalFilename(), file);
		}	
		sender.send(message);
		flag=true;
		} catch (MessagingException e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
}
