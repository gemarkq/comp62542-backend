package com.comp62542.backend.controller;


import com.comp62542.backend.entity.User;
import com.comp62542.backend.service.CourseService;
import com.comp62542.backend.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private HostHolder hostHolder;

    @GetMapping("/optcourses")
    public Map<String, Object> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/optcourses")
    public Map<String, Object> addOptCourses(String courseId) {
        User user = hostHolder.getUser();
        Map<String, Object> map = courseService.addOptCourses(user.getStudentID(), courseId);
        return map;
    }

}