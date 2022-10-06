package spring.core.session07.tx.dao;

import spring.core.session07.exception.InsufficientAmount;
import spring.core.session07.exception.InsufficientQuantity;

public interface BookDao {
	Integer getBookPrice(Integer bid); // 根據 bid 取得書本價格
	Integer getStockAmount(Integer bid); // 根據 bid 取得庫存數
	Integer getWalletMoney(Integer wid); // 根據 wid 取得可用餘額
	Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity; // 修改庫存，減去 amount
	Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount; // 變更錢包金額
}
