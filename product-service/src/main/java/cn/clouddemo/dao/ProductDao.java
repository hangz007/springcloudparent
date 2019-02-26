package cn.clouddemo.dao;

import cn.clouddemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shenzx on 2019/2/16.
 */
public interface ProductDao extends JpaRepository<Product,Long> {
}
