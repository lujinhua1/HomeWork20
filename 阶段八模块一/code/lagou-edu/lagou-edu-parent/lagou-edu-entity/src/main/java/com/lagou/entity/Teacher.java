package com.lagou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * 讲师表(Teacher)实体类
 *
 * @author JinHua
 * @since 2022-05-11 18:32:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Teacher implements Serializable {
    private static final long serialVersionUID = -43589489327017942L;
    /**
     * id
     */
    private Object id;
    /**
     * 课程ID
     */
    private Integer courseId;
    /**
     * 讲师姓名
     */
    private String teacherName;
    /**
     * 职务
     */
    private String position;
    /**
     * 讲师介绍
     */
    private String description;
    /**
     * 记录创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否删除
     */
    private Integer isDel;

}

