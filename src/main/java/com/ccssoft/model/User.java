package com.ccssoft.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = true)//完全的继承父类
public class User extends BaseEntity {
    private static final long serialVersionUID = 7612125837598801750L;
    private String username;
    private String password;
    private String nickname;
    private String telephone;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;
    private Integer status;
    private String intro;

    public interface Status {
        int DISABLED = 0;
        int VALID =1;
        int LOCKED = 2;

    }
}
