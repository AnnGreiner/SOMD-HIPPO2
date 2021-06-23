package control;

import analysis.Analysis;

public class HippO2 {

	public static void main(String[] args) {
		
		Initialization init = new Initialization();
		User user = init.Initialize();
		

		DataStorage dataStorage = new DataStorage();
		dataStorage.datareceiver.setDataPipe();
		Analysis analysis = new Analysis();
		
		while (true) {

			dataStorage.datareceiver.getDataFromPipe();
			dataStorage.storeData(user);
			
			analysis.analyseData(dataStorage.datareceiver.getData(4), dataStorage.datareceiver.getData(5));

		}
	}

}
