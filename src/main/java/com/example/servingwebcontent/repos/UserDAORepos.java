package com.example.servingwebcontent.repos;

import com.example.servingwebcontent.domain.UserDAO;
import org.springframework.data.repository.CrudRepository;


public interface UserDAORepos extends CrudRepository<UserDAO, Long> {

}
