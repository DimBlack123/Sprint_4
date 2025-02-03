package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class OrderDetailPage {

    private final WebDriver driver;

    private final By dateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");

    private final By rentDurationDropdown = By.xpath(
            "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]"
    );

    private final By comment = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");

    private final By order = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    private final By confirm = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    public OrderDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDate(String dateValue) {
        driver.findElement(dateField).sendKeys(dateValue);
        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void chooseRentDuration(String rentDurationValue) {
        driver.findElement(rentDurationDropdown).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + rentDurationValue + "')]")).click();
    }

    public void fillColor(String colorValue) {
        driver.findElement(By.xpath("//*[@id=\"" + colorValue + "\"]")).click();
    }

    public void fillComment() {
        driver.findElement(comment).sendKeys("комментарий");
    }

    public void clickOrder() {
        driver.findElement(order).click();
    }

    public void clickConfirm() {
        driver.findElement(confirm).click();
    }

    public Boolean isConfirmed() {
        return driver.findElement(By.xpath("//*[contains(text(),'Заказ оформлен')]")).isEnabled();
    }

}
