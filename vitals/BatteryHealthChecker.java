package vitals;

/**
 *Function class to check battery health
 */
public class BatteryHealthChecker {

	private Battery battery;

	public BatteryHealthChecker(Battery battery) {
		this.battery = battery;
	}

	public boolean checkBatteryTemperatureHealth(CheckTemperatureFunction function) {
		return function.checkRange(battery.getTemperature(), BatteryHealthParameters.TEMPERATURE);
	}

	public boolean checkBatterySocHealth(CheckSocFunction function) {
		return function.checkRange(battery.getTemperature(), BatteryHealthParameters.SOC);
	}

	public boolean checkBatteryChargeRateHealth(CheckChargeRateFunction function) {
		return function.checkRange(battery.getTemperature(), BatteryHealthParameters.CHARGE_RATE);
	}

	public void checkAndReportBatteryTemperatureHealth(CheckTemperatureFunction function) {
		if (!function.checkRange(battery.getTemperature(), BatteryHealthParameters.TEMPERATURE)) {
			reportError(BatteryHealthParameters.TEMPERATURE);
		}
	}

	public void checkAndReportBatterySocHealth(CheckSocFunction function) {
		if (!function.checkRange(battery.getTemperature(), BatteryHealthParameters.SOC)) {
			reportError(BatteryHealthParameters.SOC);
		}
	}

	public void checkAndReportBatteryChargeRateHealth(CheckChargeRateFunction function) {
		if (!function.checkRange(battery.getTemperature(), BatteryHealthParameters.CHARGE_RATE)) {
			reportError(BatteryHealthParameters.CHARGE_RATE);
		}
	}

	public void reportError(BatteryHealthParameters param) {
		System.out.println(new ReportFunction().apply(param));
	}

}
