package pkgLibrary;

public class BookException extends Exception{
	public BookException(){
		super();
	}
	public BookException(String message){
		super(message);
	}
	public BookException(String message, Throwable clause){
		super(message, clause);
	}
	public BookException(Throwable clause){
		super(clause);
	}
}
