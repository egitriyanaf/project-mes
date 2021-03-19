package com.agit.controller.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author erwin
 */
public class App 
{

    /**
     *
     * @param args
     */
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("Ridwan OB", "Silahkan cek aprroval ada barang yang akan ditransfer");
    }
}
