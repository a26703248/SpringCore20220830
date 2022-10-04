package spring.core.session07.tx.service;

public interface BookService {
	// 誰要買哪一本書
	void buyOne(Integer wid, Integer bid);
}
