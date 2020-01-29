package com.ccssoft.dao;

import com.ccssoft.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
/**
 * 为了把mapper这个DAO交给Spring管理
 * 为了不再写mapper映射文件（xml）
 * 添加@Mapper注解的接口生成一个实现类
 */
public interface UserDao {
    //第一种方式，用注解的方式
    @Select("select * from T_User where username = #{username}")//$和#解析结果相同，预编译中的处理不一样，前者是字符串拼接后者是占位符
    User getUser (String username);

    @Insert("insert into T_User (username,password,nickname,sex,birthday,telephone,email,status,createtime) values (#{username},#{password},#{nickname},#{sex},#{birthday},#{telephone},#{email},#{status},now())")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int saveUser (User user);

    @Delete("delete from T_User where id = #{id}")
    int deleteUser (int id);

    @Select("select count(*) from T_User")
    Integer countAllUsers ();

    @Select("select * from T_User order by id limit #{startPosition},#{limit}")
    List<User> getAllUserByPage (@Param("startPosition") Integer startPosition,@Param("limit") Integer limit);
    //第二种方式，用xml
    int updateUser(User user);

    @Select("select id from T_User where username = #{username}")
    Integer selectIdByUsername(String username);

    @Select("select * from T_User where id = #{id}")
    User selectUserById(int id);
}
