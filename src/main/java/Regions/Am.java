package Regions;

import Models.GlobalModel;
import Models.LoginPass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class Am {

//    public Am() {
//        PageFactory.initElements(getDriver(), this);
//    }
  //  levonhambardzumyan10@gmail.com
    @Test
    public void Login() throws InterruptedException {
        GlobalModel Model = new GlobalModel();
        Model.GoTO(LoginPass.VivaroUrl, "hayk.hambardzumyan@betconstruct.com", "Shazam.21");
    }


}
