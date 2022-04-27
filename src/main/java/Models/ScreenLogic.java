package Models;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenLogic {
    WebDriver driver;
    public ScreenLogic(WebDriver driver) {
        this.driver = driver;
    }
        String imageName =".png";

        public void addScreenshot(WebDriver driver,String Regional,String ProviderName,String Gamename) throws IOException,
                ClassNotFoundException, InterruptedException {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                System.out.println("stexaaaaaaaaa");
                System.out.println("C:\\CasionoRegions\\"+Regional+"\\"+ProviderName+"\\"+Gamename + imageName);
                FileUtils.copyFile(scrFile, new File("C:\\CasionoRegions\\"+Regional+"\\"+ProviderName+"\\"+Gamename + imageName));

            }catch (Exception e){}
        }
    }
