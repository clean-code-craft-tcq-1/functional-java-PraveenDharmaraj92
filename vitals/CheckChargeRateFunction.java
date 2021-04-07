package vitals;

import java.util.function.Function;

public class CheckChargeRateFunction implements Function<Float, Boolean>, ICheckRange {

	@Override
	public Boolean apply(Float valueToCheck) {
		return checkRange(valueToCheck, BatteryHealthParameters.CHARGE_RATE);
	}
}
