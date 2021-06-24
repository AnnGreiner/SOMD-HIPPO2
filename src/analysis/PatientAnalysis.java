package analysis;

import control.User;

public class PatientAnalysis {
	
	protected short critPulseHigh;	
	protected short critPulseLow;
	protected short warnPulseHigh;
	protected short warnPulseLow;
	
	// Ruhepulse:  Er liegt bei einem erwachsenen, gesunden Menschen zwischen 50 und 100; �ber 100 -->Tachykardie; unter 40 -->x zu niedrig!!!
	// Langsamer Ruhepuls: < 60 Schl�ge/Min
	// Normaler Ruhepuls: 60-80
	// Schneller Ruhepuls: 80-100
	// Zu schneller Ruhepuls: > 100
	
	// M�nner: Maximalpuls = 214 - 0,5 � Lebensalter - 0,11 � K�rpergewicht in kg
	// Frauen: Maximalpuls = 210 - 0,5 � Lebensalter - 0,11 � K�rpergewicht in kg
	
	// Trainingsherzfrequenz = (HFmax - Ruhepuls) � Faktor + Ruhepuls
	
	//Nach Karvonen liegen die Faktoren wie folgt:
		//F�r intensives Ausdauertraining: 0,8
		//F�r extensives, also lockeres Ausdauertraining: 0,6
		//Und f�r Untrainierte: 0,5
	
	
	public PatientAnalysis analysePatient(User user) {
		
	}
	
	public boolean isSpO2low() {
		if() {
			return true;
		}else
	}

}
