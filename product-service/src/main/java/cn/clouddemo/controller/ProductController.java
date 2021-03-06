package cn.clouddemo.controller;

import cn.clouddemo.dao.ProductCommentDao;
import cn.clouddemo.dao.ProductDao;
import cn.clouddemo.dto.ProductCommentDto;
import cn.clouddemo.entity.Product;
import cn.clouddemo.entity.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import cn.clouddemo.service.UserService;

import java.util.List;

/**
 * 商品管理的Endpoint
 *
 * @author CD826
 * @since 1.0.0
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    protected Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductCommentDao productCommentDao;

//    @Autowired
//    @Qualifier(value = "restTemplate")
//    private RestTemplate restTemplate;

    private UserService userService;


    /**
     * 获取商品列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {
        return this.productDao.findAll();
    }

    /**
     * 获取指定商品的详情
     * @param id 商品的Id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product detail(@PathVariable Long id){
        return this.productDao.findById(id).get();
    }

    /**
     * 获取指定商品的评论列表
     * @param id 商品的Id
     * @return
     */
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<ProductCommentDto> comments(@PathVariable Long id){
        List<ProductComment> commentList = this.productCommentDao.findByProductIdOrderByCreated(id);
        if (null == commentList || commentList.isEmpty())
            return Collections.emptyList();

        return commentList.stream().map((comment) -> {
            ProductCommentDto dto = new ProductCommentDto(comment);
            dto.setProduct(this.productDao.findById(comment.getProductId()).get());
            dto.setAuthor(this.userService.load(comment.getAuthorId()));
            return dto;
        }).collect(Collectors.toList());
    }

}
