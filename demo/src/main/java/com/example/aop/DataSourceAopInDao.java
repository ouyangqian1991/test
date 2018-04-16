/*package com.example.aop;

import org.aspectj.lang.annotation.Before;  

import com.example.config.DataSourceContextHolder;
  
  
*//** 
 * 在dao层决定数据源(注：如果用这方式，service层不能使用事务，否则出问题，因为打开事务打开时，就会觉得数据库源了） 
 * @author Jfei 
 * 
 *//*  
//@Aspect  
//@Component  
public class DataSourceAopInDao {  
  
      
    @Before("execution(* com.example.mapper..*.find*(..)) "  
            + " or execution(* com.example.mapper..*.get*(..)) "  
            + " or execution(* com.example.mapper..*.query*(..))")  
    public void setReadDataSourceType() {  
        DataSourceContextHolder.setRead();  
    }  
  
    @Before("execution(* com.example.mapper..*.insert*(..)) "  
            + " or execution(* com.example.mapper..*.update*(..))"  
            + " or execution(* com.example.mapper..*.add*(..))")  
    public void setWriteDataSourceType() {  
        DataSourceContextHolder.setWrite();  
    }  
      
      
    @Before("execution(* com.fei.springboot.dao..*.*(..)) " 
            + " and @annotation(com.fei.springboot.annotation.ReadDataSource) ") 
    public void setReadDataSourceType() { 
        //如果已经开启写事务了，那之后的所有读都从写库读 
        if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){ 
            DataSourceContextHolder.setRead(); 
        } 
         
    } 
     
    @Before("execution(* com.fei.springboot.dao..*.*(..)) " 
            + " and @annotation(com.fei.springboot.annotation.WriteDataSource) ") 
    public void setWriteDataSourceType() { 
        DataSourceContextHolder.setWrite(); 
    }  
}  */