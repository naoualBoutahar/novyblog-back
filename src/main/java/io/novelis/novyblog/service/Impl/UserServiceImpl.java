package io.novelis.novyblog.service.Impl;

import io.novelis.novyblog.dao.UserDao;
import io.novelis.novyblog.domain.User;
import io.novelis.novyblog.service.UserService;
import io.novelis.novyblog.service.dto.UserDTO;
import io.novelis.novyblog.service.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO save(User user) {
        return userMapper.userToUserDto(userDao.save(user));
    }

    @Override
    public UserDTO update(User user) {
        return userMapper.userToUserDto(userDao.save(user));
    }

    @Override
    public List<UserDTO> findAll() {
        return userDao
                .findAll()
                .stream()
                .map(userMapper::userToUserDto).collect(toList());
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
