package analysis;

import control.User;

public class PatientAnalysis {
	
	protected short critPulseHigh;	
	protected short critPulseLow;
	protected short warnPulseHigh;
	protected short warnPulseLow;
	
	// Ruhepulse:  Er liegt bei einem erwachsenen, gesunden Menschen zwischen 50 und 100; Über 100 -->Tachykardie; unter 40 -->x zu niedrig!!!
	// Langsamer Ruhepuls: < 60 Schläge/Min
	// Normaler Ruhepuls: 60-80
	// Schneller Ruhepuls: 80-100
	// Zu schneller Ruhepuls: > 100
	
	// Männer: Maximalpuls = 214 - 0,5 × Lebensalter - 0,11 × Körpergewicht in kg
	// Frauen: Maximalpuls = 210 - 0,5 × Lebensalter - 0,11 × Körpergewicht in kg
	
	// Trainingsherzfrequenz = (HFmax - Ruhepuls) × Faktor + Ruhepuls
	
	//Nach Karvonen liegen die Faktoren wie folgt:
		//Für intensives Ausdauertraining: 0,8
		//Für extensives, also lockeres Ausdauertraining: 0,6
		//Und für Untrainierte: 0,5
	
	
	public PatientAnalysis analysePatient(User user) {
		
	}
	
	public boolean isSpO2low() {
		if() {
			return true;
		}else
	}

}
