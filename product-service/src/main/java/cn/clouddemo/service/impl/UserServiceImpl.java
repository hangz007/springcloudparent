package cn.clouddemo.service.impl;

import cn.clouddemo.dto.UserDto;
import cn.clouddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Override
    public List<UserDto> findAll() {
        UserDto[] userDtos = this.restTemplate.getForObject(
                "http://USERSERVICE/users/", UserDto[].class);
        return Arrays.asList(userDtos);
    }

    @Override
    public UserDto load(Long id) {
        return this.restTemplate.getForEntity(
                "http://USERSERVICE/users/" + id,
                UserDto.class).getBody();
    }

}
