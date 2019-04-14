package cn.clouddemo.service;

import cn.clouddemo.dto.UserDto;
import cn.clouddemo.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceFallback implements UserService {

    @Override
    public List<UserDto> findAll() {
        return this.findAllFallback();
    }

    @Override
    public UserDto load(Long id) {
        return this.loadFallback(id);
    }

    protected List<UserDto> findAllFallback() {
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto(1L, "zhangSan_static", "/users/avatar/zhangsan.png"));
        userDtos.add(new UserDto(2L, "lisi_static", "/users/avatar/lisi.png"));
        userDtos.add(new UserDto(3L, "wangwu_static", "/users/avatar/wangwu.png"));
        userDtos.add(new UserDto(4L, "yanxiaoliu_static", "/users/avatar/yanxiaoliu.png"));
        return userDtos;
    }

    protected UserDto loadFallback(Long id) {
        return new UserDto(id, "Anonymous", "default.png");
    }
    
}
