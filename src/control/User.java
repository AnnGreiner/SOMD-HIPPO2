package control;

public class User {

	private String name;
	private int age;
	private boolean male;
	// private boolean female;
	private double weight;
	

	protected void setName(String s) {
		this.name = s;
	}

	protected String getName() {
		return this.name;
	}

	protected void setAge(int a) {
		this.age = a;
	}

	protected int getAge() {
		return this.age;
	}

	protected void setWeight(int w) {
		this.weight = w;
	}

	protected double getWeight() {
		return this.weight;
	}

	protected void isMale(boolean male) {
		this.male = male;
	}

	protected boolean checkMale() {
		return this.male;
	}

	// protected void isFemale(boolean f) {
	// this.female = f;}

	// protected boolean checkFemale() {
	// return this.female;}

}
