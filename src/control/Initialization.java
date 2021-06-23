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
		
			e.printStackTrace();
		}

	}

	protected void Login() {
		try {
			System.out.println("Name: ");
			String name = br.readLine();

			System.out.println("Password: ");
			String password = br.readLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void Register() {
		try {
			
			User user = new User();
			
			System.out.println("Name: ");
			String name = br.readLine();
			user.setName(name);
			
			System.out.println("Age: ");
			int age  = Integer.parseInt(br.readLine());			
			user.setAge(age);
			
			System.out.println("Weight: ");
			int weight  = Integer.parseInt(br.readLine());			
			user.setWeight(weight);
			
			System.out.println("Male (M) or Female (F):");
			String input = br.readLine();

			if ("M".equals(input) || "m".equals(input)) {
				user.isMale(true);
			}
			if ("F".equals(input) || "f".equals(input)) {
				user.isMale(false);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		;

	}

	protected boolean checkUserList() {

	}

}
