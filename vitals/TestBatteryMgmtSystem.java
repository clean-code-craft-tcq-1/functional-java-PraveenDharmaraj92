package vitals;

public class TestBatteryMgmtSystem {
	
	public boolean checkTemperatureTest(Battery battery){
		BatteryHealthChecker batteryHealthChecker = new BatteryHealthChecker(battery);
		return batteryHealthChecker.checkBatteryTemperatureHealth(new CheckTemperatureFunction());
	}
	
	public boolean checkSocTest(Battery battery){
		BatteryHealthChecker batteryHealthChecker = new BatteryHealthChecker(battery);
		return batteryHealthChecker.checkBatterySocHealth(new CheckSocFunction());
	}
	
	public boolean checkChargeRateTest(Battery battery){
		BatteryHealthChecker batteryHealthChecker = new BatteryHealthChecker(battery);
		return batteryHealthChecker.checkBatteryChargeRateHealth(new CheckChargeRateFunction());
	}
	
	public void checkAndReportTemperature(Battery battery){
		BatteryHealthChecker batteryHealthChecker = new BatteryHealthChecker(battery);
		batteryHealthChecker.checkAndReportBatteryTemperatureHealth(new CheckTemperatureFunction());
	}
	
	public void checkAndReportSoc(Battery battery){
		BatteryHealthChecker batteryHealthChecker = new BatteryHealthChecker(battery);
		batteryHealthChecker.checkAndReportBatterySocHealth(new CheckSocFunction());
	}
	
	public void checkAndReportChargeRate(Battery battery){
		BatteryHealthChecker batteryHealthChecker = new BatteryHealthChecker(battery);
		batteryHealthChecker.checkAndReportBatteryChargeRateHealth(new CheckChargeRateFunction());
	}
	
	/**
	 * test method for testing battery management system
	 */
	public void test() {
		//positive cases
		Battery battery1 = new Battery(12, 0.3f, 56);
		assert (checkTemperatureTest(battery1));
		Battery battery2 = new Battery(12, 0.3f, 56);
		assert(checkSocTest(battery2));
		Battery battery3 = new Battery(12, 0.3f, 56);
		assert(checkChargeRateTest(battery3));
		
		//negative cases
		assert (!checkTemperatureTest(new Battery(50f, 2.5f, 56f)));
		assert(!checkSocTest(new Battery(15f, 0.3f, 101f)));
		assert(!checkChargeRateTest(new Battery(15f, 2.5f, 56f)));
		
		checkAndReportChargeRate(new Battery(15f, 2.5f, 56f));
		checkAndReportTemperature(new Battery(50f, 2.5f, 56f));
		checkAndReportSoc(new Battery(15f, 0.3f, 101f));
		
	}
}
