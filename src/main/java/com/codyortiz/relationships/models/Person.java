package com.codyortiz.relationships.models;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity 
@Table(name="persons")
public class Person {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String firstName;
	    private String lastName;
	    @Column(updatable=false)
	    private Calendar createdAt;
	    private Calendar updatedAt;
	    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	    private License license;
	    
	    public Person() {
	        
	    }

		public Person(Long id, String firstName, String lastName, License license) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.license = license;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public License getLicense() {
			return license;
		}

		public void setLicense(License license) {
			this.license = license;
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
	    
	    public String toString() {
	    	return this.firstName;
	    }
	    

}
