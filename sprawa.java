package test2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




abstract class Sprawa{

    public String Csum;
    public String CaseTypeID;
    public String ContactID;
    public String Token_Account;
    public String Name;
    public String LastName;
    public String PhoneNumber;
    public String Email;
    public String Pending;
    public String Smart;
    public String Volume;
    public String InquirySourceID;
    public String Memo;
    public String Symptom;
    public String Solution;
    public String Additional_Information;
    public String Status;
    public String Value_date;
    public String Transaction_reference;
    public String NoteSubject;
    public String NoteText;
    public String Error_Source;
    public String CountryCode;

    public String ErrMsg;
    public String dodana =null;



    public String CaseFinish(ChromeDriver driver, WebDriverWait wait) throws Exception  {
        String name = null;
        String last = null;
        String compName= null;
        String joinedInfo = null;
        String S= null;
        String[] info= new String[3];


        try {   
            driver.switchTo().defaultContent();
            driver.switchTo().frame("PegaGadget0Ifr");
            wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(driver.findElementByCssSelector("div[class='content   layout-content-inline_grid_triple content-inline_grid_triple  ']"), By.tagName("a")));
            WebElement pokraka = driver.findElementByCssSelector("div[class='content   layout-content-inline_grid_triple content-inline_grid_triple  ']");
            List <WebElement> rodzina = pokraka.findElements(By.xpath("*"));
            int i=0;
            for (WebElement sraka : rodzina){
                i++;
                if(i== rodzina.size()) {
                    S = sraka.findElement(By.tagName("a")).getText();
                }
                else if(sraka.findElement(By.tagName("span")).getText().equals("First name")){
                    name = sraka.findElement(By.cssSelector("div [class='field-item dataValueRead']")).getText();
                }
                else if(sraka.findElement(By.tagName("span")).getText().equals("Last name")){
                    last = sraka.findElement(By.cssSelector("div [class='field-item dataValueRead']")).getText();
                }
                else if(sraka.findElement(By.tagName("span")).getText().equals("Account name")){
                    compName = sraka.findElement(By.cssSelector("div [class='field-item dataValueRead']")).getText();
                }

            }

            info[0]= S;
            info[1]= name + " " + last; 
            info[2]= compName;

            joinedInfo = String.join(";", info);

            driver.switchTo().defaultContent();

            if ((NoteSubject !=null&& !NoteSubject.isEmpty())&&(NoteText !=null&& !NoteText.isEmpty())) {
                dodana =AddNote(driver, S);
            }
            else {
                if(NoteSubject.isEmpty()&& NoteText.isEmpty()) {
                    dodana="1";
                }else {
                    dodana="2";
                }
            }

        }catch(Exception e) {

            throw new Exception ("1010"); //1010 Cannot Read Data
        }

