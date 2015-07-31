package com.abloz;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
 
//http://mybatis.github.io/mybatis-3/zh/getting-started.html
public class UserDao  {
 

	//------新方式映射，利用xml的命名空间，其好处是可以编译时检查，IDE自动完成------------

	/*
	 * 采用notation方式获取用户
	 */
	public User mygetOneUser(Integer id) {
		SqlSession session = Util.openSession();
	
		try{
		
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.myselectOneUser(id);
			
			return user;
		}
		finally {
			session.close();
		}
		

	}
	
	/*
	 * 采用xml 映射方式
	 */
	public User getOneUser(Integer id) {
		SqlSession session = Util.openSession();
	
		try{
		
			UserMapper mapper = session.getMapper(UserMapper.class);
			User user = mapper.selectOneUser(id);
			
			return user;
		}
		finally {
			session.close();
		}
		

	}
	
	//----------------传统方式的映射，字符串方式----------------
	/**
     * 添加一个User
     */
    public void addUser(User user){
        //获取一个SqlSession对象
        SqlSession session = Util.openSession();
        //添加操作，用insert方法，第一个参数必须是mapping中唯一的id的值。
        session.insert("insertUser", user);
        //涉及insert、update、delete的DML，要手动的commit呢，注意close方法是不会监测有木有commit，幻想close方法去commit会让你死的很惨滴。
        session.commit();
        //session也是相当于缓冲池技术一样的，所以用完也要记得close哦。
        session.close();
    }
     
    
    /**
     * 根据id查找User，返回与id值匹配的User对象。
     */
    public User findUser(Integer id){
        SqlSession session = Util.openSession();
        User user = (User)session.selectOne("selectOneUser", id);
        session.commit();
        session.close();
        return user;
    }
     
    /**
     * 查找所有的User对象，以List的形式返回结果
     */
    public List<User> findUser(){
        SqlSession session = Util.openSession();
        List<User> list = session.selectList("selectAllUsers");
        session.commit();
        session.close();
        return list;
    }
     
    /**
     * 根据User对象的ID来更新User对象。
     */
    public void updateUser(User user){
        SqlSession session = Util.openSession();
        session.update("updateUser", user);
        session.commit();
        session.close();
    }
     
    /**
     * 根据id，删除与id值匹配的User对象
     */
    public void deleteUser(Integer id){
        SqlSession session = Util.openSession();
        session.delete("deleteUser", id);
        session.commit();
        session.close();
    }
}