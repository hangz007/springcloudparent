package cn.clouddemo.dto;

import cn.clouddemo.entity.User;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Created by shenzx on 2019/2/16.
 */
public class UserDto implements Serializable {

    private Long id;

    private String nickname;

    private String avatar;

    public UserDto() {

    }

    public UserDto(User user) {
        this.id = user.getId();
        this.avatar = user.getAvatar();
        this.nickname = user.getNickname();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("nickname", getNickname());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
