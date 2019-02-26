package cn.clouddemo.dao;

import cn.clouddemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shenzx on 2019/2/16.
 */
public interface UserDao extends JpaRepository<User, Long> {

}