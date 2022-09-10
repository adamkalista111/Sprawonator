import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends Config{

    public Login(String[] args) {
        super(args);
        // TODO Auto-generated constructor stub
    }

    boolean logToStars(ChromeDriver driver) throws Exception {
        try {


            String loginVal;

            WebDriverWait wait = new WebDriverWait(driver, 5);
            driver.get("https://stars-emea.nsroot.net/siteminderagent/forms/login.fcc?TYPE=33554433&REALMOID=06-000561b4-016b-1a6d-9125-ae06a950f0f1&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-fDddgdKgOCuLxZlMfqwUnCYqVuUTgGM78M91%2bCxKQMiAzmOuwJ6k4FR1Hy0PykTm&TARGET=-SM-%2fprweb%2fSSOServlet%2fhzhP9HwhB2H6CmVkCOWsjQ[[*%2f!STANDARD");


            //LOGIN
            driver.findElement(By.className("textinput")).sendKeys(sso);
            driver.findElement(By.name("PASSWORD")).sendKeys(password);
            driver.findElement(By.className("ButtonSm")).click();

            //LOGIN VALIDATION
            if(!driver.findElementsByClassName("pageheader").isEmpty()) {
                loginVal = driver.findElementByClassName("pageheader").getAttribute("innerHTML");
                if(loginVal.toLowerCase().contains("fail"))
                {

                    throw new Exception("10"); //10 Bad Login
                }
            }

            //PRZYCISK OK
            wait.until(ExpectedConditions.elementToBeClickable(By.className("pzbtn-mid")));
            driver.findElement(By.className("pzbtn-mid")).click();;     
            TimeUnit.SECONDS.sleep(1);

        }
        catch(Exception e){
            e.printStackTrace();
            if (e.getMessage().equals("10")) {//10 Bad Login
                throw e; //10 Bad Login
            }
            else {
            throw new Exception("11"); //11 Error While Login
            }
        }
        return true;
    }

    public  boolean CaseOpen(ChromeDriver driver) throws Exception{
        try {

            WebDriverWait wait = new WebDriverWait(driver, 5); 

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='menu Create Other Case']")));
            driver.findElement(By.xpath("//*[@aria-label='menu Create Other Case']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Create Cash Service Case']")));
            driver.findElement(By.xpath("//*[@title='Create Cash Service Case']")).click();

        }catch(Exception e){
            throw new Exception ("12"); // 12 Starting Case Error 

        }

        return true;
    }

}