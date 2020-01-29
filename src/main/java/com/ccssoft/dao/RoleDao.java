package com.ccssoft.dao;

import com.ccssoft.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleDao {
    @Select("select * from T_Role")
    List<Role> getAllRoles();
}
