package com.example.mail_sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);


        //SimpleMailMessage message = new SimpleMailMessage();
        helper.setFrom("yucheng2k13@gmail.com");
        helper.setTo("yucheng2k13@icloud.com");
        helper.setSubject("主旨：Hello yucheng");
        helper.setText("內容：這是一封spring boot測試信件，恭喜您成功發送了唷\n");

        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\yucheng\\Desktop\\mail_sender\\happy.jpg"));
        helper.addAttachment("happy.jpg", file);

        mailSender.send(mimeMessage);
    }

}
