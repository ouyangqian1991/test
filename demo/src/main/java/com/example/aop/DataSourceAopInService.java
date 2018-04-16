package com.example.aop;

import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.springframework.context.annotation.EnableAspectJAutoProxy;  
import org.springframework.core.PriorityOrdered;  
import org.springframework.stereotype.Component;  

import com.example.config.DataSourceContextHolder;
import com.example.config.DataSourceType;
  
  
/** 
 * 在service层觉得数据源 
 *  
 * 必须在事务AOP之前执行，所以实现Ordered,order的值越小，越先执行 
 * 如果一旦开始切换到写库，则之后的读都会走写库 
 *  
 * @author Jfei 
 * 
 */  
@Aspect  
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)  
@Component  
public class DataSourceAopInService implements PriorityOrdered{  
  
      
/*  @Before("execution(* com.fei.springboot.service..*.find*(..)) " 
            + " or execution(* com.fei.springboot.service..*.get*(..)) " 
            + " or execution(* com.fei.springboot.service..*.query*(..))") 
    public void setReadDataSourceType() { 
        //如果已经开启写事务了，那之后的所有读都从写库读 
        if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){ 
            DataSourceContextHolder.setRead(); 
        } 
         
    } 
 
    @Before("execution(* com.fei.springboot.service..*.insert*(..)) " 
            + " or execution(* com.fei.springboot.service..*.update*(..))" 
            + " or execution(* com.fei.springboot.service..*.add*(..))") 
    public void setWriteDataSourceType() { 
        DataSourceContextHolder.setWrite(); 
    }*/  
      
  
    @Before("execution(* com.example.service..*.find*(..))"
    		+ " or execution(* com.example.service..*.query*(..))"
    		+ " or execution(* com.example.service..*.select*(..))")  
    public void setReadDataSourceType() {  
        //如果已经开启写事务了，那之后的所有读都从写库读  
        if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){  
            DataSourceContextHolder.setRead();  
        }  
          
    }  
      
    @Before("execution(* com.example.service..*.insert*(..)) "  
            + " or execution(* com.example.service..*.update*(..))"
    		+ " or execution(* com.example.service..*.delete*(..))"
    		+ " or execution(* com.example.service..*.add*(..))")  
    public void setWriteDataSourceType() {  
        DataSourceContextHolder.setWrite();  
    }  
      
    @Override  
    public int getOrder() {  
        /** 
         * 值越小，越优先执行 
         * 要优于事务的执行 
         * 在启动类中加上了@EnableTransactionManagement(order = 10)  
         */  
        return 1;  
    }  
  
}  