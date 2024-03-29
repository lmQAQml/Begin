package com.app.mapper;

import com.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 返回要预加载到缓存的数据
 *
 * @return
 */
@Mapper
public interface UserCacheMapper {

    /**
     * USER表数据
     *
     * @return
     */
    List<UserEntity> initUserCacheList();


    List<UserEntity> findList(@Param("ids") List<Integer> ids);
}
