package com.futuregrouptask.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;

import com.futuregrouptask.DAO.BookDAO;
import com.futuregrouptask.DAO.BookSectionDAO;
import com.futuregrouptask.dto.Book;
import com.futuregrouptask.dto.BookSection;


@ManagedBean
@ViewScoped
public class BookStoreView implements Serializable{
	private List<BookSection> sections;
	private List<Book> sectionBooks;
	private BookSection currentSection;
	private Book book;
	
	public BookSection getCurrentSection() {
		return currentSection;
	}

	@ManagedProperty("#{hibernateService}")
    private HibernateService service;
	
	
	public HibernateService getService() {
		return service;
	}

	public void setService(HibernateService service) {
		this.service = service;
	}

	public List<BookSection> getAllSections(){
		Session session = service.getSessionFactory().openSession();
		BookSectionDAO bs = new BookSectionDAO(session);
		return bs.getAllSections();
	}
	
	public void loadSectionBooks(BookSection section ){
		currentSection = section;
		Session session = service.getSessionFactory().openSession();
		BookSectionDAO bs = new BookSectionDAO(session);
		sectionBooks = bs.getSectionBooks(currentSection);
	}

	public List<Book> getSectionBooks() {
		return sectionBooks;
	}

	public void setSectionBooks(List<Book> sectionBooks) {
		this.sectionBooks = sectionBooks;
	}

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
		Session session = service.getSessionFactory().openSession();
		
		BookSectionDAO bs = new BookSectionDAO(session);
		bs.addBookToSection(currentSection, book);		
		RequestContext.getCurrentInstance().closeDialog("addBook");
	}
	
	public void deleteBook(Book book){
		Session session = service.getSessionFactory().openSession();
		BookDAO bs = new BookDAO(session);
		bs.deleteBook(book);
	}
	
	
	
}
