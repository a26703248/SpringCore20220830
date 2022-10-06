package spring.core.session07.tx.service;

import spring.core.session07.exception.InsufficientAmount;
import spring.core.session07.exception.InsufficientQuantity;

public interface BookService{
	// 誰要買哪一本書
	void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity;
}
