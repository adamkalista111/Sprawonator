import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class Account extends Sprawa{

    public Account(String line) {
        super(line);
        // TODO Auto-generated constructor stub
    }

    public String Accreturn (String konto) {
        String zwrotka= null;
        boolean stop = false;

        if(konto.length() >=14){
            char[] ciag = konto.substring(konto.length() - 14,konto.length()).replaceAll("\\s","").toCharArray();

            int i = 0;
            while (!stop){


                if (ciag[i] !='0') {
                    ciag = Arrays.copyOfRange(ciag, i, ciag.length);
                    System.out.print(ciag);
                    stop =true;
                }
                if(i>=ciag.length) {
                    stop =true;
                }
                i++;
            }       
        zwrotka = String.valueOf(ciag);
        }
        else {
            zwrotka = konto.replaceAll("\\s","");

        }

        return zwrotka;
    }


    public String BeginCase(ChromeDriver driver) throws Exception {
        try {
            int width;
            boolean foundName;
            boolean foundLast;
            boolean userFound= false;

            String AccAfterChange;

            JavascriptExecutor jse = (JavascriptExecutor)driver; 

            WebDriverWait wait = new WebDriverWait(driver, 15);/// i to

            try {
                driver.switchTo().frame("PegaGadget0Ifr");
                TimeUnit.SECONDS.sleep(1);

                wait.until(ExpectedConditions.elementToBeClickable(By.id("AccountNumber")));

                width= driver.findElement(By.id("ContactName")).getSize().getWidth();

                AccAfterChange = Accreturn(Token_Account);

                if (AccAfterChange.length()>= 9) {
                    jse.executeScript("document.getElementById('Branch').value='" + "815" + "';");
                }
                else {
                    jse.executeScript("document.getElementById('Branch').value='" + "889" + "';");
                }

                driver.findElement(By.id("AccountNumber")).sendKeys(AccAfterChange);
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
                TimeUnit.SECONDS.sleep(2);

                driver.executeScript("arguments[0].dispatchEvent(new Event('change'))", driver.findElement(By.id("AccountNumber"))); 

                wait.until((Check) ->driver.findElement(By.id("ContactName")).getSize().getWidth()!=width); //lambda expression czekające na zmiane rozmiaru pola

                TimeUnit.SECONDS.sleep(4);
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

                //przeszukiwanie listy kontaktów  i metoda werfykiacji klienta
                Select select = new Select(driver.findElement(By.id("ContactName")));
                List<WebElement> allOptions = select.getOptions();

                for (WebElement option : allOptions) {
                    foundName =  (Normalizer.normalize(option.getText().toLowerCase().replace("ł", "l"), Normalizer.Form.NFKD)).replaceAll("[^\\p{ASCII}]", "").contains((Normalizer.normalize(Name.toLowerCase().replace("ł", "l"),Normalizer.Form.NFKD)).replaceAll("[^\\p{ASCII}]", ""));
                    foundLast = (Normalizer.normalize(option.getText().toLowerCase().replace("ł", "l"), Normalizer.Form.NFKD)).replaceAll("[^\\p{ASCII}]", "").contains((Normalizer.normalize(LastName.toLowerCase().replace("ł", "l"),Normalizer.Form.NFKD)).replaceAll("[^\\p{ASCII}]", ""));
                    if(foundLast && foundName) {

                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ContactName\"]/option[2]")));
                        TimeUnit.SECONDS.sleep(2);
                        driver.findElement(By.id("ContactName")).sendKeys(option.getText());

                        driver.executeScript("arguments[0].dispatchEvent(new Event('change'))", driver.findElement(By.id("Memo"))); 

                        userFound =true;
                        break;
                    }
                }
                if (!userFound) {
                    try {
                        driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/table[3]/tbody/tr/td/div/div/div[2]/div[1]/div/div[2]")).click();

                        //przycisk ContactOptionsTempContact
                        wait.until(ExpectedConditions.elementToBeClickable(By.id("ContactOptionsTempContact"))).click();

                        TimeUnit.SECONDS.sleep(4);

                        if(isElementPresent(driver.findElement(By.cssSelector("div[data-node-id='DisplayErrors']")))) {

                            WebElement ErrExist = driver.findElement(By.cssSelector("div[data-node-id='DisplayErrors']"));
                            Boolean bool = ErrExist.findElements(By.cssSelector("div[class='field-item dataLabelWrite']")).size()>0;
                            if(bool && ErrExist.findElement(By.cssSelector("div[class='field-item dataLabelWrite']")).getAttribute("textContent").contains("Invalid Account Number")){ 
                                throw new Exception("202");
                            }
                        }

                        //Dane      
                        wait.until(ExpectedConditions.elementToBeClickable(By.id("FirstName")));
                        jse.executeScript("document.getElementById('FirstName').value='" + Name + "';");// imie
                        jse.executeScript("document.getElementById('LastName').value='" + LastName + "';");//nazwisko
                        if(Email!=null && !Email.isEmpty()) {
                            jse.executeScript("document.getElementById('Internal_Email').value='" + Email + "';");
                        }
                        jse.executeScript("document.getElementById('CntryCode').value='" + "48" + "';"); //kierunkowy kraju
                        jse.executeScript("document.getElementById('AreaCode').value='" + "0" + "';"); //area code na 0 
                        jse.executeScript("document.getElementById('Phone').value='" + PhoneNumber + "';");//nr telefonu 
                        jse.executeScript("document.getElementById('Extension').value='" + "0" + "';");//sztywno zero
                        driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/table[3]/tbody/tr/td/div/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div/div[3]/div/div/div/table/tbody/tr[3]/td[3]/nobr/input")).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.id("Role")));
                        wait.until(ExpectedConditions.textToBePresentInElement((By.id("Role")), "Unknown"));
                        jse.executeScript("document.getElementById('Role').value='" + "Unknown" + "';");
                    }catch(Exception e){
                        e.printStackTrace();
                        throw new Exception ("201"); //201 Error On Input New User On Acc
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
                if(!e.getMessage().equals("201")||!e.getMessage().equals("202")) {
                    throw new Exception ("200");
                }
                else {
                    throw e;
                }
            }

            Smart(driver, wait);

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
