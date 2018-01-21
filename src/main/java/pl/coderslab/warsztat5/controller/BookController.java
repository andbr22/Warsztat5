package pl.coderslab.warsztat5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.warsztat5.model.Book;
import pl.coderslab.warsztat5.model.MemoryBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	MemoryBookService bookService;
	
	@RequestMapping("")
	public List<Book> getList() {
		return	this.bookService.getList();
	}
	
	@GetMapping("/{id}")
	public Book getById(@PathVariable("id") long id) {
		return	this.bookService.getById(id);
	}
	
	@PostMapping("")
	public Book addBook(@RequestBody Book book){
		return this.bookService.add(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") long id){
		//System.out.println("hey");
		this.bookService.deleteBookById(id);
	}
	
	@PutMapping("/{id}")
	public void editBook(@RequestBody Book book, @PathVariable("id") long id) {
		book.setId(id);
		//System.out.println(book);
		this.bookService.editBook(book);
	}
}
