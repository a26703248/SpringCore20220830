package spring.core.session01.beans;

import java.util.Date;

public class Hello {

	Date today = new Date();

	public Hello() {
		System.out.println("Hello 建構子");
	}
	
	@Override
	public String toString() {
		return "Hello [today=" + today + "]";
	}
	
}
