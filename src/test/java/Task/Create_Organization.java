package Task;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.crm.BaseClass.BaseClass;
import Com.crm.FileUtility.ExcelUtility;
import Com.crm.JavaUtility.JavaUtil;
import Com.crm.Pom.Home;
import Com.crm.Pom.Organizations;

public class Create_Organization extends BaseClass{

	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		Home h = new Home(driver);
		h.organizations();
		
		int row = 0;
		Organizations org = new Organizations(driver);
		org.plusIcon();
		String orgName= eUtil.getData("Org", row++, 0);
		org.organizationName(orgName+JavaUtil.generateRandomNumber(1000));
		org.group();
		org.assignedto(eUtil.getData("Org", row++, 0));
		org.saveBtn();
		
		assertTrue((org.getCreatedOrgText().getText()).contains(orgName));
	}
}
