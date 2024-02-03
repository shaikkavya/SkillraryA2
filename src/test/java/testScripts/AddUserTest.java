package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
public class AddUserTest extends BaseClass{

	@Test
	public void addUserTest() throws InterruptedException{
		SoftAssert soft = new SoftAssert();
		
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("Users"));
		users.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(adduser.getPageHeader(), "Add New User");
		
	    Map<String, String> map = excel.readFromExcel("Add User");
	    
	    adduser.setEmail(map.get("Email"));
	    adduser.setPassword(map.get("Password"));
	    adduser.setFirstname(map.get("Firstname"));
	    adduser.setLastname(map.get("Lastname"));
	    adduser.setAddress(map.get("Address"));
	    adduser.setContactInfo(map.get("ContactInfo"));
	    adduser.uploadPhoto(map.get("Photo"));
	      
	    
	    adduser.clickSave();
	    
	    soft.assertEquals(users.getSuccessMessage(), "Success!");
	    soft.assertAll();
	}
	

}
