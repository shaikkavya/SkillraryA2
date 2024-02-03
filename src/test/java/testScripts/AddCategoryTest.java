package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantPath;

public class AddCategoryTest extends BaseClass{
      
	@Test
	public void addCategoryTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		
		home.clickCoursesTab();
		home.clickCategoryLink();
		soft.assertEquals(category.getPageHeader(), "Category");
		
		category.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addcategory.getPageHeader(), "Add New Category");
		Map<String, String> map = excel.readFromExcel("Add Category");
		addcategory.setName(map.get("Name"));
		addcategory.clickSave();
		
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		category.deleteCategory(web, map.get("Name"));
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		if(category.getSuccessMessage().equals("Success!"))
			excel.updateTestStatus("Add Category", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Category", "Fail", IConstantPath.EXCEL_PATH);
		
		soft.assertAll();
		
	}
}
