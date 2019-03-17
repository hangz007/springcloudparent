package cn.clouddemo.service;

import cn.clouddemo.dto.UserDto;
import cn.clouddemo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by shenzx on 2019/2/16.
 */
public interface UserService {

    public List<UserDto> findAll();

    public UserDto load(Long id);

    public UserDto save(UserDto userDto);

    public void delete(Long id);
}
