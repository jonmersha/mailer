package com.besheger.mailer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailerController {
    @GetMapping("/")
    public MessageSSS appingTest(){
        return new MessageSSS();
    }
    @PostMapping("/em")
    public String sendEmail(@RequestBody MessageSSS message){
        if(message.getApiKey().equals("kzdjhlxasguiBWYXE24679HJKSYXFE9283787D213221"))
        return EmailSender.emailNotification(message.title,message.sender,message.message,message.receiver);
        return "Wrong API Key";
    }

}
