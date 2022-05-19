package com.lagou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @BelongsProject:com.lagou.entity
 * @Author: JinHua
 * @CreateTime:2022/5/18
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetUser {
    private Integer userid;
    private String password;
}
