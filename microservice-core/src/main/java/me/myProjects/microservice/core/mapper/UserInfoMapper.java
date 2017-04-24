package me.myProjects.microservice.core.mapper;

import me.myProjects.microservice.core.bean.orm.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * Created by chendong on 2017/4/24.
 * <p>
 * mybatis annotation mapper
 */
@Component  //component 其实是非必须的
@Mapper
public interface UserInfoMapper {

    @Insert("insert into user_info(name,email,phone,description) values(#{name},#{email},#{phone},#{description})")
    int insert(UserInfo userInfo);

    @SelectProvider(type = SqlBuilder.class, method = "getDeleteByIdsSql")
    int deleteById(@Param("id") String id);

    class SqlBuilder {
        public String getDeleteByIdsSql(@Param("id") String id) { // 这里的 @param 是必要的
            return "delete from user_info where id =" + id;
        }
    }

}
