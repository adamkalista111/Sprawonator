package test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.chrome.ChromeDriver;



public class main {

	static ChromeDriver driver;
	static String Eska;
	static String dodano;

	public static void main(String[] args) throws InterruptedException {

		BufferedReader bf;

		File fileIn;

		Config DaneLogowania;
		Login login;


		String line;

		int ErrCounter=1;
		long startTime;
		long endTime;
		long timeElapsed;

		boolean exit =false;
		boolean LoginSuc;
		boolean CaseOpenSuc;

		try {
			DaneLogowania = new Config(args);
			System.out.print(args[0]);

			System.setProperty("webdriver.chrome.driver", DaneLogowania.path+"\\chromedriver.exe");
			fileIn =new File(DaneLogowania.path+"\\dataIN.txt");

			if(!fileIn.isFile()) {
				throw new Exception("1"); //1 FileMissingOnRead
			}

			else {
				bf = new BufferedReader(new FileReader(DaneLogowania.path+"\\dataIN.txt"));
				line = bf.readLine();

				String[] split = line.split(";",-1);
				bf.close();


				if(!fileIn.delete()) {
					throw new Exception("666"); //2 FileMissingOnDelete
				}
				else {
					String check = DaneLogowania.ControlSum;
					if (!split[0].equals(check)) {

						throw new Exception("2137"); //2137 ControlSumMissmatch

					}
					else {


						try {
							driver= new ChromeDriver();
						}catch(SessionNotCreatedException | IllegalStateException e)
						{

							throw new Exception("13"); //missing/wrong driver

						}


						//POZYCJA

						driver.manage().window().setPosition(new Point(1,1000));
						driver.manage().window().setSize(new Dimension(1200, 400)); 


						login = new Login(args);

						do {
							startTime = System.currentTimeMillis();
							try {


								LoginSuc= login.logToStars(driver);
								CaseOpenSuc = login.CaseOpen(driver);

								if(LoginSuc && CaseOpenSuc ) {


									switch(split[1]) {
									case "1" : // token

										Token token = new Token(line);
										Eska = token.BeginCase(driver);
										dodano= token.dodana;
										break;

									case "2":// account

										Account account = new Account(line);
										Eska =account.BeginCase(driver);
										dodano= account.dodana;
										break;
									case "3":// nonclient

										NonClient none = new NonClient(line);
										Eska =none.BeginCase(driver);
										dodano= none.dodana;
										break;
									}
									System.out.print(dodano);
									if(dodano == null || dodano=="1")
									{
										DataOut(Eska, DaneLogowania.path, DaneLogowania.ControlSum,"0");
									}
									else if (dodano =="2") {
										DataOut(Eska, DaneLogowania.path, DaneLogowania.ControlSum,"1013");
									}
									else 
									{
										DataOut(Eska, DaneLogowania.path, DaneLogowania.ControlSum,"1012");
									}

								}
								else {//OPENCASEERR AND LOGINERR HANDLING
									if(!LoginSuc) {
										throw new Exception ("11"); //11 Error While Login
									}
									if(!CaseOpenSuc) {
										throw new Exception ("12"); //12 Error While Starting Case
									}
									exit=true;
									driver.quit();
								}

								exit = true;

							}catch(Exception inErr){
								ErrCounter++;;
								if(inErr.getMessage().equals("10")|| inErr.getMessage().equals("101")|| inErr.getMessage().equals("202")) { //10 BadLogin //101cannot find/pick token//202 account invalid
									exit=true;
									driver.quit();
									throw inErr; 
								}
								else {

									if(ErrCounter<4) {

										exit=false;
									}
									else {
										driver.quit();
										throw inErr;
									}

								}
							}

						}while(!exit);
						driver.quit();
						endTime = System.currentTimeMillis();
						timeElapsed = endTime - startTime;
						System.out.println("czas na założenie sprawy to: " + timeElapsed/1000 + " sekund");
					}
				}
			}

		}catch (Exception err) {
			if(driver!=null) {
				driver.quit();
			}
			DaneLogowania = new Config(args);
			if(err.getMessage().contains("1009")) {

				DataOutForUknown(DaneLogowania.path, DaneLogowania.ControlSum, err.getMessage());
			}
			else {


				DataOut("",DaneLogowania.path,DaneLogowania.ControlSum,err.getMessage());
				err.printStackTrace();
			}
		}  
	}

	private static void DataOutForUknown(String path,String Csum, String Err) {
		PrintWriter writer;
		try {

			writer = new PrintWriter(path+"\\DataOUT.txt", "UTF-8");

			writer.println(Csum+";"+Err);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}


	}

	public static void DataOut(String Eska, String path, String Csum ,String Code) {

		PrintWriter writer;
		try {

			writer = new PrintWriter(path+"\\DataOUT.txt", "UTF-8");

			if(Eska.contains("S")) {
				writer.println(Csum+";"+Code +";"+Eska);
				writer.close();
			}
			else {
				writer.println(Csum+";"+Code);
				writer.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

	}


}