package customexception;

public class NoSuchKeywordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchKeywordException(String message){
		super(message);
	}
}
