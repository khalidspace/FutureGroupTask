package com.futuregrouptask.views;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.futuregrouptask.dto.Book;


@ManagedBean(name="bookView")
@ViewScoped
public class BookView {

	private Book book;

		
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public void openAddBookDialog()
	{
		RequestContext.getCurrentInstance().openDialog("addBook");		
	}
	
	public void SaveBook(){
		
		RequestContext.getCurrentInstance().closeDialog("bookView");
	}
	
}
