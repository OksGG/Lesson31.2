package page;

import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

@Log
public class ProductsPage extends BasePage {


    @FindBy(css = ".product_sort_container [value='za']")
    static WebElement nameZASort;

    @FindBy(css = ".product_sort_container [value='az']")
    static WebElement nameAZSort;

    @FindBy(css = ".product_sort_container [value='lohi']")
    static WebElement priceLowSelect;

    @FindBy(css = ".product_sort_container [value='hilo']")
    static WebElement priceHighSelect;

    @FindBy(css = ".product_sort_container")
    static WebElement productSort;

    static List<String> listBeforeSort;
    static List<String> listAfterSort;


    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }


    static List<String> getListOfPrices() {
        return driver.findElements(By.cssSelector(".inventory_item_price"))
                .stream().map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }

    static List<String> getListOfNames() {
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .stream().map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }


    public static void sortHighPrice() {
        productSort.click();
        priceHighSelect.click();
    }

    public static void sortLowPrice() {
        productSort.click();
        priceLowSelect.click();
    }

    public static void sortZAName() {
        productSort.click();
        nameZASort.click();
    }

    public static void sortAZName() {
        productSort.click();
        nameAZSort.click();
    }

    public static void sortByPriceHigh() {
        listBeforeSort = getListOfPrices();
        sortHighPrice();
        log.info(String.valueOf(listBeforeSort));
        listAfterSort = getListOfPrices();
        assertThat(listBeforeSort).isNotEqualTo(listAfterSort);
        log.info(String.valueOf(listAfterSort));
    }

    public static void sortByPriceLow() {
        listBeforeSort = getListOfPrices();
        sortLowPrice();
        log.info(String.valueOf(listBeforeSort));
        listAfterSort = getListOfPrices();
        assertThat(listBeforeSort).isNotEqualTo(listAfterSort);
        log.info(String.valueOf(listAfterSort));
    }

    public static void sortByNameAZ() {
        listBeforeSort = getListOfNames();
        sortAZName();
        log.info(String.valueOf(listBeforeSort));
        listAfterSort = getListOfNames();
        assertThat(listBeforeSort).isNotEqualTo(listAfterSort);
        log.info(String.valueOf(listAfterSort));

    }

    public static void sortByNameZA() {
        listBeforeSort = getListOfNames();
        sortZAName();
        log.info(String.valueOf(listBeforeSort));
        listAfterSort = getListOfNames();
        assertThat(listBeforeSort).isNotEqualTo(listAfterSort);
        log.info(String.valueOf(listAfterSort));
    }

}
