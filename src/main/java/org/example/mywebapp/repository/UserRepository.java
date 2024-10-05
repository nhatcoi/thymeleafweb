package org.example.mywebapp.repository;

import org.example.mywebapp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM User u WHERE u.username = ?1")  // JPQL
    User findByUsername(String username);
}
