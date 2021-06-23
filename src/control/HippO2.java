package control;

public class HippO2 {

	public static void main(String[] args) {
		
		Initialization init = new Initialization();
		init.Initialize();
		

		DataStorage dataStorage = new DataStorage();
		dataStorage.datareceiver.setDataPipe();

		while (true) {

			dataStorage.datareceiver.getDataFromPipe();
			dataStorage.storeData();

		}
	}

}
