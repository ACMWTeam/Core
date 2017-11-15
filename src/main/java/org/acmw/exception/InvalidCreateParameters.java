package org.acmw.exception;

public class InvalidCreateParameters extends Exception {
	
	private static final long serialVersionUID = 1L;

	@SafeVarargs
	public InvalidCreateParameters(Object wrongParameter, Class<? extends Object>... correct) {
		super(wrongParameter.getClass().getName() + " is not a valid parameter. Please use the following: " + toString(correct));
	}
	
	@SuppressWarnings("unchecked")
	private static String toString(Class<? extends Object>... correct) {
		String correctPa = null;
		for(Class<? extends Object> klass : correct) {
			if(correctPa == null) {
				correctPa = klass.getName();
			}else {
				correctPa = correctPa + ", " + klass.getName();
			}
		}
		return correctPa;
	}

}
