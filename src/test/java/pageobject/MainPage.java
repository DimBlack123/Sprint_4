package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public By orderButton = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");

    public By firstImportantQuestion = By.xpath("//*[@id=\"accordion__heading-0\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void scrollToImportantQuestionsBlock() {
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(firstImportantQuestion)
        );
    }

    public String getAnswerOfImportantQuestion(String questionNumber) {
        driver.findElement(By.xpath(
                "//*[@id=\"accordion__heading-" + questionNumber +"\"]"
        )).click();
        return driver.findElement(By.xpath(
                "//*[@id=\"accordion__panel-" + questionNumber + "\"]/p"
        )).getText();
    }

}
