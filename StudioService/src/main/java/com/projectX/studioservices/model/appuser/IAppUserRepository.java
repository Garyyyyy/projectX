package com.projectX.studioservices.model.appuser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
	
	@Query("SELECT p FROM AppUser p WHERE LOWER(p.username) = LOWER(:username)")
	public AppUser findByUsername(@Param("username") String username);
}
