package control;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {

	DataReceiver datareceiver = new DataReceiver();

	protected void storeData() {
		short pulse = datareceiver.getData(4);
		short spO2 = datareceiver.getData(5);
		LocalDate localDate = LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();

		String str = "log.txt";
		Path path = Paths.get(str);

		if (!Files.exists(path) && Files.isDirectory(path)) {
			File logFile = new File(str);
		}

		try (FileWriter fw = new FileWriter(str, true); BufferedWriter outputLog = new BufferedWriter(fw)) {
			outputLog.write("\n" + "Pulse: " + pulse + ", Saturation: " + spO2 + ", Date: " + localDate + ", Time: "
					+ localDateTime);
			outputLog.close();
		} catch (IOException e1) {
			e1.printStackTrace();

		}

	}
	
	List<User> userList= new ArrayList<>();
}
