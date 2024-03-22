package sarthak.nalage.association_relationship.mayToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="auhtor")
public class Author {
	
	@Column(name="author_name")
	private String authorName;
	
	@Id
	@Column(name="author_id")
	private Integer authorId;
	
	@Column(name="author_qual")
	private String authoQual;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "authorList")
	
	private Set<Book>bookList;
	
	public Set<Book> getBookList() {
		return bookList;
	}

	public void setBookList(Set<Book> bookList) {
		this.bookList = bookList;
	}

	public Author() {
		
	}

	public Author(String authorName, Integer authorId, String authoQual) {
		super();
		this.authorName = authorName;
		this.authorId = authorId;
		this.authoQual = authoQual;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthoQual() {
		return authoQual;
	}

	public void setAuthoQual(String authoQual) {
		this.authoQual = authoQual;
	}

	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", authorId=" + authorId + ", authoQual=" + authoQual
				+ ", bookList=" + bookList + "]";
	}
	

}
