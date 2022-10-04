package spring.core.session07.tx.service;

public interface ManyBookService {
	void buyMany(Integer wid, Integer... bids);
}
