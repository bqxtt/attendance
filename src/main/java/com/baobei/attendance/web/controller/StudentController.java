package com.baobei.attendance.web.controller;

import com.baobei.attendance.entity.Student;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.StudentSearch;
import com.baobei.attendance.web.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Api(tags = "学生管理")
@RestController
@RequestMapping("/web")
public class StudentController {
    @Autowired
    StudentService studentService;

    @ApiOperation("批量添加学生")
    @PutMapping("/student")
    public ResponseEntity<Result> addStudents(@RequestBody List<Student> students) {
        Result result = studentService.batchSaveStudent(students);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("修改学生信息")
    @PostMapping("/student/{studentId}")
    public ResponseEntity<Result> updateStudent(@RequestBody Student student, @PathVariable Long studentId) {
        Result result = studentService.updateStudent(studentId, student);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("删除学生")
    @DeleteMapping("/students")
    public ResponseEntity<Result> deleteStudent(@RequestBody List<Long> studentIds) {
        Result result = studentService.batchDeleteStudents(studentIds);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("获取学生列表")
    @PostMapping("/students")
    public ResponseEntity<Result> getStudents(@RequestBody StudentSearch search) {
        Result result = studentService.getStudents(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
