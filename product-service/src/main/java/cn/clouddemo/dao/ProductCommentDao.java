package cn.clouddemo.dao;

import cn.clouddemo.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by shenzx on 2019/2/16.
 */
public interface ProductCommentDao extends JpaRepository<ProductComment,Long> {
    List<ProductComment> findByProductIdOrderByCreated(Long productId);
}
