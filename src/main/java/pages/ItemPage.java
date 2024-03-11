package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ItemPage {
    WebDriver driver;
    By itemName = By.xpath("//div[@class = 'inventory_details_name']");
    By addToCartButton = By.className("btn_inventory");
    By cartButton = By.id("shopping_cart_container");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public ItemPage isPageOpened(String item) {
        if (driver.findElement(itemName).getText().equals(item))
            return this;

        throw new RuntimeException("Wrong page");
    }
    public ItemPage clickAddToCart() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    public CartPage clickCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public ProductsPage back() {
        driver.navigate().back();
        return new ProductsPage(driver);
    }
}