package com.projectX.AuthService.security;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.projectX.studioservices.model.appuser.AppUser;

@FeignClient(name="studio-server", url="localhost:9300")
public interface AppUserServiceProxy {
	
	@GetMapping("/jpa/user/username/{username}")
	public AppUser retrieveAppUser(@PathVariable("username") String username);
}
