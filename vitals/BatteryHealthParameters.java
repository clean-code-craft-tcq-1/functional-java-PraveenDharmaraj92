package vitals;

public enum BatteryHealthParameters {
	
	TEMPERATURE(0,45),
	SOC(20,80),
	CHARGE_RATE(0.8f,1.0f);
	
	private final float min;
	
	private final float max;
	
	private BatteryHealthParameters(final float min, final float max){
		this.min= min;
		this.max = max;
	}
	
	public float getMin(){
	return this.min;
	}
	
	public float getMax(){
		return this.max;
	}

}
