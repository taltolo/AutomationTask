package task;

import com.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login extends BasePage {

    private WebDriver driver;
    @FindBy(id="identifierId")
    WebElement userNameField;
    @FindBy(id="password")
    WebElement passwordFiled;
    @FindBy(id="identifierNext")
    WebElement nextButton;
    @FindBy(id="passwordNext")
    WebElement passwordNextButton;


    public Login(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public Boolean insertUserName(String userName){
        WebElement userNameElement=driver.findElement((By) userNameField);
        return super.insertText(userNameElement,userName);
        
    }
    public void insertPassword(String password){
        try{
            passwordFiled.sendKeys(password);
        }
        catch(ElementNotInteractableException e){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            passwordFiled.sendKeys(password);
        }
        
    }

    public void clickOnNextButton(){
        nextButton.click();
    }
    public void clickOnPasswordNextButton(){
        passwordNextButton.click();
    }
}
