package pkgLibrary;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Catalog{

	@XmlAttribute
	int id;	
	
	@XmlElement(name="book")
	ArrayList<Book> books;
	
	
	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public static void addBook(Catalog cat, Book b, int id) throws BookException{
		
		boolean hasBook = false;
		
		for(Book book : cat.getBooks()){
			if(b.isEqual(book)){
				hasBook = true;
			}
		}
		
		if(hasBook == true){
			throw new BookException("This book does not exist");
		}
		else{
			ArrayList<Book> arr = cat.getBooks();
			arr.add(b);
			cat.setBooks(arr);
		}
	}

	
	


	
	
	
	
}
