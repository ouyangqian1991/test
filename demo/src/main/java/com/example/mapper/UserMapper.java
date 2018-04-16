package com.example.mapper;
import java.util.List;  

import org.apache.ibatis.annotations.Param;  
import org.apache.ibatis.annotations.Select;  

import com.example.pojo.User;
import com.github.abel533.mapper.Mapper;
  

  
public interface UserMapper extends Mapper<User>{  
  
      
    @Select("select id,user_name from sys_user where id=#{id} ")  
    User findById(@Param("id")String id);  
      
    //注：方法名和要UserMapper.xml中的id一致  
    @Select("select id,user_name from sys_user where user_name=#{userName} ")  
    List<User> query(@Param("userName")String userName);
   //@Select("select level from sys_user where id=#{id} ")  
    Integer selectUserLevel(String id);
}  