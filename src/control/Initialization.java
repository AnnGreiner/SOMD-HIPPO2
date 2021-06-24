package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import analysis.PatientAnalysis;

public class Initialization {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	List<User> userList = new ArrayList<>();

	protected User Initialize() {
		userList = getUserList();
		User user = new User();
		try {

			while (true) {
				System.out.println("Login (L) or Register new Account (R):");
				String input = br.readLine();

				if ("L".equals(input) || "l".equals(input)) {
					user = Login();
					break;
				}
				if ("R".equals(input) || "r".equals(input)) {
					user = Register();
					userList.add(user);
					saveUserList(userList);
					break;
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return user;
	}

	protected User Login() {
		while (true) {
			try {
				System.out.println("Name: ");
				String name = br.readLine();

				System.out.println("Password: ");
				String password = br.readLine();

				if (checkUserLogin(name, password)) {
					return getUser(name);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	protected User Register() {

		try {

			User user = new User();

			System.out.println("Username: ");
			String name = br.readLine();
			user.setName(name);

			System.out.println("Password: ");
			String passwordString = br.readLine();
			String passwordHash = createHash(passwordString);
			user.setpasswordHash(passwordHash);

			System.out.println("Age: ");
			int age = Integer.parseInt(br.readLine());
			user.setAge(age);

			System.out.println("Male (M) or Female (F):");
			String input = br.readLine();
			if ("M".equals(input) || "m".equals(input)) {
				user.isMale(true);
			}
			if ("F".equals(input) || "f".equals(input)) {
				user.isMale(false);
			}
			
			System.out.println("Weight: ");
			int weight = Integer.parseInt(br.readLine());
			user.setWeight(weight);

			System.out.println("Resting Pulse: ");
			short rP = Short.parseShort(br.readLine());
			user.setRestPulse(rP);
			
			PatientAnalysis analy = new PatientAnalysis();
			user = analy.analysePatient(user);
			
			return user;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		;
		return null;

	}

	protected String createHash(String pw) {

		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			byte[] messageDigest = md.digest(pw.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	private List<User> getUserList() {
		String str = ".userList";
		Path path = Paths.get(str);

		if (Files.exists(path) && !Files.isDirectory(path)) {
			try {
				FileInputStream fis = new FileInputStream(str);
				ObjectInputStream ois = new ObjectInputStream(fis);
				List<User> ul = new ArrayList<>();
				ul = (List<User>) ois.readObject();
				ois.close();
				return ul;

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		List<User> ul = new ArrayList<>();
		return ul;
	}

	protected Boolean checkUserLogin(String username, String userPassword) {
		String pwHashed = createHash(userPassword);
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().equals(username)) {
				if (userList.get(i).getPasswordHash().equals(pwHashed)) {
					return true;
				}
			}
		}
		return false;
	}

	private User getUser(String name) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getName().equals(name)) {
				return userList.get(i);
			}
		}
		return null;
	}

	private void saveUserList(List<User> userList) {
		String str = ".userList";

		try {
			FileOutputStream fos = new FileOutputStream(str);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
