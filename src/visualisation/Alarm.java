package visualisation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Timer;

public class Alarm {

	boolean pauseSpO2Alarm = false;
	boolean pausePulseAlarm = false;
	boolean pauseSpO2Warning = false;
	LocalDate localDateAlarm = LocalDate.now();
	LocalDateTime localDateTimeAlarm = LocalDateTime.now();


	Timer timer = new Timer();
	

	

	public void snoozeSpO2Alarm() {
		Thread thread = new Thread();
		thread.start();
		pauseSpO2Alarm = true;
		pauseSpO2Warning = true;

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		pauseSpO2Alarm = false;
		pauseSpO2Warning = false;
		return;
	}

	public void snoozePulseAlarm() {
		Thread thread = new Thread();
		thread.start();
		pausePulseAlarm = true;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		pausePulseAlarm = false;
		return;

	}

	
	public void resetAlarm() {
		//thread.interrupt();
		pausePulseAlarm = true;
		pauseSpO2Alarm = true;
		pauseSpO2Warning = true;
	}

	public void critSpo2Alarm() {

		if (!pauseSpO2Alarm) {
			System.out.println("Saturation too low!! Press 'o' to pause the alarm for 10 seconds and 'r' to deactivate the alarm.");
		}
	}

	public void warnSpo2Alarm() {
		if (!pauseSpO2Warning) {
			System.out.println("Saturation Warning! Press 'o' to pause the alarm for 10 seconds and 'r' to deactivate the alarm.");
		}
	}

	public void critPulseAlarmHigh() {
		if (!pausePulseAlarm) {
			System.out.println("Pulse too high!!! Press 'p' to pause the alarm for 10 seconds and 'r' to deactivate the alarm.");
		}
	}
}
