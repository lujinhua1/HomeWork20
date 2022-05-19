package com.lagou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @BelongsProject:com.lagou.entity
 * @Author: JinHua
 * @CreateTime:2022/5/11
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVo<User> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int state;  // 操作状态
    private String message;  // 状态描述
    private User content;  // 响应内容
}
