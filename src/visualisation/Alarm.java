package visualisation;

public class Alarm {
	
	public void critSpo2Alarm() {
		System.out.println("Kritischer Wert!");
	}
	
	public void warnSpo2Alarm() {
		System.out.println("Warnung!!!");
	}
	
	public void critPulseAlarmHigh() {
		System.out.println("Kritischer Wert: Pulse zu hoch!");
	}
	
	public void warnPulseAlarmHigh() {
		System.out.println("Warnung: Pulse hoch!");
		
	}
	
	public void critPulseAlarmLow() {
		System.out.println("Kritischer Wert: Pulse zu niedrig!");
	}
	
	public void warnPulseAlarmLow() {
		System.out.println("Warnung: Pulse niedrig!");
	}
}
