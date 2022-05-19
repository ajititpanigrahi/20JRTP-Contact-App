package com.ashokit.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Contact;
import com.ashokit.service.ContactService;

@RestController
public class ContactRestController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody Contact contact){
		String upsert = contactService.upsert(contact);
		return new ResponseEntity<>(upsert, HttpStatus.CREATED);
	}
	
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts(){
		List<Contact> allContacts = contactService.getAllContacts();
		return new ResponseEntity<>(allContacts,HttpStatus.FOUND);
		
	}

	@GetMapping("/contact/{cid}")
	public ResponseEntity<Optional<Contact>> getContact(@PathVariable int cid){
		
		Optional<Contact> contact = contactService.getContact(cid);
		return new ResponseEntity<>(contact, HttpStatus.FOUND);
	}

	@DeleteMapping("/contact/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable int cid){
		
		String deleteContact = contactService.deleteContact(cid);
		return new ResponseEntity<>(deleteContact, HttpStatus.OK);
		
	}

}
