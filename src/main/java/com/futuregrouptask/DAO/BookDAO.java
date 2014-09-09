package com.futuregrouptask.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.futuregrouptask.dto.Book;
import com.futuregrouptask.dto.BookSection;

public class BookDAO {

	private final Session session;

	public BookDAO(Session session) {
		this.session = session;
	}
	

	public void addBook(Book book ){
		session.save(book);
	}
	
	public void deleteBook(Book book ){
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getBooksbySection(BookSection section )
	{
		 List<Book> books = (List<Book>) session.createCriteria(Book.class)
					.add(Restrictions.eq("bookSection",section)).list();
		return books;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks(BookSection section )
	{
		
		return session.createCriteria(Book.class).list();
	}

	
}
