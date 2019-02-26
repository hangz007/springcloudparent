package cn.clouddemo.controller;

import cn.clouddemo.dto.UserDto;
import cn.clouddemo.entity.User;
import cn.clouddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户管理Controller
 * Created by shenzx on 2019/2/16.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> findAll(Pageable pageable){
        Page<User> page = this.userService.getPage(pageable);
        if (null != page) {
            return page.getContent().stream().map((user) -> {
                return new UserDto(user);
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * 获取用户详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto detail(@PathVariable Long id){
        User user = this.userService.load(id);
        return (null != user) ? new UserDto(user) : null;
    }

    /**
     * 更新用户详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto){
        userDto.setId(id);
        User user = this.userService.save(userDto);
        return (null != user) ? new UserDto(user) : null;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id){
        this.userService.delete(id);
        return true;
    }

}
