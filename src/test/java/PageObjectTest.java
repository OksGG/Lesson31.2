
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page.BasePage;
import page.LoginPage;
import page.ProductsPage;


public class PageObjectTest extends BasePage {
    LoginPage loginPage;
    ProductsPage productsPage;


    public PageObjectTest() {
        super();
    }

    @Before
    public void init() {
        initialization();
        loginPage = new LoginPage();
        productsPage = new ProductsPage();

    }

    @Test
    public void loginPageTest() {
        LoginPage.positive();
        ProductsPage.sortByPriceHigh();
        ProductsPage.sortByPriceLow();
        ProductsPage.sortByNameAZ();
        ProductsPage.sortByNameZA();
    }


    @After
    public void close() {
        driver.quit();
    }
}
