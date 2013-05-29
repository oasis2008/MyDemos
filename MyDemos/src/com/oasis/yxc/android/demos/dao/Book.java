package com.oasis.yxc.android.demos.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

	private String bookname;
	private String author;
	private int pulishtime;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPulishtime() {
		return pulishtime;
	}

	public void setPulishtime(int pulishtime) {
		this.pulishtime = pulishtime;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(bookname);
		dest.writeString(author);
		dest.writeInt(pulishtime);
	}

	// must be public static
	// or exception
	// Caused by: android.os.BadParcelableException: Parcelable protocol
	// requires a Parcelable.Creator object called CREATOR on class
	// com.oasis.yxc.android.demos.dao.Book
	public static final Parcelable.Creator<Book> CREATOR = new Creator<Book>() {

		@Override
		public Book[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Book[size];
		}

		@Override
		public Book createFromParcel(Parcel source) {
			Book book = new Book();
			book.bookname = source.readString();
			book.author = source.readString();
			book.pulishtime = source.readInt();

			return book;
		}
	};

	@Override
	public String toString() {
		return "Book [bookname=" + bookname + ", author=" + author
				+ ", pulishtime=" + pulishtime + "]";
	}

}
