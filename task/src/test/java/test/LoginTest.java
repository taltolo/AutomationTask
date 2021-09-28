package test;

import java.io.IOException;
import java.util.ArrayList;

import com.helpers.ReadData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import models.User;
import task.Login;

public class LoginTest {
    String actualUrl;
    WebDriver driver;
    ArrayList<User>users=new ArrayList<>();
    @Before
    public void setUp() throws IOException  {
         actualUrl="https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";   
         System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
         driver=new ChromeDriver();
         users=ReadData.getData();
         
        }


@Test
    public void validLogin(){
        Login login=new Login(driver);
        driver.get(actualUrl);
        Boolean result= login.insertUserName(users.get(0).getEmail());
        Assert.assertTrue("Insert userName filed has failed", result);
        login.clickOnNextButton();
        login.insertPassword(users.get(0).getPassword());
        login.clickOnPasswordNextButton();
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertNotSame(actualUrl, expectedUrl);
    }


@Test
    public void EmptyPasswordLogin(){
        Login login=new Login(driver);
        driver.get(actualUrl);
        Boolean result= login.insertUserName("");
        Assert.assertTrue("Insert userName filed has failed", result);
        login.clickOnNextButton();
        login.insertPassword(users.get(0).getPassword());
        login.clickOnPasswordNextButton();
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void EmptyUsernameLogin(){
        Login login=new Login(driver);
        driver.get(actualUrl);
        Boolean result= login.insertUserName(users.get(0).getEmail());
        Assert.assertTrue("Insert userName filed has failed", result);
        login.clickOnNextButton();
        login.insertPassword("");
        login.clickOnPasswordNextButton();
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void EmptyLogin(){
        Login login=new Login(driver);
        driver.get(actualUrl);
        Boolean result= login.insertUserName("");
        Assert.assertTrue("Insert userName filed has failed", result);
        login.clickOnNextButton();
        login.insertPassword("");
        login.clickOnPasswordNextButton();
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
