/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration.SceneBuilder;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mahmoud
 */
public class AdminMailer {
    
    
    public void send(String mail){
        
          String myEmail = "omranimahmoud@gmail.com";
            String password = "facecheckdisnuts";
  String opponentEmail = mail;
  Properties pro = new Properties();
  pro.put("mail.smtp.host", "smtp.gmail.com");
  pro.put("mail.smtp.starttls.enable", "true");
  pro.put("mail.smtp.auth", "true");
  pro.put("mail.smtp.port", "587");
  Session ss = Session.getInstance(pro, new javax.mail.Authenticator() {
   @Override
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(myEmail, password);
   }
  });
  try {
   Message msg = new MimeMessage(ss);
   msg.setFrom(new InternetAddress(myEmail));
   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(opponentEmail));
   msg.setSubject("Administration");
   msg.setText("Bonjour , votre compte est activé");
   Transport trans = ss.getTransport("smtp");
   trans.send(msg);
   System.out.println("message sent !! ");
  } catch (Exception e) {
   System.out.println(e.getMessage());
  }
 }
    
    //Test Mailing API !! 
//      public static void main(String[] args) {
//         AdminMailer send = new AdminMailer();
//         String mail = "mahmoud.omrani@esprit.tn";
//            send.send(mail);
//    }  
}

      

