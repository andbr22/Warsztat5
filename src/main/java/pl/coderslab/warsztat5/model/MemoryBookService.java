package pl.coderslab.warsztat5.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService {
	private List<Book> list;

	public MemoryBookService() {
		this.list = new ArrayList<>();
		list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
		list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion",
				"programming"));
		list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
				"programming"));
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}
	
	public Book getById(long id) throws NoSuchElementException {
		//wyrażenie lambda
		Predicate <Book> bookById = c -> c.getId() == id;
		Book book = this.list.stream().filter(bookById).findFirst().get();
		return book;
	}
	
	public void editBook(Book book) throws NoSuchElementException{
		Book b = this.getById(book.getId());
		b = book;
	}

	public void deleteBook(Book book) throws NoSuchElementException{
		deleteBookById(book.getId());
	}
	
	public void deleteBookById(long id) throws NoSuchElementException{
		Book b = this.getById(id);
		this.list.remove(b);
	}
}
