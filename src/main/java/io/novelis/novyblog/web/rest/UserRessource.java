package io.novelis.novyblog.web.rest;

import io.novelis.novyblog.domain.User;
import io.novelis.novyblog.exception.UserNotFoundException;
import io.novelis.novyblog.service.CommentService;
import io.novelis.novyblog.service.Impl.UserServiceImpl;
import io.novelis.novyblog.service.UserService;
import io.novelis.novyblog.service.dto.UserDTO;
import io.novelis.novyblog.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class UserRessource {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    UserDTO createUser(@RequestBody User user) {
        return userService.save(user);
    }

    // Single item
    @GetMapping("/users/{id}")
    User findUser(@PathVariable Long id) {
        return userService.findOne(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }


    @PutMapping("/users/{id}")
    UserDTO replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return userService.findOne(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userService.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userService.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.delete(id);

    }




}


