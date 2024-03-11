import org.testng.Assert;
import org.testng.Converter;
import org.testng.annotations.Test;
import static utils.Converter.getPrice;

public class CheckPriceTest extends BaseTest{

    @Test
    public void test(){
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .clickItem("Sauce Labs Bolt T-Shirt")
                .isPageOpened("Sauce Labs Bolt T-Shirt")
                .clickAddToCart()
                .back()
                .clickItem("Sauce Labs Backpack")
                .isPageOpened("Sauce Labs Backpack")
                .clickAddToCart()
                .clickCart()
                .clickCheckOut()
                .fillingForm("Евдокия", "Ильина", "123456");

        Assert.assertEquals(getPrice(checkoutOverviewPage.getTotalPrice()),
                getPrice(checkoutOverviewPage.getItemPrice()) + getPrice(checkoutOverviewPage.getTaxPrice()));
    }
}
