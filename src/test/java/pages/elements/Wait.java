package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    private static Wait instance;

    private static Wait getInstance(WebDriver driver){
        if (instance==null){
            instance=new Wait(driver);
        }
        return instance;
    }
    private final WebDriverWait wait;
    public Wait(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
    }
    public void waitUntilClickable(WebDriver driver, final WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
