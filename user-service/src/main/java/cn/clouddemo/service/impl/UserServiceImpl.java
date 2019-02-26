package cn.clouddemo.service.impl;

import cn.clouddemo.dto.UserDto;
import cn.clouddemo.entity.User;
import cn.clouddemo.dao.UserDao;
import cn.clouddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by shenzx on 2019/2/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;

    @Override
    public Page<User> getPage(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User save(UserDto userDto) {
        User user = this.userRepository.findById(userDto.getId()).get();
        if(user == null) {
            user = new User();
        }
        user.setNickname(userDto.getNickname());
        user.setAvatar(userDto.getAvatar());
        return this.userRepository.save(user);
    }

    @Override
    public User load(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}