package test;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import models.User;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import com.helpers.ReadData;

import task.RegistrationUser;

public class RegistrationUserTest {
    public String createAccountUrl="https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=SignUp";
    ArrayList<User>users=new ArrayList<>();
  
    @Before
    public void setUp() throws IOException  {
         users=ReadData.getData();
        }

  
    @org.junit.Test
    public void createValidAccountTest(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName(users.get(0).getFirstName());
        registrationUser.fillLastName(users.get(0).getLastName());
        registrationUser.fillUserName(users.get(0).getUserame());
        registrationUser.fillPassword(users.get(0).getPassword());
        registrationUser.fillConfirmPassword(users.get(0).getPassword());
        registrationUser.clickOnNextButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        Boolean result =registrationUser.validatePageTitle("Verify your phone number\n");
        assertTrue(result);
    }

    @org.junit.Test
    public void createInValidEmptyAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }

    
    @org.junit.Test
    public void createInValidEmptyFirstNameAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName("");
        registrationUser.fillLastName(users.get(0).getLastName());
        registrationUser.fillUserName(users.get(0).getUserame());
        registrationUser.fillPassword(users.get(0).getPassword());
        registrationUser.fillConfirmPassword(users.get(0).getPassword());
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }

    @org.junit.Test
    public void createInValidEmptyLastNameAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName(users.get(0).getFirstName());
        registrationUser.fillLastName("");
        registrationUser.fillUserName(users.get(0).getUserame());
        registrationUser.fillPassword(users.get(0).getPassword());
        registrationUser.fillConfirmPassword(users.get(0).getPassword());
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }

    @org.junit.Test
    public void createInValidEmptyUserameAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName(users.get(0).getFirstName());
        registrationUser.fillLastName(users.get(0).getLastName());
        registrationUser.fillUserName("");
        registrationUser.fillPassword(users.get(0).getPassword());
        registrationUser.fillConfirmPassword(users.get(0).getPassword());
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }

    @org.junit.Test
    public void createInValidEmptyPasswordAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName(users.get(0).getFirstName());
        registrationUser.fillLastName(users.get(0).getLastName());
        registrationUser.fillUserName(users.get(0).getUserame());
        registrationUser.fillPassword("");
        registrationUser.fillConfirmPassword(users.get(0).getPassword());
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }

    @org.junit.Test
    public void createInValidEmptyConfirmPasswordAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName(users.get(0).getFirstName());
        registrationUser.fillLastName(users.get(0).getLastName());
        registrationUser.fillUserName(users.get(0).getUserame());
        registrationUser.fillPassword(users.get(0).getPassword());
        registrationUser.fillConfirmPassword("");
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }

    @org.junit.Test
    public void createInValidPasswordAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName(users.get(2).getFirstName());
        registrationUser.fillLastName(users.get(2).getLastName());
        registrationUser.fillUserName(users.get(2).getUserame());
        registrationUser.fillPassword(users.get(2).getPassword());
        registrationUser.fillConfirmPassword(users.get(2).getPassword());
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }

    
    @org.junit.Test
    public void createInValidPasswordMatchAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName(users.get(1).getFirstName());
        registrationUser.fillLastName(users.get(1).getLastName());
        registrationUser.fillUserName(users.get(1).getUserame());
        registrationUser.fillPassword(users.get(1).getPassword());
        registrationUser.fillConfirmPassword(users.get(1).getPassword()+"AA");
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }

    @org.junit.Test
    public void createInValidUsernameAccountTest() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get(createAccountUrl);
        registrationUser.fillFirstName(users.get(2).getFirstName());
        registrationUser.fillLastName(users.get(2).getLastName());
        registrationUser.fillUserName(users.get(2).getUserame());
        registrationUser.fillPassword(users.get(2).getPassword());
        registrationUser.fillConfirmPassword(users.get(2).getPassword());
        registrationUser.clickOnNextButton();
        Boolean result =registrationUser.validatePageTitle("Create your Google Account");
        assertTrue(result);
   
    }


}
