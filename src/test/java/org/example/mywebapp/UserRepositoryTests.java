package org.example.mywebapp;

import org.assertj.core.api.Assertions;
import org.example.mywebapp.entity.Staff;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.repository.StaffRepository;
import org.example.mywebapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

// run tests against JPA repositories
@DataJpaTest
// run tests against a real database
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// rollback all transactions after each test
@Rollback(false)

public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;


    @Test
    public void findByUserName() {
        String username = "123123";
        User user = repo.findByUsername(username);
        Assertions.assertThat(user).isNotNull();
    }


}
