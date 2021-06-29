package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Scanner;

import analysis.Analysis;
import visualisation.Alarm;

public class HippO2Management extends Thread {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Analysis analysis = new Analysis();
	Alarm alarm = analysis.getAlarm();

	public void checkInput() {

		try {
			while (true) {

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
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
}
