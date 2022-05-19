package com.lagou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @BelongsProject:com.lagou.entity
 * @Author: JinHua
 * @CreateTime:2022/5/17
 * @Description:
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {
    private Boolean success;
    private Integer state;
    private String message;
}
