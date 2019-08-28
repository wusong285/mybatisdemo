package com.ws.demo.mapper;


import com.ws.demo.entity.TUser;

import java.util.List;

public interface TUserMapper {
	
	TUser selectByPrimaryKey(Integer id);
	
	List<TUser> selectAll();
    
}