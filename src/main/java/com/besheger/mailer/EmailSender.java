package com.besheger.mailer;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailSender {

    public static String emailNotification(String subject,String from,String message,String destination) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.besheger.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("yohannes@besheger.com", "Yohannes@hira123");
            }
        });

        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from, false));
        } catch (MessagingException e) {
            return e.getLocalizedMessage();
        }

        try {
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destination));
        } catch (MessagingException e) {
            return e.getLocalizedMessage();
        }
        try {
            msg.setSubject(subject);
        } catch (MessagingException e) {
            return e.getLocalizedMessage();
        }

        try {
            msg.setContent(message, "text/html");
        } catch (MessagingException e) {
            return e.getLocalizedMessage();
        }
        try {
            msg.setSentDate(new Date());
        } catch (MessagingException e) {
            return e.getLocalizedMessage();
        }

        try {
            Transport.send(msg);
        } catch (MessagingException e) {
            return e.getLocalizedMessage();
        }
        return "Message Sent";
    }


}
