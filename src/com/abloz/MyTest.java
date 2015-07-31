package com.abloz;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
 

public class MyTest {
	Logger log = Logger.getLogger(MyTest.class);
    private UserDao dao = new UserDao();
    
    @Test
    public void testGetOneUser() {
    	 User user = dao.getOneUser(1);
        log.debug ("getOneUser:"+user);
    }
    @Test
    public void testMyGetOneUser() {
    	 User user = dao.mygetOneUser(1);
         log.debug("mygetOneUser by notation:"+user);
    }
    
    @Test
    public void testAddUser() {
        User user = new User();
        user.setId(2);
        user.setName("andy");
        user.setCreated(new Date());
        user.setAge(20); 
        dao.addUser(user);
    }
 
    @Test
    public void testFindUserInteger() {
        User user = dao.findUser(1);
        log.debug("find user 1:"+user);
    }
 
    @Test
    public void testFindUser() {
        List<User> list = dao.findUser();
        for(User user : list){
            log.debug("find all user:"+user);
        }
    }
 
    @Test
    public void testUpdateUser() {
        User user = dao.findUser(2);
        log.debug("before change：："+user);
        user.setName("changed");
        dao.updateUser(user);
        user = dao.findUser(2);
        log.debug("after change：："+user);
    }
 
    @Test
    public void testDeleteUser() {
        User user = dao.findUser(2);
        log.debug(user);
        dao.deleteUser(2);
        user = dao.findUser(2);
        log.debug("after delete user id 2,get it return:"+user);
    }
 
}