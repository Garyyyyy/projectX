package com.projectX.studioservices.model.appuser;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projectX.studioservices.exceptions.appuser.UserNotFoundException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
 

@RestController
public class AppUserJPAResource {
	
	
	@Autowired
	private IAppUserRepository appUserRepository;
	
	@GetMapping("/jpa/users")
	public List<AppUser> retrieveAllUsers() {
		return appUserRepository.findAll();
	}
	
	@GetMapping("/jpa/user/username/{username}")
	public AppUser retrieveUserByUsername(@PathVariable String username) throws UserNotFoundException{
		return appUserRepository.findByUsername(username);
	}
	
	@GetMapping("/jpa/user/{id}")
	public Resource<AppUser> retrieveUser(@PathVariable int id) throws UserNotFoundException{
		Optional<AppUser> user = appUserRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		
		 
		Resource<AppUser> resource = new Resource<AppUser>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
		
	}
	
	@DeleteMapping("/jpa/user/{id}")
	public void deleteUser(@PathVariable int id) {
		appUserRepository.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody AppUser user){
		
		AppUser savedUser = appUserRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