        return joinedInfo;

    }

    public void Smart(ChromeDriver driver, WebDriverWait wait) throws Exception{

        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver; 

            wait.until(ExpectedConditions.elementToBeClickable(By.id("AggregatedCaseType")));

            TimeUnit.SECONDS.sleep(1);


            driver.findElement(By.id("AggregatedCaseType")).sendKeys(Smart);

            jse.executeScript("arguments[0].dispatchEvent(new Event('change'))", driver.findElement(By.id("AggregatedCaseType")));

            wait.until(ExpectedConditions.elementToBeClickable(By.className("match-highlight"))).click();   

            wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(By.id("Memo")),
                    ExpectedConditions.stalenessOf(driver.findElementById("AggregatedCaseType"))));

            TimeUnit.SECONDS.sleep(3);

            //Memo
            driver.findElement(By.id("Memo")).click();

            jse.executeScript("document.getElementById('Memo').value='" + Memo + "';");

            driver.executeScript("arguments[0].dispatchEvent(new Event('change'))", driver.findElement(By.id("Memo")));
            TimeUnit.SECONDS.sleep(2);

            //volume VolumeIndicator
            if(Volume !="1") {  
                jse.executeScript("document.getElementById('VolumeIndicator').setAttribute('value'," +Volume+")");  
            }
            //Symptom
            if(Symptom !=null && !Symptom.isEmpty()) {
                jse.executeScript("document.getElementById('Symptom').value='" + Symptom+ "';");
            }       
            //sSolution 
            if(Solution !=null && !Solution.isEmpty()) {        
                jse.executeScript("document.getElementById('Solution').value='" + Solution + "';");
            }
            //AdditionalInfo        
            if(Additional_Information !=null && !Additional_Information.isEmpty()) {        
                jse.executeScript("document.getElementById('AdditionalInfo').value='" + Additional_Information + "';");
            }
            //status
            if(Status !=null && !Status.isEmpty()) {        
                jse.executeScript("document.getElementById('ResolveNotes').value='" + Status + "';");
            }

            if(ContactID !="1" && ContactID !=null && !ContactID.isEmpty()) {
                Select drpReceived = new Select(driver.findElementByCssSelector("select[name='$PpyWorkPage$pReceivedBy']"));
                drpReceived.selectByIndex(Integer.parseInt(ContactID));
                TimeUnit.SECONDS.sleep(1);
            }

            if(InquirySourceID != "1" &&InquirySourceID !=null && !InquirySourceID.isEmpty()) {
                Select drpReceived2 = new Select(driver.findElementByCssSelector("select[name='$PpyWorkPage$pInquirerSource']"));
                drpReceived2.selectByIndex(Integer.parseInt(InquirySourceID));
                TimeUnit.SECONDS.sleep(1);
            }

            if(Error_Source != "1" &&Error_Source !=null && !Error_Source.isEmpty()) {
                Select drpReceived2 = new Select(driver.findElementByCssSelector("select[name='$$PpyWorkPage$pErrorSource']"));
                drpReceived2.selectByIndex(Integer.parseInt(Error_Source));
                TimeUnit.SECONDS.sleep(1);
            }

            //Trans Ref
            if(Transaction_reference !=null && !Transaction_reference.isEmpty()) {
                jse.executeScript("document.getElementById('TransactionReference').value='" + Transaction_reference+ "';");
            }


            if(Smart.contains("Payables")||Smart.contains("Receivables")) {
                wait.until(ExpectedConditions.and(
                        ExpectedConditions.elementToBeClickable(driver.findElementById("ValueDate")),
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[style='cursor:pointer;']"))));    

                driver.findElement(By.id("ValueDate")).sendKeys(Value_date);

            }

            //pending       
            if(Pending.equals("0")) {           
                wait.until(ExpectedConditions.elementToBeClickable(By.id("ExceptionResolutionStatusPending")));     
                driver.findElement(By.id("ExceptionResolutionStatusPending")).click();          
            }


        }catch(Exception e){
            e.printStackTrace();
            throw new Exception ("1000"); //Error on SMART
        }

    }

    public void CaseSubmit(ChromeDriver driver, WebDriverWait wait) throws Exception{

        try {

            int counter=0;
            do{
                if (counter>=5) {
                    throw new Exception("na przycisku isselfservicable");
                }
                TimeUnit.SECONDS.sleep(1);
                driver.findElement(By.id("IsSelfServiceableNo")).click();
                counter++;
            }while(driver.findElement(By.id("IsSelfServiceableNo")).getAttribute("checked") ==null);

            counter=0;
            do {
                if (counter>=30) {
                    throw new Exception("no Data");
                }
                TimeUnit.SECONDS.sleep(1/2);
                counter++;
            }while(!isElementPresentByCssselector(driver,"option[value='DATA']"));

            counter=0;
            boolean exit = false;
            do {
                if (counter>=5) {
                    throw new Exception("cannot pick Data");
                }
                try {
                    driver.findElement(By.xpath("//*[@id=\"SSQKeyWord\"]")).sendKeys("Data");
                    TimeUnit.SECONDS.sleep(1);
                    if(driver.findElementByCssSelector("option[value='DATA']").getAttribute("selected")!=null) {
                        exit=true;
                    }
                }catch (NoSuchElementException e)
                {
                    TimeUnit.SECONDS.sleep(2);
                    if(driver.findElementByCssSelector("option[value='DATA']").getAttribute("selected")!=null) {
                        exit=true;
                    }
                }
                counter++;
            }while(!exit);

            do {
                if (counter>=5) {
                    throw new Exception("na probie submita");
                }
                driver.switchTo().defaultContent();
                driver.switchTo().frame("PegaGadget0Ifr");
                TimeUnit.SECONDS.sleep(1);
                driver.findElement(By.xpath("//*[@title='Click to Create Case']")).click();
                TimeUnit.SECONDS.sleep(1);

                if(isElementPresent(driver.findElement(By.cssSelector("div[data-node-id='DisplayErrors']")))) {

                    WebElement ErrExist = driver.findElement(By.cssSelector("div[data-node-id='DisplayErrors']"));
                    Boolean bool = ErrExist.findElements(By.cssSelector("div[class='field-item dataLabelWrite']")).size()>0;
                    if(bool){ 
                        ErrMsg = ErrExist.findElement(By.cssSelector("div[class='field-item dataLabelWrite']")).getAttribute("textContent");
                        System.out.print(ErrMsg);
                        throw new Exception(ErrMsg);
                    }
                }

                driver.switchTo().defaultContent();
                counter++;
            }while(driver.findElementByXPath("//*[@id=\"RULE_KEY\"]/tbody/tr/td[2]/span/label").getText().contains("Work item"));





        }
        catch(Exception e){
            e.printStackTrace();
            if(e.getMessage().equals(ErrMsg)) {// 1009 unknown error
                throw new Exception("1009;"+ErrMsg);// 1009 unknown error
            }
            else if(!e.getMessage().equals("1001")) {
                throw new Exception(e);
            }
            else {
                throw new Exception ("1001"); // 1001 Cannot Submit
            }
        }

    }

    public boolean isElementPresentByCssselector(ChromeDriver driver,String Element){
        try{
            driver.findElementByCssSelector(Element).getText();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public boolean isElementPresent(WebElement Element){
        try{
            Element.getText();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public String AddNote(ChromeDriver driver, String S){
        try {

            driver.switchTo().defaultContent();
            driver.switchTo().frame("PegaGadget0Ifr");
            WebDriverWait wait = new WebDriverWait(driver, 15);/// i to

            driver.switchTo().defaultContent();
            driver.findElementById("ItemID").sendKeys(S);

            driver.findElementByCssSelector("img[src='webwb/citi_search_icon_1914588225.png!!.png']").click();

            driver.switchTo().defaultContent();


            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("PegaGadget1Ifr"));


            //TimeUnit.SECONDS.sleep(5);


            wait.until((Checkur) ->driver.findElementByCssSelector("div[class='work_identifier']").getText().contains("("+S+")"));

            wait.until(ExpectedConditions.visibilityOf(driver.findElementByCssSelector("div[param_name='EXPANDEDSubSectionpyCaseAttachmentsWrapperB']").findElement(By.cssSelector("a[aria-label='menu Add']")))).click();
            TimeUnit.SECONDS.sleep(2);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("/contextMenu/ID1466583912588000"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("NoteTypesInternal"))).click();
            wait.until((Checker) ->driver.findElement(By.id("CustomerPerceptibleIndicator")).getAttribute("checked")==null);
            driver.findElementById("pyLabel").sendKeys(NoteSubject);
            driver.findElementById("pyNote").sendKeys(NoteText);
            driver.findElementById("ModalButtonSubmit").click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-node-id='pyWorkAttachmentsFeedDesc']")));

            System.out.print("Notka dodana");
            return "1";

        }catch(Exception e) {

            e.printStackTrace();
            return "3";

        }

    }



    public Sprawa(String line) {
        try {
            String[] split = line.split(";",-1);
            Csum= split[0];
            CaseTypeID= split[1];
            ContactID= split[2];
            Token_Account= split[3];
            Name= split[4];
            LastName= split[5];
            PhoneNumber= split[6];
            Email= split[7];
            Pending= split[8];
            Smart= split[9];
            Volume= split[10];
            InquirySourceID= split[11];
            Memo= split[12];
            Symptom= split[13];
            Solution= split[14];
            Additional_Information= split[15];
            Status= split[16];
            Value_date= split[17];
            Transaction_reference= split[18];
            NoteSubject= split[19];
            NoteText= split[20];
            Error_Source= split[21];
            CountryCode= split[22];

            dodana =null;
        }catch (Exception e)
        {//tu ktoś mądry zrobi komuniakty
        }


    }

}```


.
***Token***
```package test2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Token extends Sprawa{

    public Token(String line) {
        super(line);
        // TODO Auto-generated constructor stub
    }

    public String BeginCase(ChromeDriver driver) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            //POZYCJA
            /*
            driver.manage().window().setPosition(new Point(1,800));
            driver.manage().window().setSize(new Dimension(1800, 400)); 
             */

            JavascriptExecutor jse = (JavascriptExecutor)driver; 

            try {
                //wybor SAFEWORD radio box

                driver.switchTo().frame("PegaGadget0Ifr");              
                wait.until(ExpectedConditions.elementToBeClickable(By.id("CaseCreationModeSearchSafewordID")));
                driver.findElement(By.id("CaseCreationModeSearchSafewordID")).click();

                //wpisanie SAFEWORD 
                wait.until(ExpectedConditions.elementToBeClickable(By.id("SafewordIDAdv")));
                driver.findElement(By.id("SafewordIDAdv")).sendKeys(Token_Account);
                driver.executeScript("arguments[0].dispatchEvent(new Event('change'))", driver.findElement(By.id("SafewordIDAdv"))); 


            }catch(Exception e){
                e.printStackTrace();
                throw new Exception ("100"); //100 Cannot Choose token

            }

            try {
                //wybór drop down boxa na 2gą opcję 
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ContactName\"]/option[2]")));
                driver.findElement(By.xpath("id('ContactName')/option[2]")).click();        
                jse.executeScript("arguments[0].dispatchEvent(new Event('change'))", driver.findElement(By.id("ContactName")));

            }catch(Exception e){
                e.printStackTrace();
                throw new Exception ("101"); //101 Cannot Pick/Find Token

            }



            Smart(driver,wait);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("IsSelfServiceableNo")));
            TimeUnit.SECONDS.sleep(4);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("IsSelfServiceableNo")));

            CaseSubmit(driver,wait);

            return CaseFinish(driver,wait);

        }catch(Exception e){
            e.printStackTrace();
            if(e.getMessage().equals("1009;"+ErrMsg)) {// 1009 un known error
                throw new Exception("1009;"+ErrMsg);// 1009 unknown error
            }

            throw new Exception (e.getMessage());
        }
    }
    }```