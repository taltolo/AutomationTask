package com.helpers;
import java.util.Properties;
import javax.mail.*;

public class Utils {
    private Session session;
    private Properties props;
    private Store store;
    private javax.mail.Folder inboxFolder;

    public Utils(String userName, String password) throws MessagingException{
        props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        session = Session.getInstance(props, null);
        store = session.getStore("imaps");
        store.connect("imap.gmail.com",userName,password);
        inboxFolder = store.getFolder("Inbox");
        inboxFolder.open(Folder.READ_ONLY);
    }

    public Boolean checkSubjectMail(String subjectName ) throws MessagingException,Exception{
            for (int i=inboxFolder.getMessageCount(); i>0 ; i--) {
                if(inboxFolder.getMessage(i).getSubject().equals(subjectName)){
                    return true;
                }
            }
    return false;
    }


    public Boolean checkTextMail(String text) throws Exception{
        for (int i=inboxFolder.getMessageCount(); i>0 ; i--) {
            String content=inboxFolder.getMessage(i).getContent().toString().trim();
            if(content.equals(text)){
                return true;
            }
        }
return false;
    }



    public static void main(String[] args) throws Exception {
        Utils utilities=new Utils("baraktal105@gmail.com", "0105BT!!");
        Boolean found=utilities.checkSubjectMail("Test");
        Boolean text=utilities.checkTextMail("How r u?");
        if (found && text){
            System.out.println("Found");
        }

    }
}