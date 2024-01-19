package com.Demo.Spring_MVC_Security.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Demo.Spring_MVC_Security.Entity.User;

public interface UserRepository  extends CrudRepository<User, Long>{

}
