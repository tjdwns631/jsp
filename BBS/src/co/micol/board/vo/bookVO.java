package co.micol.board.vo;

import java.sql.Date;

public class bookVO {
int book_no;
String book_name;
String book_coverimg;
Date book_date;
int book_price;
String book_publisher;
String book_info;
int rent_no;
int rent_price;
String rent_date;
String rent_status;



public int getRent_no() {
	return rent_no;
}
public void setRent_no(int rent_no) {
	this.rent_no = rent_no;
}
public int getRent_price() {
	return rent_price;
}
public void setRent_price(int rent_price) {
	this.rent_price = rent_price;
}
public String getRent_date() {
	return rent_date;
}
public void setRent_date(String rent_date) {
	this.rent_date = rent_date;
}
public String getRent_status() {
	return rent_status;
}
public void setRent_status(String rent_status) {
	this.rent_status = rent_status;
}
public int getBook_no() {
	return book_no;
}
public void setBook_no(int book_no) {
	this.book_no = book_no;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
}
public String getBook_coverimg() {
	return book_coverimg;
}
public void setBook_coverimg(String book_coverimg) {
	this.book_coverimg = book_coverimg;
}
public Date getBook_date() {
	return book_date;
}
public void setBook_date(Date book_date) {
	this.book_date = book_date;
}
public int getBook_price() {
	return book_price;
}
public void setBook_price(int book_price) {
	this.book_price = book_price;
}
public String getBook_publisher() {
	return book_publisher;
}
public void setBook_publisher(String book_publisher) {
	this.book_publisher = book_publisher;
}
public String getBook_info() {
	return book_info;
}
public void setBook_info(String book_info) {
	this.book_info = book_info;
}
@Override
public String toString() {
	return "bookVO [book_no=" + book_no + ", book_name=" + book_name + ", book_coverimg=" + book_coverimg
			+ ", book_date=" + book_date + ", book_price=" + book_price + ", book_publisher=" + book_publisher
			+ ", book_info=" + book_info + ", rent_no=" + rent_no + ", rent_price=" + rent_price + ", rent_date="
			+ rent_date + ", rent_status=" + rent_status + "]";
}
public bookVO() {
	super();
	
}



}
