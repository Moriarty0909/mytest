package com.ccssoft.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 7176551521865941952L;
    public int id;
    public Date createTime = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//通过json输出到前端的时候会格式化
    public Date updateTime = new Date();


}
