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
	boolean alarmPulse = false;
	boolean alarmSpo2 = false;


	Timer timer = new Timer();
	Thread thread = new Thread();

	

	public void snoozeSpO2Alarm() {
		thread.start();
		pauseSpO2Alarm = true;
		pauseSpO2Warning = true;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		pauseSpO2Alarm = false;
		pauseSpO2Warning = false;
		return;
	}

	public void snoozePulseAlarm() {
		thread.start();
		pausePulseAlarm = true;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		pausePulseAlarm = false;
		return;

	}

	
	public void resetAlarm() {
		Thread.interrupted();
	}

	public void critSpo2Alarm() {

		if (!pauseSpO2Alarm) {
			System.out.println("Kritischer Wert!");
		}
	}

	public void warnSpo2Alarm() {
		if (!pauseSpO2Warning) {
			System.out.println("Warnung!!!");
		}
	}

	public void critPulseAlarmHigh() {
		if (!pausePulseAlarm) {
			System.out.println("Kritischer Wert: Pulse zu hoch!");
		}
	}
	
	public LocalDate getAlarmDate() {
		return this.localDateAlarm;
	}
	
	public LocalDateTime getAlarmTime() {
		return this.localDateTimeAlarm;
	}
	
	public void setPulseAlarm(boolean value) {
		this.alarmPulse = value;
		return;
	}
	
	public boolean getPulseAlarm() {
		return this.alarmPulse;
		
	}
	
	public void setSpo2Alarm(boolean value) {
		this.alarmSpo2 = value;
		return;
	}
	public boolean getSpo2Alarm() {
		return this.alarmSpo2;
		
	}
}
