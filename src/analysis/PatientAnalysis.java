package analysis;

import control.User;

public class PatientAnalysis {

	/* Ruhepulse: Er liegt bei einem erwachsenen, gesunden Menschen zwischen 50 und
	 100; Über 100
	 -->Tachykardie; unter 40 -->x zu niedrig!!!
	 Langsamer Ruhepuls: < 60 Schläge/Min
	 Normaler Ruhepuls: 60-80
	 Schneller Ruhepuls: 80-100
	 Zu schneller Ruhepuls: > 100

	 Männer: Maximalpuls = 214 - 0,5 × Lebensalter - 0,11 × Körpergewicht in kg
	 Frauen: Maximalpuls = 210 - 0,5 × Lebensalter - 0,11 × Körpergewicht in kg

	 Trainingsherzfrequenz = (HFmax - Ruhepuls) × Faktor + Ruhepuls

	 Nach Karvonen liegen die Faktoren wie folgt:
	 Für intensives Ausdauertraining: 0,8
	 Für extensives, also lockeres Ausdauertraining: 0,6
	 Und für Untrainierte: 0,5 */

	public User analysePatient(User user) {
		short mP = 0;
		if (user.checkMale()) {
			mP = (short) ((short) 214 - 0.5 * user.getAge() - 0.11 * (short) user.getWeight());
		} else {
			mP = (short) ((short) 210 - 0.5 * user.getAge() - 0.11 * (short) user.getWeight());
		}
		short tP = (short) ((mP - user.getRestPulse()) * 0.8 + user.getRestPulse());
		user.setTrainPulse(tP);
		//user.setCritPulseHigh((short) ((short) mP * 0.9)); //not possible due to emulator
		user.setCritPulseHigh((short) 60);
		return user;
	}
}
