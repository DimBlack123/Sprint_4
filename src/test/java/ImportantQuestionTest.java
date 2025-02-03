import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import static org.junit.Assert.assertEquals;

public class ImportantQuestionTest {

    @Test
    public void checkImportantQuestion() {
        WebDriver driver = new ChromeDriver();

        driver.get(TestConstants.APP_URL);

        MainPage mainPage = new MainPage(driver);

        mainPage.scrollToFirstImportantQuestion();

        mainPage.clickFirstImportantQuestion();

        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                mainPage.getAnswerOfFirstImportantQuestion()
        );

        driver.quit();
    }

}
