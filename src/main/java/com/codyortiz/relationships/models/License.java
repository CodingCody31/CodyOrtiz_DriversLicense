package com.codyortiz.relationships.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Calendar expirationDate;
    private String state;
    @Column(updatable=false)
    private Calendar createdAt;
    private Calendar updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    public License() {
        
    }
	public License(Long id, String number, Calendar expirationDate, String state, Person person) {
		super();
		this.id = id;
		this.number = number;
		this.expirationDate = expirationDate;
		this.state = state;
		this.person = person;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Calendar getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Calendar getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}
	
	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = Calendar.getInstance();
	    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = Calendar.getInstance();
	    }
    
    

}
