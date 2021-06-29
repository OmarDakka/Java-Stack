package com.codingdojo.loginandregisteration.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@Transient
	private String passwordConfirmation;
	private String city;
	private String state;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="planner")
	private List<Event> eventsPlanned;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="author")
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "event_id")
			)
			private List<Event> eventsAttending;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public User() {

	}

	public User(String firstName, String lastName, String email, String password, String state,String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.state = state;
		this.city = city;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	 public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Event> getEventsPlanned() {
		return eventsPlanned;
	}

	public void setEventsPlanned(List<Event> eventsPlanned) {
		this.eventsPlanned = eventsPlanned;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Event> getEventsAttending() {
		return eventsAttending;
	}

	public void setEventsAttending(List<Event> eventsAttending) {
		this.eventsAttending = eventsAttending;
	}

	@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	 @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	
	
}
