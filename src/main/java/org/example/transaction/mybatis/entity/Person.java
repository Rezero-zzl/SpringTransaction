package org.example.transaction.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.transaction.mybatis.entity.base.BaseEntity;

/**
 * @author zzl
 * @date 2024/1/8 15:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseEntity {
    private String name;
    private boolean sex;
}
