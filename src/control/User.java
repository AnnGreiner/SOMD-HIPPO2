package control;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.Serializable;

public class User implements Serializable {

	private String name;
	private String passwordHash;
	private int age;
	private boolean male;
	// private boolean female;
	private double weight;
	private short restPulse;
	private short maxPulse;
	private short trainPulse;
	private short critPulseHigh;


	protected void setName(String s) {
		this.name = s;
	}

	public String getName() {
		return this.name;
	}

	protected void setpasswordHash(String pH) {
		this.passwordHash = pH;
	}

	protected String getPasswordHash() {
		return this.passwordHash;
	}

	protected void setAge(int a) {
		this.age = a;
	}

	public int getAge() {
		return this.age;
	}

	protected void setWeight(int w) {
		this.weight = w;
	}

	public double getWeight() {
		return this.weight;
	}

	protected void isMale(boolean male) {
		this.male = male;
	}

	public boolean checkMale() {
		return this.male;
	}

	protected void setRestPulse(short rP) {
		this.restPulse = rP;
		return;
	}

	public short getRestPulse() {
		return this.restPulse;
	}

	public short getMaxPulse() {
		return this.maxPulse;
	}

	public void setMaxPulse(short mP) {
		this.maxPulse = mP;
		return;
	}

	public void setTrainPulse(short tP) {
		this.trainPulse = tP;
		return;
	}

	public short getTrainPulse() {
		return this.trainPulse;
	}

	public void setCritPulseHigh(short critP) {
		this.critPulseHigh = critP;
		return;
	}

	public short getCritPulseHigh() {
		return this.critPulseHigh;
	}
	// protected void isFemale(boolean f) {
	// this.female = f;}

	// protected boolean checkFemale() {
	// return this.female;}
}
