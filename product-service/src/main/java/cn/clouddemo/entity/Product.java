package cn.clouddemo.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by shenzx on 2019/2/16.
 */
@Entity
@Table(name = "tbProduct")
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    /* 商品名称 */
    private String name;

    /* 商品封面图片 */
    private String coverImage;

    /* 商品价格(分) */
    private int price;

    @Override
    public  String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id",getId())
                .add("name",getName()).toString();
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
