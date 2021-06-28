package analysis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import control.User;
import visualisation.Alarm;

public class Analysis {

	PatientAnalysis patientAnalyse = new PatientAnalysis();
	Alarm alarm;

	public void analyseData(short pulse, short spo2, User user) {
		checkSaturation(pulse, spo2, user);
		checkPulse(pulse, spo2, user);
		return;
	}

	protected void checkSaturation(short pulse, short spo2, User user) {
		short limitSpo2Crit = 90;
		short limitSpo2War = 95;

		if (spo2 < limitSpo2Crit) {
			alarm = new Alarm();
			alarm.critSpo2Alarm();
			alarm.setSpo2Alarm(true);
			saveAlarm(user, alarm, pulse, spo2);
			alarm.setSpo2Alarm(false);
			return;
		}

		if (spo2 < limitSpo2War) {
			alarm = new Alarm();
			alarm.warnSpo2Alarm();
			alarm.setSpo2Alarm(true);
			saveAlarm(user, alarm, pulse, spo2);
			alarm.setSpo2Alarm(false);
			return;
		}
		return;
	}

	protected void checkPulse(short pulse, short spo2, User user) {
		if (pulse > user.getCritPulseHigh()) {
			alarm = new Alarm();
			alarm.critPulseAlarmHigh();
			alarm.setPulseAlarm(true);
			saveAlarm(user, alarm, pulse, spo2);
			alarm.setPulseAlarm(false);
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

	public void saveAlarm(User user, Alarm alarm, short pulse, short spo2) {
		String str = "alarm_" + user.getName() + ".txt";
		Path path = Paths.get(str);

		if (!Files.exists(path) && Files.isDirectory(path)) {
			File logFile = new File(str);
		}

		try (FileWriter fw = new FileWriter(str, true); BufferedWriter outputLog = new BufferedWriter(fw)) {
			if (alarm.getPulseAlarm()) {
				outputLog.write("\n" + "Alarm: Pulse high!" + " Pulse = " + pulse + ", Saturation = " + spo2 + ", Date: "
						+ alarm.getAlarmDate() + ", Time: " + alarm.getAlarmTime());
				outputLog.close();
			} else if (alarm.getSpo2Alarm()) {
				outputLog.write("\n" + "Alarm: Saturation low! " + " Pulse = " + pulse + ", Saturation = " + spo2
						+ ", Date: " + alarm.getAlarmDate() + ", Time: " + alarm.getAlarmTime());
				outputLog.close();
			}

		} catch (IOException e1) {
			e1.printStackTrace();

		}
	}
}
