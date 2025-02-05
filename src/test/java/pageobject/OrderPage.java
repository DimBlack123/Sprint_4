package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class OrderPage {

    private final WebDriver driver;

    private final By name = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");

    private final By lastName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");

    private final By address = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");

    private final By subwayDropdown = By.xpath(
            "//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input"
    );

    private final By phone = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");

    private final By next = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillName(String nameValue) {
        driver.findElement(name).sendKeys(nameValue);
    }

    public void fillLastName(String lastNameValue) {
        driver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void fillAddress(String addressValue) {
        driver.findElement(address).sendKeys(addressValue);
    }

    public void chooseSubwayStation(String subwayValue) throws InterruptedException {
        driver.findElement(subwayDropdown).click();
        sleep(100);
        driver.findElement(By.xpath("//*[contains(text(),'" + subwayValue + "')]")).click();
    }

    public void fillPhone(String phoneValue) {
        driver.findElement(phone).sendKeys(phoneValue);
    }

    public void clickNext() {
        driver.findElement(next).click();
    }

}
