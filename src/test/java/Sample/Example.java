package Sample;

import java.util.Random;

import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Com.crm.BaseClass.BaseClass;

@Listeners(Com.crm.Listeners.ListenersVtiger.class)
public class Example extends BaseClass{

	@Test(timeOut = 500)
	public void fetch() throws InterruptedException
	{
		Random r = new Random();
		System.out.println(r.nextInt(100));
		Thread.sleep(3000);
	}
}
