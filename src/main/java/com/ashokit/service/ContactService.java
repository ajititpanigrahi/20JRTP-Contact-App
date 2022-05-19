package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import com.ashokit.entity.Contact;

public interface ContactService {

	public String upsert (Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Optional<Contact> getContact(int cid);
	
	public String deleteContact(int cid);
	
}
