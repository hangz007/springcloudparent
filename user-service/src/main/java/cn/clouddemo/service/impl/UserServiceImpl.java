package cn.clouddemo.service.impl;

import cn.clouddemo.dto.UserDto;
import cn.clouddemo.entity.User;
import cn.clouddemo.dao.UserDao;
import cn.clouddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shenzx on 2019/2/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<UserDto> findAll() {
        List<User> users = this.userDao.findAll();
        return users.stream().map((user) -> {
            return new UserDto(user);
        }).collect(Collectors.toList());
    }

    public UserDto load(Long id) {
        User user = this.userDao.findById(id).get();
        if (null == user)
            return null;

        return new UserDto(user);
    }

    public UserDto save(UserDto userDto) {
        User user = this.userDao.findById(userDto.getId()).get();
        if (null == user) {
            user = new User();
        }
        user.setNickname(userDto.getNickname());
        user.setAvatar(userDto.getAvatar());
        this.userDao.save(user);

        return new UserDto(user);
    }

    public void delete(Long id) {
        this.userDao.deleteById(id);
    }

}