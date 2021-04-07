package vitals;

public interface ICheckRange {
	/**
	 * @param valueToCheck - value to check
	 * @param param - battery parameter to check
	 * @return true if within limits
	 */
	public default boolean checkRange(float valueToCheck, BatteryHealthParameters param){
		return valueToCheck>param.getMin()&&valueToCheck<param.getMax();
	}
}
