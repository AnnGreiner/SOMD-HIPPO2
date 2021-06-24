package analysis;


import visualisation.Alarm;

public class Analysis {
	Alarm alarm = new Alarm();
	PatientAnalysis patientAnalyse = new PatientAnalysis();

	public void analyseData(short pulse, short spo2, PatientAnalysis patientAnalysis) {
		checkSaturation(spo2);
		checkPulse(pulse, patientAnalysis);

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
	
	protected void checkPulse(short pulse, PatientAnalysis patientAnalysis ) {
		if (pulse > patientAnalysis.critPulseHigh) {
			alarm.critPulseAlarmHigh();
			return;
		}

		if (pulse > patientAnalysis.warnPulseHigh) {
			alarm.warnPulseAlarmHigh();
			return;
		}
		
		if (pulse < patientAnalysis.critPulseHigh) {
			alarm.critPulseAlarmLow();
			return;
		}

		if (pulse < patientAnalysis.warnPulseLow) {
			alarm.warnPulseAlarmLow();
			return;
		}
		
	}
}
