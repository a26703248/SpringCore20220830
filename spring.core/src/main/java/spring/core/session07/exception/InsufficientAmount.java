package spring.core.session07.exception;

public class InsufficientAmount extends Exception{
	public InsufficientAmount (String errorMessage) {
		super(errorMessage);
	}
}
