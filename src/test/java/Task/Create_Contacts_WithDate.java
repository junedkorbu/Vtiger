package Task;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.crm.BaseClass.BaseClass;
import Com.crm.FileUtility.ExcelUtility;
import Com.crm.JavaUtility.JavaUtil;
import Com.crm.Pom.Contacts;
import Com.crm.Pom.Home;

public class Create_Contacts_WithDate extends BaseClass{
	
	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void createContact() throws EncryptedDocumentException, IOException
	{
		Home h = new Home(driver);
		h.contacts();
		
		int row = 0;
		Contacts c = new Contacts(driver);
		c.plus();
		c.firstName(eUtil.getData("Contact", row++, 0));
		String lName = eUtil.getData("Contact", row++, 0);
		c.lastName(lName+JavaUtil.generateRandomNumber(1000));
		c.group();
		c.startDate(JavaUtil.getCurrentDate());
		c.endDate(JavaUtil.getDesiredDate());
		c.saveBtn();
		
		assertTrue((c.getCreatedContactText().getText()).contains(lName));
		assertTrue((c.getStartDateFromCreated().getText()).equals(JavaUtil.getCurrentDate()));
	}
}

