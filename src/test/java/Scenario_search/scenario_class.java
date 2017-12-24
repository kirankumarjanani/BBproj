package Scenario_search;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import Generic.Base_class;
import Pomdesign.Pom_class;

public class scenario_class extends Base_class {
public static Logger log=Logger.getLogger(scenario_class.class);
	
	@Test(dataProvider="dp_Invalidsearch", dataProviderClass=Dataprovider.Dataproviderclass.class)
	public void TestInvalidSerch(Map<String,String> Search) throws IOException, InterruptedException
	{
		String TC_ID = Search.get("TC_ID");
		String Order_Set = Search.get("Order_Set");
		
		String Search_Item = Search.get("Search_Item");
		String Exp_Result = Search.get("Exp_Result");
		
		Start_Server();
		LaunchApp();
		
		//log.info("Executing the TestCase "+TC_ID + "Order set is "+Order_Set);
		
		Pom_class BS_Pob= new Pom_class(driver);
		
		Explicit_wait(BS_Pob.Search_txtbox, 40);
		Explicit_wait(BS_Pob.Search_txtbox2, 20);
		BS_Pob.EnterSearch(Search_Item);
		
		
		Explicit_wait(BS_Pob.Invalid_msg, 25);
		String Actual_Result = BS_Pob.getInvalidmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
		System.out.println("pass");
			//log.info("Passed as Actual Result is  "+Actual_Result + " Same as Expected Result "+Exp_Result);
		}
		else
		{
			System.out.println("fail");
			//log.info("Failed as Actual Result is  "+Actual_Result + "and Expected Result "+Exp_Result);
		}
		
		
		Stop_Server();
		
		
		
		
	}
	
@Test(dataProvider="dp_Validsearch", dataProviderClass=Dataprovider.Dataproviderclass.class)	
	public void TestValidSerch(Map<String,String> search) throws IOException, InterruptedException
	{
	SoftAssert sassert=new SoftAssert();
	String TC_ID = search.get("TC_ID");
String Order_Set = search.get("Order_Set");
String Search_Item = search.get("Search_Item");
String Exp_Result = search.get("Exp_Result").replace(".0 ","");
	Start_Server();	
	LaunchApp();
	
	Pom_class BS_Pob= new Pom_class(driver);
	Explicit_wait(BS_Pob.Search_txtbox, 50	);
	
	BS_Pob.EnterSearch(Search_Item);
	
	Explicit_wait(BS_Pob.Valid_item, 40);
	String result = BS_Pob.getValiditem();
	String Actual_result = result.replace(" Items","");
	
	if(Actual_result.equals(Exp_Result))
	{
		System.out.println("pass");
	}
	else
	{
	log.info("failed due to wrong input");
//Capture_screenshot(TC_ID, Order_Set);	
	sassert.assertEquals(Actual_result, Exp_Result);
	}

	Stop_Server();
	sassert.assertAll();
	}
	}
