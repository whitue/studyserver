package com.lq.ita.study.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.lq.ita.study.endity.Order;

@Mapper
@Repository
public interface OrderMapper {
    @Insert("insert into t_order${id % 4}(id,status,pay_type) values(#{id},#{status},#{payType})")
    @Results(value = {@Result(column = "pay_type", property = "payType"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime")})
    int insert(Order order);

    @Delete("delete from t_order${id % 4} where id=#{id}")
    int delete(Integer id);

    @Update("update t_order${id % 4} set status=#{status} where id=#{id}")
    int update(Order order);

    @Select("select id,status,pay_type,create_time,update_time from t_order${id % 4} where id=#{id}")
    @Results(value = {@Result(column = "pay_type", property = "payType"),
        @Result(column = "create_time", property = "createTime"),
        @Result(column = "update_time", property = "updateTime")})
    Order selectById(Integer id);
}
