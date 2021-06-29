package control;

public class HippO2 {

	public static void main(String[] args) throws InterruptedException {

		Initialization init = new Initialization();
		User user = init.Initialize();

		DataStorage dataStorage = new DataStorage();
		dataStorage.datareceiver.setDataPipe();
		HippO2Management hippMan = new HippO2Management();
		// hippMan.start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				hippMan.checkInput();
			}
		}).start();

		while (true) {

			dataStorage.datareceiver.getDataFromPipe();
			dataStorage.storeData(user);

			hippMan.analysis.analyseData(dataStorage.datareceiver.getData(4), dataStorage.datareceiver.getData(5),
					user);

			Thread.sleep(1000);	
			

		}
	}

}
