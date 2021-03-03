/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package vitals;

import java.util.function.Function;

/**
 * @author PDH2COB
 * Function class to check battery health
 */
public class BatteryHealthCheck implements Function<Battery, Boolean> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean apply(final Battery battery) {

		boolean tempCheck;
		boolean socCheck;
		boolean chargeRateCheck;

		tempCheck = checkTemperature(battery);
		socCheck = checkSoc(battery);
		chargeRateCheck = checkChargeRate(battery);

		if (!tempCheck) {
			System.out.println("Battery temperature - " + battery.getTemperature() + " not in range!");
		}
		if (!socCheck) {
			System.out.println("Battery State of Charge - " + battery.getSoc() + " not in range!");
		}
		if (!chargeRateCheck) {
			System.out.println("Battery Charging rate - " + battery.getChargeRate() + " not in range!");
		}

		return tempCheck && socCheck && chargeRateCheck;
	}

	private boolean checkTemperature(Battery battery) {
		return battery.getTemperature() > BatteryHealthConstants.minTemperature
				&& battery.getTemperature() < BatteryHealthConstants.maxTemperature;
	}

	private boolean checkSoc(Battery battery) {
		return battery.getSoc() > BatteryHealthConstants.minSoc && battery.getSoc() < BatteryHealthConstants.maxSoc;
	}

	private boolean checkChargeRate(Battery battery) {
		return battery.getChargeRate() > BatteryHealthConstants.minChargeRate
				&& battery.getChargeRate() < BatteryHealthConstants.maxChargeRate;
	}
	

}
