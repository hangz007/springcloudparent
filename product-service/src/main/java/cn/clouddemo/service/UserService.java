package cn.clouddemo.service;

import cn.clouddemo.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto load(Long id);

}
