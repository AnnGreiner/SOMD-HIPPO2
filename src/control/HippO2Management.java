package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import analysis.Analysis;
import visualisation.Alarm;

public class HippO2Management {

	Thread t1 = new Thread();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Analysis analysis = new Analysis();
	Alarm alarm = analysis.getAlarm();

	public void checkInput() {

		try {
			String input = br.readLine();

			if ("O".equals(input) || "o".equals(input)) {

				alarm.snoozeSpO2Alarm();
			}

			if ("P".equals(input) || "p".equals(input)) {

				alarm.snoozePulseAlarm();
			}

			if ("R".equals(input) || "r".equals(input)) {

				alarm.resetAlarm();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
