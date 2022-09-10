import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class NonClient extends Sprawa{

    public NonClient(String line) {
        super(line);
        // TODO Auto-generated constructor stub
    }

    public String BeginCase(ChromeDriver driver) throws Exception {
        try {

            WebDriverWait wait = new WebDriverWait(driver, 15);

            //Wybór noclient i wprowadzanie danych
            driver.switchTo().frame("PegaGadget0Ifr");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("CaseCreationModeNonClient")).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("FirstName")));
            JavascriptExecutor jse = (JavascriptExecutor)driver;


            try {

                driver.findElement(By.id("FirstName")).sendKeys(Name);

                jse.executeScript("document.getElementById('LastName').value='" + LastName + "';");
                if(Email!=null && !Email.isEmpty()) {
                    jse.executeScript("document.getElementById('Internal_Email').value='" + Email + "';");
                }
                jse.executeScript("document.getElementById('NonClientType').value='" + "3rd Party" + "';");
                if(PhoneNumber!=null && !PhoneNumber.isEmpty()) {
                    jse.executeScript("document.getElementById('Phone').value='" + PhoneNumber + "';");
                }

            }catch(Exception e){
                e.printStackTrace();
                throw new Exception ("300"); //300  Input Info Error
            }

            Smart(driver,wait);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("IsSelfServiceableNo")));
            TimeUnit.SECONDS.sleep(4);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("IsSelfServiceableNo")));

            CaseSubmit(driver,wait);

            return CaseFinish(driver,wait);

        }catch(Exception e){
            e.printStackTrace();
            if(e.getMessage().equals("1009;"+ErrMsg)) {// 1009 unknown error
                throw new Exception("1009;"+ErrMsg);// 1009 unknown error
            }

            throw new Exception (e.getMessage());
        }
    }

}