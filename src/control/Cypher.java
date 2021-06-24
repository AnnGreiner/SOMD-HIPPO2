package control;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Cypher {
	private SecretKey key;
	private IvParameterSpec iv;
	
	public String encrypt() {
		try {
			Cipher cypher = Cipher.getInstance("AES");
			cypher.init(cypher.ENCRYPT_MODE, this.key, this.iv);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "------------------"; // add viable return statement
	}

	private void generateKey() { // get key from password? no need to save it anywhere?
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(256); // 256 key length
			SecretKey key = keyGenerator.generateKey();
			this.key = key;
			System.out.println(key);
			return;
		} catch (NoSuchAlgorithmException e) {
			// do some shit
		};
		return;
	}

	private void generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		this.iv = new IvParameterSpec(iv);
		return;
	}
}