package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){
        /*
        We are preventing access to the object of this class from outside the class by creating a private constructor
         */

    }
    /*
    We create Webdriver as private to prevent access from outside the class.
    We declared it as static because we'll use it in a static method. In addition to this, we'll have all the benefits of static.
     */

  //  private static WebDriver driver;//value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool=new InheritableThreadLocal<>();



    /*
    Create a re-usable utility method which will return same driver instance when we call it.
     */
    public static WebDriver getDriver(){

        if (driverPool.get()==null){

            /*
            We read our browserType from ConfigurationReader.getProperty.
            We can control which browser is opened from outside our code by this way, from ConfigurationReader.getProperty.
             */
            String browserType= ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType that will return from configuration.properties file
             switch statement will determine the case and open the matching browser
             */

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }

        return  driverPool.get();
    }

    //driver.quit() --> noSuchSession
    //driver.close() -->
    //try to create a method called closeDriver()
    /*
    This method will make us sure that driver value is always null after using quit() method,
     which means we restart everything for the preciding test from scratch.
     */

    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();//This line will terminate the existing session, value will not be given null.
            driverPool.remove(); //We are assigning the driver as null ourselves to make sure when quit() closes the session,
            // driver will be null again. So when I call driver again, it'll check if the driver is null or not.
        }
    }

}
