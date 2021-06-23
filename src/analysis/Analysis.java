package analysis;

import visualisation.Alarm;

public class Analysis {
	Alarm alarm = new Alarm();

	public void analyseData(short pulse, short spo2) {
		checkSaturation(spo2);

	}

	protected void checkSaturation(short spo2) {
		short limitSpo2Crit = 90;
		short limitSpo2War = 95;

		if (spo2 < limitSpo2Crit) {
			alarm.critSpo2Alarm();
			return;
		}

		if (spo2 < limitSpo2War) {
			alarm.warnSpo2Alarm();
			return;
		}
	}
	
	protected void checkPulse(short pulse) {
		
	}
}
