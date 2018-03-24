package entity;
/**
 * 
 * @author yhj
 * 对应数据库信息s
 */
public class Book {

	private int bid;
	private String bname;
	private String author;
	private double price;
	
	public Book() {
	}
	
	public Book(int bid, String bname, String author, double price) {
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
	}
	public int getCid() {
		return bid;
	}
	public void setCid(int bid) {
		this.bid = bid;
	}
	public String getCname() {
		return bname;
	}
	public void setCname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author + ", price=" + price + "]";
	}
	
}
