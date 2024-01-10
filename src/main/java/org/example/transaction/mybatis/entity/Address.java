package org.example.transaction.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.transaction.mybatis.entity.base.BaseEntity;

/**
 * @author zzl
 * @date 2024/1/9 11:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {
    private Integer personId;
    private String address;
}
