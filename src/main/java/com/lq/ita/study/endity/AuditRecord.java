package com.lq.ita.study.endity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditRecord {
    private int id;
    private String operation;
    private String args;
    private String createTime;
}
