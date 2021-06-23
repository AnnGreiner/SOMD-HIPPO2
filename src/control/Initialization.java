package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Initialization {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	protected void Initialize() {
		try {
			

			while (true) {
				System.out.println("Login (L) or Register new Account (R):");
				String input = br.readLine();

				if ("L".equals(input) || "l".equals(input)) {
					Login();
					break;
				}
				if ("R".equals(input) || "r".equals(input)) {
					Register();
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void Login() {
		
	}
	
	protected void Register() {
		
	}
	
	protected boolean checkUserList() {
		
	}

}
