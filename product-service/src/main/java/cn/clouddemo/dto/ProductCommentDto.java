package cn.clouddemo.dto;

import cn.clouddemo.entity.Product;
import cn.clouddemo.entity.ProductComment;
import com.google.common.base.MoreObjects;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by shenzx on 2019/2/16.
 */
public class ProductCommentDto implements Serializable {

    private Long id;

    private Product product;

    private UserDto author;

    private String content;

    private Date created;

    public ProductCommentDto() {

    }

    public ProductCommentDto(ProductComment productComment) {
        this.id = productComment.getId();
        this.content = productComment.getContent();
        this.created = productComment.getCreated();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("productId", getProduct());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
