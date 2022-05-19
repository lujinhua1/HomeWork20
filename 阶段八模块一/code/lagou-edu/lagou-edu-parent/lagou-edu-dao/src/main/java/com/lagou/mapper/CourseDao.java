package com.lagou.mapper;

import com.lagou.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseDao {
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
       * 查询某门课程的详细信息
       * @param courseid 课程编号 
       * @return
       */
    Course getCourseById(@Param("courseid") Integer courseid);
}
