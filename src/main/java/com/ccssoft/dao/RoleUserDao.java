package com.ccssoft.dao;

import com.ccssoft.model.RoleUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleUserDao {
    @Insert("insert into T_Role_User (userId ,roleId) value (#{userId},#{roleId})")
    void saveToDB(RoleUser roleUser);
}
