package spring.core.session01.beans;

import java.util.Random;

public class Lucky {
	private int number;
	public Lucky() {
		System.out.println("Lotto 建構子");
		number = new Random().nextInt(1000);
	}
	@Override
	public String toString() {
		return "Lucky [number=" + number + "]";
	}
	
}
