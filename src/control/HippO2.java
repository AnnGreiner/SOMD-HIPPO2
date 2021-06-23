package control;

public class HippO2 {

	public static void main(String[] args) {
	
		DataStorage dataStorage = new DataStorage();
		
		while(true) {
			
		dataStorage.datareceiver.getDataFromPipe();
		dataStorage.storeData();
		
		
		
		}
	}

}
