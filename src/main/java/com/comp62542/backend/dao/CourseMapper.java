package com.comp62542.backend.dao;


import com.comp62542.backend.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select({
            "select id, courseId, courseName, type, time, department, teacher from courses"
    })
    @ResultType(Course.class)
    List<Course> selectAllCourse();


    @Insert({
            "insert into course_enrollment(courseId, studentId) values(#{courseId}, #{studentId}) "
    })
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertCourse(@Param("courseId")String courseId, @Param("studentId")String studentId);
}