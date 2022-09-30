package com.mitocode.repository;

import com.mitocode.model.User;

public interface IUserRepository extends IGenericRepository<User, Integer>  {

	//from user where username = ?
	//Derived Query
	User findOneByUsername(String username);

}
