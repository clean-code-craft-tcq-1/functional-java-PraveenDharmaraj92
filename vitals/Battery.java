package vitals;

/**
 * @author PDH2COB
 * Class with battery parameters
 */
public class Battery {

	private final int temperature;

	private final float chargeRate;

	private final int soc;

	public Battery(final int temperature, final float chargeRate, final int soc) {
		super();
		this.temperature = temperature;
		this.chargeRate = chargeRate;
		this.soc = soc;
	}

	public int getTemperature() {
		return temperature;
	}

	public float getChargeRate() {
		return chargeRate;
	}

	public int getSoc() {
		return soc;
	}

}
