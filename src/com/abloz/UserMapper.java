package com.abloz;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	
	public User selectOneUser(Integer id);
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	public User myselectOneUser(Integer id);
}
