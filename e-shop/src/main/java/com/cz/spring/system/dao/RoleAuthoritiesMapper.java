package com.cz.spring.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cz.spring.system.model.RoleAuthorities;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoleAuthoritiesMapper extends BaseMapper<RoleAuthorities> {

    int insertRoleAuths(@Param("roleId") Integer roleId, @Param("authIds") List<Integer> authIds);

}
