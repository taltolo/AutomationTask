package task;

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
public class Mail{  

public static Session getSession(Properties props,final String fromMail,final String passwordMail ){
    Session session = Session.getDefaultInstance(props,    
    new javax.mail.Authenticator() {    
    protected PasswordAuthentication getPasswordAuthentication() {    
    return new PasswordAuthentication(fromMail,passwordMail);  
    }    
   });  

   return session;
}

public static void sendMail(Session session,String from,String to,String sub,String msg ){
    try {    
        MimeMessage message = new MimeMessage(session);    
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
        message.setSubject(sub);    
        message.setText(msg);    
        //send message  
        Transport.send(message);    
        System.out.println("message sent successfully");    
       } catch (MessagingException e) {
           throw new RuntimeException(e);
        }  
}

public static Properties getProperties(){
    Properties props = new Properties();    
    props.put("mail.smtp.host", "smtp.gmail.com");    
    props.put("mail.smtp.socketFactory.port", "465");    
    props.put("mail.smtp.socketFactory.class",    
            "javax.net.ssl.SSLSocketFactory");    
    props.put("mail.smtp.auth", "true");    
    props.put("mail.smtp.port", "465");  
    return props;
}

  

 public static void main(String[] args) { 
    Properties props=getProperties();  
    Session session =getSession(props, "taltolo993@gmail.com", "11081993");
    sendMail(session, "taltolo993@gmail.com","taltal7570366@gmail.com", "","How r u?");
 }    
 
} 