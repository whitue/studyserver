package com.lq.ita.study.audit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lq.ita.study.endity.AuditRecord;
import com.lq.ita.study.mapper.AuditMapper;
import com.lq.ita.study.util.JsonUtil;

@Component
@Aspect
public class AuditAspect {
    @Autowired
    private AuditMapper auditMapper;

    @Pointcut("@annotation(com.lq.ita.study.audit.AuditOperation)")
    public void recordPoint() {

    }

    @AfterReturning(pointcut = "recordPoint()&&@annotation(auditOperation)")
    public void afterReturning(JoinPoint joinPoint, AuditOperation auditOperation) {
        AuditRecord auditRecord = AuditRecord.builder().operation(auditOperation.operation())
            .args(JsonUtil.toString(joinPoint.getArgs())).build();
        auditMapper.insert(auditRecord);
    }
}
