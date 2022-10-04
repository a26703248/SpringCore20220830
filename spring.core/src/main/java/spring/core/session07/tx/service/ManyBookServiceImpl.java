package spring.core.session07.tx.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManyBookServiceImpl implements ManyBookService{
	
	@Autowired
	private BookService bookService;

	@Override
	public void buyMany(Integer wid, Integer... bids) {
		for (Integer bid: bids){
			bookService.buyOne(wid, bid);
		}
	}
}
