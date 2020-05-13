package com.cz.spring.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cz.spring.system.model.UserRole;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<UserRole> selectByUserIds(@Param("userIds") List<Integer> userIds);

    int insertBatch(@Param("userId") Integer userId, @Param("roleIds") List<Integer> roleIds);
}
