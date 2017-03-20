package pkgEmpty;

import pkgLibrary.*;
import pkgMain.*;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testing {
	
	
	@Test
	public void TestGetBook() throws BookException{
		
		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		String id = "bk101";
		Book b = new Book("bk101","Gambardella, Matthew","XML Developer's Guide","Computer",49.45, new Date(), "desc");
		
		assertEquals(true, (b.isEqual(Book.getBook(cat, id))));
		
		
		
	}
	
	
	@Test
	public void TestAddBook() throws BookException{
		
		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		
		int length = cat.getBooks().size();
		
		
		Book b = new Book("bk404","author","title","genre",20,new Date(), "desc");
		Catalog.addBook(cat, b, 0);
		
		//If a book was added, then the length of the catalog will increase by one
		assertEquals((cat.getBooks().size()),(length + 1));
		
	}
	
}
