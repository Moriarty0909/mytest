package com.ccssoft.model;

import lombok.Data;

@Data
public class Role extends BaseEntity{
    private static final long serialVersionUID = -3361087325748058119L;
    private String name;
    private String description;
}
