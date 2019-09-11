package com.ywyt.springboot3.mapper;

import com.ywyt.springboot3.entity.TestUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * @author xiejin
 * @date 2019/9/8 12:30
 */
public interface TestUserMapper {

    @Insert("insert into testuser(name,roleid) values(#{name},#{roleid})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(TestUser user);

}
