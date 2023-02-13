package io.novelis.novyblog.dao;

import io.novelis.novyblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
     List<User> findByFirstName(String firstName);
     List<User> findByLastName(String lastName);
}
