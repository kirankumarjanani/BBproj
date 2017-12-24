package Scenario_search;

import java.io.IOException;
import java.util.Map;

import Generic.Base_class;
import Pomdesign.Pom_cart;
import Pomdesign.Pom_class;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;
public class Scenario_cart extends Base_class {

	public static Logger log= Logger.getLogger(Scenario_cart.class);
	
	@Test(dataProvider="dp_AddCart", dataProviderClass=Dataprovider.Dataproviderclass.class,groups={"smoke"})
	public void testAddcart(Map<String,String> Cart) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID");
		String Order_Set = Cart.get("Order_Set");
		String Search_Item = Cart.get("Search_Item");
		String Exp_Result = Cart.get("Exp_Result");
		
		Start_Server();
		LaunchApp();
		
		Pom_class BS_Pob= new Pom_class(driver);		
		Explicit_wait(BS_Pob.Search_txtbox, 30);
		
		BS_Pob.EnterSearch(Search_Item);
		
		Pom_cart BC_Pob= new Pom_cart(driver);
		Explicit_wait(BC_Pob.Add_btn, 25);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.Img_btn, 25);
		BC_Pob.Click_Imgbtn();
		
		Explicit_wait(BC_Pob.AddCart_msg, 25);
		String Actual_Result = BC_Pob.getAddCart();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  "+Actual_Result + " Same as Expected Result "+Exp_Result);
			//Capture_Screenshot(TC_ID, Order_Set);
		}
		else
		{
			log.info("Failed as Actual Result is  "+Actual_Result + "and Expected Result "+Exp_Result);
			sAssert.fail("Failed as Actual Result is  "+Actual_Result + "and Expected Result "+Exp_Result);
			//Capture_Screenshot(TC_ID, Order_Set);
		}
		
		
		Stop_Server();
		sAssert.assertAll();		
		
		
		
		
	}
	
	
	@Test(dataProvider="dp_DeleteCart", dataProviderClass=Dataprovider.Dataproviderclass.class, groups={"regression"})
	public void testDeletecart(Map<String,String> Cart) throws IOException, InterruptedException
	{
		SoftAssert sAssert= new SoftAssert();
		
		String TC_ID = Cart.get("TC_ID");
		String Order_Set = Cart.get("Order_Set");
		String Search_Item = Cart.get("Search_Item");
		String Exp_Result = Cart.get("Exp_Result");
		
		Start_Server();
		LaunchApp();
		
		Pom_class BS_Pob= new Pom_class(driver);		
		Explicit_wait(BS_Pob.Search_txtbox, 30);
		
		BS_Pob.EnterSearch(Search_Item);
		
		Pom_cart BC_Pob= new Pom_cart(driver);
		Explicit_wait(BC_Pob.Add_btn, 25);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.Img_btn, 25);
		BC_Pob.Click_Imgbtn();
		
		Explicit_wait(BC_Pob.AddCart_msg, 25);
		BC_Pob.Click_Deletebtn();
		
		Explicit_wait(BC_Pob.DeleteCart_msg, 25);
		String Actual_Result = BC_Pob.getDeleteCart();
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is  "+Actual_Result + " Same as Expected Result "+Exp_Result);
			//Capture_Screenshot(TC_ID, Order_Set);
		}
		else
		{
			log.info("Failed as Actual Result is  "+Actual_Result + "and Expected Result "+Exp_Result);
			sAssert.fail("Failed as Actual Result is  "+Actual_Result + "and Expected Result "+Exp_Result);
		//	Capture_Screenshot(TC_ID, Order_Set);
		}
		
		
		Stop_Server();
		sAssert.assertAll();		
		
		
		
		
	}
	
	
	
	


	
}
