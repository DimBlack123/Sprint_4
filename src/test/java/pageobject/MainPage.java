package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public By orderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");

    public By firstImportantQuestion = By.xpath("//*[@id=\"accordion__heading-0\"]");

    public By firstImportantQuestionAnswer = By.xpath("//*[@id=\"accordion__panel-0\"]/p");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void scrollToFirstImportantQuestion() {
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(firstImportantQuestion)
        );
    }

    public void clickFirstImportantQuestion() {
        driver.findElement(firstImportantQuestion).click();
    }

    public String getAnswerOfFirstImportantQuestion() {
        return driver.findElement(firstImportantQuestionAnswer).getText();
    }

}
