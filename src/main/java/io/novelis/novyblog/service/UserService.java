package io.novelis.novyblog.service;

import io.novelis.novyblog.domain.User;
import java.util.List;
import java.util.Optional;

import io.novelis.novyblog.service.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDTO save(User user);
    UserDTO update(User user);
    List<UserDTO> findAll();
    Optional<User> findOne(Long id);
    void delete(Long id);
}
