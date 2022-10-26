package com.lq.ita.study.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import com.lq.ita.study.endity.AuditRecord;

@Mapper
@Repository
public interface AuditMapper {
    @Insert("insert into t_audit(operation,args) values(#{operation},#{args})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(AuditRecord auditRecord);
}
