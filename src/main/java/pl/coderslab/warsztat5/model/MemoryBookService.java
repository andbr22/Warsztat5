package pl.coderslab.warsztat5.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService {
	private static long nextId = 1L;
	private List<Book> list;

	public MemoryBookService() {
		this.list = new ArrayList<>();
		add(new Book(0L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
		add(new Book(0L, "9788324627738", "Rusz glowa, Java.", "Sierra Kathy, Bates Bert", "Helion",
				"programming"));
		add(new Book(0L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
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
		for(Book iterBook: this.list) {
			if(iterBook.getId() == book.getId()) {
				iterBook.setAuthor(book.getAuthor());
				iterBook.setIsbn(book.getIsbn());
				iterBook.setPublisher(book.getIsbn());
				iterBook.setTitle(book.getTitle());
				iterBook.setType(book.getType());
			}
		}
	}

	public void deleteBook(Book book) throws NoSuchElementException{
		deleteBookById(book.getId());
	}
	
	public void deleteBookById(long id) throws NoSuchElementException{
		Book b = this.getById(id);
		this.list.remove(b);
	}

	public Book add(Book book) {
		book.setId(nextId++);
		this.list.add(book);
		return book;
	}
	
	
}
