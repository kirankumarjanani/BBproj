package Pomdesign;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom_cart {

	
	@FindBy(id="com.bigbasket.mobileapp:id/btnAddToBasket")
	public WebElement Add_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/cartcountView")
	public WebElement Img_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement AddCart_msg;
	

	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement Delete_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement DeleteCart_msg;
	
	
		
	
	public Pom_cart(AppiumDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void Click_Addbtn()
	{
		Add_btn.click();
	}
	
	
	public void Click_Imgbtn()
	{
		Img_btn.click();
	}
	
	public void Click_Deletebtn()
	{
		Delete_btn.click();
	}
	
	public String getAddCart()
	{
		return AddCart_msg.getText();
		
	}
	
	public String getDeleteCart()
	{
		return DeleteCart_msg.getText();
		
	}
	
	
	
	
	


}
