package spring.core.session07.exception;

public class InsufficientQuantity extends Exception{
	public InsufficientQuantity (String errorMessage) {
		super(errorMessage);
	}
}
