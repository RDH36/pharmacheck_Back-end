package com.inclusiv.cdan3.pharmacheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
@Service
public class ServiceNotification {
    @Autowired
    JavaMailSender javaMailSender = getJavaMailSender();

    public boolean sendMailTo(String adresseMail, String subject, String text) {
        try {
            var message = new SimpleMailMessage();

            message.setFrom("email.oio.ids@gmail.com");
            message.setTo(adresseMail);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private JavaMailSender getJavaMailSender() {
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("simplice2236@gmail.com");
        mailSender.setPassword("0348664121");

        var props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    public void sendMailWithAttachement(String toEmail,
                                        String body,
                                        String subject,
                                        String attachement) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("simplice2236@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attachement));
        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);

        javaMailSender.send(mimeMessage);
    }
}
