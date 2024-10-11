package org.example.mywebapp;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.example.mywebapp.entity.Staff;
import org.example.mywebapp.entity.User;
import org.example.mywebapp.repository.StaffRepository;
import org.example.mywebapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

// run tests against JPA repositories
@Slf4j
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
        String username = "123456";
        User user = repo.findByUsername(username);
        Assertions.assertThat(user).isNotNull();
    }

    @Test
    void hash() throws NoSuchAlgorithmException {
        String password = "jackie123";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte[] digest = md.digest();
        String md5Hash = DatatypeConverter.printHexBinary(digest);
        log.info("MD5 hash: {}", md5Hash);

        md.update(password.getBytes());
        byte[] digest2 = md.digest();
        String md5Hash2 = DatatypeConverter.printHexBinary(digest2);
        log.info("MD5 hash: {}", md5Hash2);


        PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder(10);
        log.info("BCrypt hash: {}", passwordEncoder.encode(password));
        log.info("BCrypt hash: {}", passwordEncoder.encode(password));
    }

}
