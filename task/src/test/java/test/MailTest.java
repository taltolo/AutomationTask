package test;
import task.Mail;
import org.junit.Test;

import models.User;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;

import com.helpers.ReadData;
import com.helpers.Utils;
import org.junit.Assert;
import org.junit.Before;


public class MailTest {
    private Mail mail;
    private Properties props;
    private Session session;
    Utils util;
    ArrayList<User>users=new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mail = new Mail();
        props=mail.getProperties();
        ReadData readData=new ReadData();
        users=readData.getData();
        session =mail.getSession(props, users.get(0).getEmail(), users.get(0).getPassword());
        util=new Utils(users.get(1).getEmail(), users.get(1).getPassword());
    }


    @Test
    public void sendMailTestingSuccessfully() throws Exception
    {
        mail.sendMail(session, users.get(0).getEmail(),users.get(1).getEmail(), users.get(0).getSubject(),users.get(0).getText());
        Boolean isMailSend=util.checkSubjectMail(users.get(0).getSubject());
        assertEquals(isMailSend, true);
    }

    @Test
    public void sendAmountOfMailTesting() throws Exception
    {      
            Boolean isMailSend;
            for (int i=0;i<10;i++){
                mail.sendMail(session, users.get(0).getEmail(),users.get(1).getEmail(), users.get(0).getSubject()+i,users.get(0).getText());
            }
            for (int i=0;i<10;i++){
                isMailSend=(util.checkSubjectMail(users.get(0).getSubject()+i));
                Assert.assertEquals(isMailSend, true);
            }
    }

    @Test
    public void sendMailTestingUnSuccessfully() throws Exception
    {
        mail.sendMail(session, users.get(0).getEmail(),users.get(1).getEmail(), users.get(0).getSubject(),users.get(0).getText());
        Boolean isMailSend=util.checkSubjectMail("edfgh");
        assertEquals(isMailSend, false);
    }

    @Test
    public void sendEmptyFromMail() throws Exception
    {
        mail.sendMail(session, "",users.get(1).getEmail(), users.get(0).getSubject(),users.get(0).getText());
        Boolean isMailSend=util.checkSubjectMail("edfgh");
        assertEquals(isMailSend, false);
    }

    @Test
    public void sendEmptySubjectMail() throws MessagingException
    {
        mail.sendMail(session, users.get(0).getEmail(),users.get(1).getEmail(), "",users.get(0).getText());
   
        try {
            Boolean checkSubject=util.checkSubjectMail("");
            assertEquals(checkSubject, true);
            Boolean checkText=util.checkTextMail(users.get(0).getText());
            assertEquals(checkText, true);
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }

    @Test
    public void sendEmptyTextMail() throws MessagingException
    {
        mail.sendMail(session, users.get(0).getEmail(),users.get(1).getEmail(), users.get(0).getSubject(),"");
   
        try {
            Boolean checkSubject=util.checkSubjectMail(users.get(0).getSubject());
            assertEquals(checkSubject, true);
            Boolean checkText=util.checkTextMail("");
            assertEquals(checkText, true);
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }

}
