package com.lagou.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.course.CourseService;
import com.lagou.entity.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject:com.lagou.course.controller
 * @Author: JinHua
 * @CreateTime:2022/5/11
 * @Description:
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Reference
    private CourseService courseService;

    @RequestMapping("/getAllCourse")
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("/getCourseByUserId/{userid}")
    public List<Course> getCourseByUserId(@PathVariable("userid") String userId){
        List<Course> courses = courseService.getCourseByUserId(userId);
        return courses;
    }

    @GetMapping("/getCourseById/{courseid}")
    public Course getCourseById(@PathVariable("courseid")Integer courseid) {
        Course course = courseService.getCourseById(courseid);
        return course;
    }
}
