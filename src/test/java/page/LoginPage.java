package page;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"user-name\"]")
    static WebElement user;

    @FindBy(xpath = "//*[@id=\"password\"]")
    static WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    static WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    static WebElement text;

    static String assertTextPositive = "PRODUCTS";


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public static void userLogin( String username, String pass) {
        user.sendKeys(username);
        password.sendKeys(pass);

    }

    public static void click() {
        loginButton.click();
    }

    public static void positive(){
        userLogin("standard_user", "secret_sauce");
        click();
        String pageText = text.getText();
        Assert.assertTrue(pageText.contains(assertTextPositive));
    }

}
