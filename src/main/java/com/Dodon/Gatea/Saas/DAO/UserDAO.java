package com.Dodon.Gatea.Saas.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Dodon.Gatea.Saas.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
	UserDAO findByUsername(String username);
}