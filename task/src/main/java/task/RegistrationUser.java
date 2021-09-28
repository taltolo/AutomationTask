package task;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.helpers.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationUser extends BasePage{

    private WebDriver driver;
    @FindBy(name="firstName")
    WebElement firstNameElementField;
    @FindBy(name="lastName")
    WebElement lastNameElementField;
    @FindBy(name="username")
    WebElement usernameElementField;
    @FindBy(name="Passwd")
    WebElement passwordElementField;
    @FindBy(name="Confirmpasswd")
    WebElement ConfirmpasswdElementField;
    @FindBy(name="accountDetailNext")
    WebElement nextButton;
    By mainPageTitle=By.id("headingText");
    

    public RegistrationUser(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    private void fillField(WebElement field, String value){
        field.sendKeys(value);
    }

    public void fillFirstName(String firstName){
        this.fillField(firstNameElementField, firstName);
    }
    public void fillLastName(String lastName){
        this.fillField(lastNameElementField, lastName);
    }
    public void fillUserName(String userName){
        this.fillField(usernameElementField, userName);
    }
    public void fillPassword(String password){
        this.fillField(passwordElementField, password);
    }
    public void fillConfirmPassword(String confirmPassword){
        this.fillField(ConfirmpasswdElementField, confirmPassword);
    }
    public void clickOnNextButton(){
        nextButton.click();
    }
    public Boolean validatePageTitle(String expectedTitle){
        String actualTitle=driver.findElement(mainPageTitle).getText();
        return actualTitle.equals(expectedTitle);
    }
    

    public static void main(String[] args) throws IOException, GeneralSecurityException  {
        System.setProperty("webdriver.chrome.driver","C:/Users/Tal/GettTask/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        RegistrationUser registrationUser=new RegistrationUser(driver);
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=SignUp");

    }





}
