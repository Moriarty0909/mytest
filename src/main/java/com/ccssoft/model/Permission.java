package com.ccssoft.model;

import lombok.Data;

@Data
public class Permission extends BaseEntity{
    private static final long serialVersionUID = -2319610904490323594L;
    private Integer parentId;
    private String name;
    private String css;
    private String href;
    private Integer type;
    private String permission;
    private Integer sort;

    @Override
    public String toString() {
        return "Permission{" +
                "parentId=" + parentId +
                ", name='" + name + '\'' +
                ", css='" + css + '\'' +
                ", href='" + href + '\'' +
                ", type=" + type +
                ", permission='" + permission + '\'' +
                ", sort=" + sort +
                '}';
    }
}
