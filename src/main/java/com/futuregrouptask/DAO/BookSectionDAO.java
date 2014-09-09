package com.futuregrouptask.DAO;

import java.util.List;

import org.hibernate.Session;

import com.futuregrouptask.dto.Book;
import com.futuregrouptask.dto.BookSection;

public class BookSectionDAO {

	private final Session session;

	public BookSectionDAO(Session session) {
		this.session = session;
	}

	
	@SuppressWarnings("unchecked")
	public List<BookSection> getAllSections() {
		List<BookSection> list = (List<BookSection>) session.createCriteria(BookSection.class).list();
		return list;

	}
	
	public List<Book> getSectionBooks(BookSection section) {
		return section.getSectionBooks();
		

	}
	
	public void addBookToSection(BookSection section,Book book)
	{
		getSectionBooks(section).add(book);
		session.beginTransaction();
		session.save(section);
		session.getTransaction().commit();
	}
	
	

	public Session getSession() {
		return session;
	}

}
