package com.lagou.course;

import com.lagou.entity.Course;

import java.util.List;

public interface CourseService {
    /**
     * 查询所有课程
     * @return
     */
    List<Course> getAllCourse();

    /**
     * 查询用户购买的课程
     * @param userId
     * @return
     */
    List<Course> getCourseByUserId(String userId);

    /**
     * 查询某一门课程的详情
     * @param courseid
     * @return
     */
    Course getCourseById(Integer courseid);
}
