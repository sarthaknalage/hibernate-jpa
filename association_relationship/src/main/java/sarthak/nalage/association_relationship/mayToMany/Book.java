package sarthak.nalage.association_relationship.mayToMany;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Column(name="book_name")
	private String bookName;
	
	@Id
	@Column(name="book_id")
	private Integer bookId;
	
	@Column(name="book_cost")
	private Double bookCost;
	
	@ManyToMany(targetEntity = Author.class,
				fetch = FetchType.EAGER,
				cascade = CascadeType.ALL
				)
	@JoinTable(name = "book_author",
			   joinColumns = @JoinColumn(name="fk_bid",referencedColumnName = "book_id"),
			   inverseJoinColumns = @JoinColumn(name="fk_aid",referencedColumnName = "author_id")
			)
	private Set<Author> authorList;
	
	public Book() {
		
	}

	public Book(String bookName, Integer bookId, Double bookCost, Set<Author> auhtorList) {
		super();
		this.bookName = bookName;
		this.bookId = bookId;
		this.bookCost = bookCost;
		this.authorList = auhtorList;
	}
	public Book(String bookName, Integer bookId, Double bookCost) {
		super();
		this.bookName = bookName;
		this.bookId = bookId;
		this.bookCost = bookCost;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Double getBookCost() {
		return bookCost;
	}

	public void setBookCost(Double bookCost) {
		this.bookCost = bookCost;
	}

	public Set<Author> getAuhtorList() {
		return authorList;
	}

	public void setAuhtorList(Set<Author> auhtorList) {
		this.authorList = auhtorList;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookId=" + bookId + ", bookCost=" + bookCost + ", auhtorList="
				+ authorList + "]";
	}
	
	
	
}
