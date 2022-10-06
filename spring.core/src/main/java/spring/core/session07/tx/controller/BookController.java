package spring.core.session07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.core.session07.exception.InsufficientAmount;
import spring.core.session07.exception.InsufficientQuantity;
import spring.core.session07.tx.service.BookService;
import spring.core.session07.tx.service.BookServiceImpl;
import spring.core.session07.tx.service.ManyBookService;
import spring.core.session07.tx.service.ManyBookServiceImpl;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ManyBookService manyBookService;
	
	public void buyOneBook(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity{
		bookService.buyOne(wid, bid);
		System.out.println("Buy One OK!");
	}
	
	public void buyManyBooks(Integer wid, Integer... bids)  throws InsufficientAmount, InsufficientQuantity{
		manyBookService.buyMany(wid, bids);
		System.out.println("Buy Many OK!");
	}
	
}
