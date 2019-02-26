package cn.clouddemo.service;

import cn.clouddemo.dto.UserDto;
import cn.clouddemo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shenzx on 2019/2/16.
 */
public interface UserService {

    /**
     * 获取用户分页数据
     * @param pageable 分页参数
     * @return 分页数据
     */
    Page<User> getPage(Pageable pageable);

    /**
     * 保存/更新用户
     * @param userDto
     * @return
     */
    User save(UserDto userDto);

    User load(Long id);

    /**
     * 删除指定用户
     * @param id 所要删除的用户主键
     */
    void delete(Long id);

}
