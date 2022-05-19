package com.lagou.course.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.course.CourseService;
import com.lagou.entity.Course;
import com.lagou.mapper.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @BelongsProject:com.lagou.course.impl
 * @Author: JinHua
 * @CreateTime:2022/5/11
 * @Description:
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public List<Course> getCourseByUserId(String userId) {
        return courseDao.getCourseByUserId(userId);
    }

    @Override
    public Course getCourseById(Integer courseid) {
        return courseDao.getCourseById(courseid);
    }
}
