package spring.core.session03.beans;

public class DBConn {
	public void open() {
		System.out.println("開啟資料庫連線");
	}
	
	public void find() {
		System.out.println("查找資料...");
	}
	
	public void close() {
		System.out.println("關閉資料庫連線");
	}
}
