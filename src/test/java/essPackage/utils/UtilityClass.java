package essPackage.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UtilityClass {
    WebDriver driver;
    WebDriverWait wait;

    public UtilityClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void WaitForElement(WebElement ell) {
        wait.until(ExpectedConditions.visibilityOf(ell));

    }

    public List<WebElement> waitForElementList(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    // ✅ Stale-safe wait for locator (refreshed)
    public WebElement waitForElementWithStale(By locator) {
        return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfElementLocated(locator)));
    }
    // Wait for a fresh list of elements to avoid StaleElementReferenceException
    public List<WebElement> waitForFreshElements(List<WebElement> elements) {
        return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfAllElements(elements)
        ));
    }

    // ✅ Stale-safe click
    public void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(locator)));
        element.click();
    }

}

