package com.example.demo;


import java.util.Date;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
    @Autowired
    private H2Dao H2Service;
    @Autowired
    JdbcTemplate template;
    
    @Before
    public void insertData() {
    	template.update("insert into user(id,name,PHONE) values(?,?,?)", new Random().nextInt(100), "abc", ""+new Date());//insert data
    }
    
//    @Test
    public void testUpdateWhetherSqlInjection(){
    	//fail to injection, as see as a string
//    	template.update("insert into user(id,name,PHONE) values(?,?,?)", 123, "abc", "134);delete from user;");
    	
    	//fail to injection, as see as a string
//    	template.update("update user set phone='123' where name=?", "abc;delete from user;");
    	
    	//sucess to injection
//    	System.out.println(template.queryForList("select * from user where name='abc';delete from user;"));//this has deleted the data

    	//fail to inject
//    	System.out.println(template.queryForList("select * from user where name=?", "'abc';delete from user;"));//this return null, but data still there
    	
    }
    
    @Test
    public void testGetUserAll(){
        Iterable<User>userIterable=H2Service.findAll();
       for(User user:userIterable){
           System.out.println("查询到用户名为："+user.getName()+"的电话为："+user.getPhone());
       }
    }
//    @Test
//    public void getUserByPhone(){
//    String phone="123456";
//       List<User>userList= H2Service.findUserByPhone(phone);
//       Integer userNu=userList.size();
//        System.out.println("通过电话"+phone+"查询到"+userNu+"为用户");
//
//    }
//    @Test
//    public void delUserByPhone(){
//        String phone="123456";
//        List<User>userList= H2Service.findUserByPhone(phone);
//        H2Service.delete(userList.get(0));
//    }

}
