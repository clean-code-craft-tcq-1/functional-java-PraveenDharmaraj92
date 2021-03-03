/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package vitals;

import java.util.function.Function;

/**
 * @author PDH2COB Function class to check battery health
 */
public class BatteryHealthCheck implements Function<Battery, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean apply(final Battery battery) {
		return checkTemperature(battery) && checkSoc(battery) && checkChargeRate(battery);
	}

	private boolean checkTemperature(Battery battery) {
		boolean tempWithinRange = true;
		if (battery.getTemperature() < BatteryHealthConstants.minTemperature
				|| battery.getTemperature() > BatteryHealthConstants.maxTemperature) {
			System.out.println("Battery temperature - " + battery.getTemperature() + " not in range!");
			tempWithinRange = false;
		}
		return tempWithinRange;
	}

	private boolean checkSoc(Battery battery) {
		boolean socWithinRange = true;
		if (battery.getSoc() < BatteryHealthConstants.minSoc || battery.getSoc() > BatteryHealthConstants.maxSoc) {
			System.out.println("Battery State of Charge - " + battery.getSoc() + " not in range!");
			socWithinRange = false;
		}
		return socWithinRange;
	}

	private boolean checkChargeRate(Battery battery) {
		boolean chargeRateWithinRange = true;
		if (battery.getChargeRate() < BatteryHealthConstants.minChargeRate
				|| battery.getChargeRate() > BatteryHealthConstants.maxChargeRate) {
			chargeRateWithinRange = false;
			System.out.println("Battery Charging rate - " + battery.getChargeRate() + " not in range!");
		}
		return chargeRateWithinRange;
	}

}
