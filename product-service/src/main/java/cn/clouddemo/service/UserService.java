package cn.clouddemo.service;

import cn.clouddemo.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("USERSERVICE")
public interface UserService {

    @RequestMapping(value="/users",method = RequestMethod.GET)
    List<UserDto> findAll();

    @RequestMapping(value="/users/{id}",method = RequestMethod.GET)
    UserDto load(@PathVariable("id") Long id);

}
