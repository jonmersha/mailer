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
    public String sendEamil(@RequestBody MessageSSS message){
        return EmailSender.emailNotification(message.title,message.sender,message.message,message.receiver);
    }

}
