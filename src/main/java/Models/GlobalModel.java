package Models;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class GlobalModel {
    // public static  WebDriver driver ;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public GlobalModel() {
        PageFactory.initElements(getDriver(), this);
    }

    @BeforeTest
    public void LogPopup(String Login, String Pass) throws InterruptedException {
        Thread.sleep(1500);
        Thread.sleep(400);
        Click(By.cssSelector("#signin-reg-buttons > ul > li:nth-child(1) > button"));
        Thread.sleep(1500);
        sendKeys(By.cssSelector("#signinform-login-input"), Login);
        Thread.sleep(350);
        sendKeys(By.cssSelector("#signinform-password-input"), Pass);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);

            String SignInactiveorNot =getDriver().findElement((By.cssSelector(".button-confirm>button"))).getAttribute("disabled");
            if (SignInactiveorNot == null) {
                Thread.sleep(350);
                Click(By.cssSelector(".button-confirm>button"));
                for (int u = 0; u < 20; u++) {
                    Thread.sleep(500);
                    try {
                        String compareDeposit = getTextAttr(By.cssSelector(".cms-jcon-deposit"), "class");
                        System.out.println(compareDeposit);
                        System.out.println("Tool is logined in Vbet");
                        break;
                    } catch (Exception notLogined) {
                        if (u == 20) {
                            System.out.println("Can not Login to The system");
                            break;
                        }
                    }
                }
                break;
            }
            if (i == 20) {
                getDriver().navigate().refresh();
                System.out.println("Refresh page");
                LogPopup(Login, Pass);
            }
        }
    }
    public void GoTO(String Url, String Login, String Pass) throws InterruptedException {
        System.setProperty(LoginPass.Chrome, LoginPass.ChromePath);
        setDriver();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Page is full Loaded");
        getDriver().get(Url);
        String HomePageUrl = getDriver().getCurrentUrl();
        System.out.println(HomePageUrl);
        getDriver().manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);
        try {
            try {
                Thread.sleep(1500);
                Click(By.cssSelector(".close-j"));
                Thread.sleep(500);
                LogPopup(Login, Pass);


            } catch (Exception onePopuP) {
                LogPopup(Login, Pass);

            }
        } catch (Exception je) {
            Click(By.cssSelector(".close-j"));
            LogPopup(Login, Pass);

        }

        try {
            try {
                Thread.sleep(700);

                Click(By.cssSelector("[ng-href='#/casino/']"));

            } catch (Exception e) {
                Thread.sleep(500);
                Click(By.cssSelector(".close-j"));
                Click(By.cssSelector("[ng-href='#/casino/']"));

            }
        } catch (Exception arancpoop) {
            Thread.sleep(500);
            Click(By.cssSelector(".close-j"));

            Click(By.cssSelector("[ng-href='#/casino/']"));
        }
    }

    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
//        options.addArguments("window-size=1400,800");
//        options.addArguments("disable-gpu");
       // driver.set(new ChromeDriver(options));
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void Click(By e) throws InterruptedException {
        waitForVisibility(getDriver().findElement(e));
        getDriver().findElement(e).click();
    }

    public String GetText(By e) throws InterruptedException {
        waitForVisibility(getDriver().findElement(e));
        return getDriver().findElement(e).getText();
    }

    public String getTextAttr(By e, String attribute) {
        String txt = null;
        txt = getDriver().findElement(e).getAttribute(attribute).toString();
        return txt;
    }


    public void IndexClick(By e, int index) throws InterruptedException {
        waitForVisibility(getDriver().findElement(e));
        getDriver().findElements(e).get(index).click();
    }

    public void Clickable(By e) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void sendKeys(By e, String txt) {
        waitForVisibility(getDriver().findElement(e));
        getDriver().findElement(e).sendKeys(txt);
    }
}



