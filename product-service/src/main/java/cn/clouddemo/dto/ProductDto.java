package cn.clouddemo.dto;

import cn.clouddemo.entity.Product;
import com.google.common.base.MoreObjects;


import java.io.Serializable;

/**
 * Created by shenzx on 2019/2/16.
 */
public class ProductDto implements Serializable {

    private Long id;

    private String name;

    private String coverImage;

    private int price;

    public ProductDto() {

    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.coverImage = product.getCoverImage();
        this.price = product.getPrice();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
