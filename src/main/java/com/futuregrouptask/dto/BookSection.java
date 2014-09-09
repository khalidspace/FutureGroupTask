package com.futuregrouptask.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class BookSection {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int sectionId;
	private String sectionName;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="SECTION_BOOKS",
				joinColumns=@JoinColumn(name="SECTION_ID"),
				inverseJoinColumns=@JoinColumn(name="BOOK_ID"))
	private List<Book> sectionBooks = new ArrayList<Book>(); 
	
	
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public List<Book> getSectionBooks() {
		return sectionBooks;
	}
	public void setSectionBooks(List<Book> sectionBooks) {
		this.sectionBooks = sectionBooks;
	}
}
