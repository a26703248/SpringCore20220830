package spring.core.session07.tx.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.core.session07.exception.InsufficientAmount;
import spring.core.session07.exception.InsufficientQuantity;

@Service
public class ManyBookServiceImpl implements ManyBookService{
	
	@Autowired
	private BookService bookService;
	
	// https://openhome.cc/Gossip/SpringGossip/TransactionAttribute.html
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientAmount, InsufficientQuantity{
		for (Integer bid: bids){
			bookService.buyOne(wid, bid);
		}
	}
}
