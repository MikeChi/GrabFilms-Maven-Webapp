package com.chi.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SimpleMailSender {
	 
	 public static boolean send(String username,String password,String recipient,String subject,Object content) {		    
		    Properties props = new Properties();		    
			props.put("mail.smtp.auth", "true");
			props.put("mail.transport.protocol", "smtp");
			String hostSmtp = null;
			try {
				 hostSmtp = "smtp."+username.split("@")[1];
			} catch (ArrayIndexOutOfBoundsException e) {				
				System.out.println("输入用户的邮箱错误");
				System.out.println("catch到错误，代码在此处停止执行");
				return false;
			}			
			props.put("mail.smtp.host", hostSmtp);
			Session session = Session.getInstance(props);
			Transport transport = null;
			Message message = new MimeMessage(session);			
			try{
				message.setFrom(new InternetAddress(username));
				//主题
				message.setSubject(subject);
				//内容
				message.setText(content.toString());
				transport = session.getTransport();
				transport.connect(hostSmtp, 25, username, password);
				transport.sendMessage(message, new Address[]{new InternetAddress(recipient)});
				return true;
			}catch (AddressException e1) {
				System.out.println("输入的收件人的邮箱错误");
				return false;
			}catch (MessagingException e2) {
				e2.printStackTrace();
				return false;
			}finally{
				if(transport != null)
					try {
						transport.close();
					} catch (MessagingException e) {
						e.printStackTrace();
					}
			}
		 
	 }	 
     
}
