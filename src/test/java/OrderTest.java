import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;
import pageobject.OrderDetailPage;
import pageobject.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest {

    WebDriver driver;
    private final String driverValue;
    private final String name;
    private final String lastName;
    private final String address;
    private final String subway;
    private final String phone;
    private final String date;
    private final String rentDuration;
    private final String color;
    private final Boolean comment;

    public OrderTest(String driverValue,
                     String name,
                     String lastName,
                     String address,
                     String subway,
                     String phone,
                     String date,
                     String rentDuration,
                     String color,
                     Boolean comment
    ) {
        this.driverValue = driverValue;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
        this.date = date;
        this.rentDuration = rentDuration;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {
                        "chrome",
                        "Жора",
                        "Корнев",
                        "Адрес1",
                        "Бульвар Рокоссовского",
                        "00000000000",
                        "01.12.2024",
                        "сутки",
                        "black",
                        true
                }
                ,
                {
                        "firefox",
                        "Катя",
                        "Брусникина",
                        "Адрес2",
                        "Черкизовская",
                        "+1111111111",
                        "02.12.2024",
                        "двое суток",
                        "grey",
                        false
                }
        };
    }

    @Test
    public void checkOrder() throws InterruptedException {
        if (driverValue.equals("chrome"))
            driver = new ChromeDriver();
        else if (driverValue.equals("firefox"))
            driver = new FirefoxDriver();

        driver.get(TestConstants.APP_URL);

        MainPage mainPage = new MainPage(driver);

        mainPage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);

        orderPage.fillName(name);

        orderPage.fillLastName(lastName);

        orderPage.fillAddress(address);

        orderPage.chooseSubwayStation(subway);

        orderPage.fillPhone(phone);

        orderPage.clickNext();

        OrderDetailPage orderDetailPage = new OrderDetailPage(driver);

        orderDetailPage.fillDate(date);

        orderDetailPage.chooseRentDuration(rentDuration);

        orderDetailPage.fillColor(color);

        if (comment) orderDetailPage.fillComment();

        orderDetailPage.clickOrder();

        orderDetailPage.clickConfirm();

        assertTrue(orderDetailPage.isConfirmed());

        driver.quit();
    }

}
