package analysis;


import control.User;
import visualisation.Alarm;


public class Analysis {
	Alarm alarm = new Alarm();
	PatientAnalysis patientAnalyse = new PatientAnalysis();

	public void analyseData(short pulse, short spo2, User user) {
		checkSaturation(spo2);
		checkPulse(pulse, user);
		return;
	}

	protected void checkSaturation(short spo2) {
		short limitSpo2Crit = 90;
		short limitSpo2War = 97;

		if (spo2 < limitSpo2Crit) {
			
			alarm.critSpo2Alarm();
			return;
		}

		if (spo2 < limitSpo2War) {
			
			alarm.warnSpo2Alarm();
			return;
		}
		return;
	}
	
	protected void checkPulse(short pulse, User user) {
		if (pulse > user.getCritPulseHigh()) {
			
			alarm.critPulseAlarmHigh();
			return;
		}
		return;
	}
	
	public Alarm getAlarm() {
		return this.alarm;
	}
	
	protected void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
}
