package application;

public class Inventory {

	public static int sword = 0;
	public static int dagger = 0;

	public static int getSword() {
		return sword;
	}

	public static int getDagger() {
		return dagger;
	}

	public static void addSword() {
		sword++;
	}

	public static void addDagger() {
		dagger++;
	}

	public static void addItem(String weapon) {
		switch (weapon) {
		case "Sword":
			addSword();
			break;
		case "Dagger":
			addDagger();
			break;
		default:
			break;
		}

	}

}
