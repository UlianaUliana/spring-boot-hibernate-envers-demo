package com.ns.springboothibernateenvers.service.listeners;

import com.ns.springboothibernateenvers.entity.User;
import jakarta.persistence.*;

public class UserListener {
	@PrePersist
	public void userPrePersist(User ob) {
		System.err.println("Listening User Pre Persist : " + ob.getFirstName() + " " + ob.getLastName());
	}
	@PostPersist
	public void userPostPersist(User ob) {
		System.err.println("Listening User Post Persist : " + ob.getFirstName() + " " + ob.getLastName());
	}
	@PostLoad
	public void userPostLoad(User ob) {
		System.err.println("Listening User Post Load : " + ob.getFirstName() + " " + ob.getLastName());
	}	
	@PreUpdate
	public void userPreUpdate(User ob) {
		System.err.println("Listening User Pre Update : " + ob.getFirstName() + " " + ob.getLastName());
	}
	@PostUpdate
	public void userPostUpdate(User ob) {
		System.err.println("Listening User Post Update : " + ob.getFirstName() + " " + ob.getLastName());
	}
	@PreRemove
	public void userPreRemove(User ob) {
		System.err.println("Listening User Pre Remove : " + ob.getFirstName() + " " + ob.getLastName());
	}
	@PostRemove
	public void userPostRemove(User ob) {
		System.err.println("Listening User Post Remove : " + ob.getFirstName() + " " + ob.getLastName());
	}

//	@PrePersist
//	@PreUpdate
//	@PreRemove
//	private void beforeAnyOperation(Object object) { ... }
}
