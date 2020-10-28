package testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);logger.info("User name is provided");
		lp.setPassword(password);logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		logger.info("Providing Customer Details.....");
		
		addcust.custName("Mayur");
		addcust.custgender("male");
		addcust.custdob("26","04","1995");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("Nagpur");
		addcust.custstate("MAHARASHTRA");
		addcust.custpinno("440016");
		addcust.custtelephoneno("9922039369");
		
		String email = randomeString()+"@gmail.com";
		addcust.custemailid(email);
		
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		logger.info("Validation Started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res == true) {
			Assert.assertTrue(true);
			logger.info("test case pass...");
		}else {
			logger.info("test case failed...");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
