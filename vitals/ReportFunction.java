package vitals;

import java.util.function.Function;

public class ReportFunction implements Function<BatteryHealthParameters, String> {

	@Override
	public String apply(BatteryHealthParameters param) {
		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append(param.toString());
		errorMessage.append(" - ");
		errorMessage.append("not in range!\n");
		errorMessage.append("Minimum value : "+param.getMin()+"\n");
		errorMessage.append("Maximum value : "+param.getMax());
		return errorMessage.toString();
	}

}
