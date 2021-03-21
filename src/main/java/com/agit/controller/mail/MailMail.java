/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.controller.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author TriAA
 */
public class MailMail {

    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    /**
     *
     * @param simpleMailMessage
     */
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    /**
     *
     * @param mailSender
     */
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     *
     * @param dear
     * @param content
     */
    public void sendMail(String dear, String content) {

        SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);

        message.setText(String.format(
                simpleMailMessage.getText(), dear, content));

        mailSender.send(message);

    }
}
