package org.CodeWithDurgesh;
import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 * String message
 * String subject
 * String to
 * String from
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Preparing to send email" );
        String message = "Jai shree ram";
        String subject = "Namaskar";
        String to ="satyamjaiswal91@gmail.com";
        String from = "satyamjaiswal08795@gmail.com";
        sendEmail(message,subject,to,from);
    }

    private static void sendEmail(String message, String subject, String to, String from) {
        //variable for gmail
        String host = "smtp.gmail.com";

        //fetch the system properties
        Properties prop = System.getProperties();
       // System.out.println("The system properties are--->"+prop);

        //setting important information to properties object
        //host set
        prop.put("mail.smtp.host",host);
        prop.put("mail.smtp.port","465");
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.auth","true");

        //Step1: get the session object
        Session mailSession = Session.getInstance(prop,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("satyamjaiswal08795@gmail.com","kzkspziftobbbhpf");
            }
        });

        mailSession.setDebug(true);     //find error
        //Step2: Compose the message-->Text,Attachements(photo,video,pdf);
        MimeMessage mimeMessage = new MimeMessage(mailSession);
        try {
            //set from
            mimeMessage.setFrom(from);

            //adding recipients
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));

            //adding subject to message
            mimeMessage.setSubject(subject);

            //adding content
            mimeMessage.setText(message);

            //Step 3: Send using transport class
            //send
            Transport.send(mimeMessage);

            System.out.println("Sent successfully");
        } catch (Exception e) {
            System.out.println(e);;
        }
    }

}
