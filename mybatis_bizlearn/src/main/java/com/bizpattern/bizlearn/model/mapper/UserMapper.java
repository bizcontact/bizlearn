package com.bizpattern.bizlearn.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bizpattern.bizlearn.model.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM bizuser WHERE id = #{id}")
	User getUser(@Param("id") Long id);

	@Select("SELECT * FROM bizuser")
	List<User> getAllUsers();

	@Insert("INSERT into bizuser (name, address) values (#{user.name}, #{user.address})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void addUser(@Param("user") User user);

}
