/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package vitals;

import java.util.function.Function;

/**
 * @author PDH2COB
 */
public class TestBatteryMgmtSystem {

	private boolean testTemperatureNegative(Function<Battery, Boolean> healthCheckFunction) {
		Battery battery = new Battery(120, 0.9f, 70);
		return healthCheckFunction.apply(battery);
	}

	private boolean testSocNegative(Function<Battery, Boolean> healthCheckFunction) {
		Battery battery = new Battery(12, 0.9f, 90);
		return healthCheckFunction.apply(battery);
	}

	private boolean testChargeRateNegative(Function<Battery, Boolean> healthCheckFunction) {
		Battery battery = new Battery(12, 0.3f, 56);
		return healthCheckFunction.apply(battery);
	}
	
	private boolean testBatteryHealthPositive(Function<Battery, Boolean> healthCheckFunction){
		Battery battery = new Battery(12, 0.9f, 56);
		return healthCheckFunction.apply(battery);
	}

	/**
	 * test method for testing battery management system
	 */
	public void test() {
		Function<Battery, Boolean> batteryHealthChecker = new BatteryHealthCheck();
		assert (testBatteryHealthPositive(batteryHealthChecker));
		assert (testTemperatureNegative(batteryHealthChecker));
		assert (testSocNegative(batteryHealthChecker));
		assert (testChargeRateNegative(batteryHealthChecker));
		
	}
}
