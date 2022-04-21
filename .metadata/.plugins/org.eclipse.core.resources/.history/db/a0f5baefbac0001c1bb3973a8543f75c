package TestSuite;
import org.testng.annotations.Test;

import Pages.CarInsurance;
import Pages.HealthInsurances;
import Pages.TravelInsurance;


public class Travel {
	@Test
	public void test() throws InterruptedException
	{
		TravelInsurance ti = new TravelInsurance();
		CarInsurance ci = new CarInsurance();
		HealthInsurances hi = new HealthInsurances();
		ti.driverSetup();
		ti.openUrl();
		ti.travel();
		ci.openUrl();
		ci.car();
		hi.openUrl();
		hi.list();
		hi.closeBrowser();
	}

}
