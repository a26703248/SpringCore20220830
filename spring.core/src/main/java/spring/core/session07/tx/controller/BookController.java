package spring.core.session07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.core.session07.tx.service.BookServiceImpl;
import spring.core.session07.tx.service.ManyBookServiceImpl;

@Controller
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@Autowired
	private ManyBookServiceImpl manyBookService;
	
	public void buyOneBook(Integer wid, Integer bid) {
		bookService.buyOne(wid, bid);
		System.out.println("Buy One OK!");
	}
	
	public void buyManyBooks(Integer wid, Integer... bids) {
		manyBookService.buyMany(wid, bids);
		System.out.println("Buy Many OK!");
	}
	
}
