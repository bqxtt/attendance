package com.baobei.attendance.web.controller;

import com.baobei.attendance.entity.Class;
import com.baobei.attendance.model.Result;
import com.baobei.attendance.model.search.ClassSearch;
import com.baobei.attendance.web.service.SchoolService;
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
@Api(tags = "学校信息管理")
@RestController
@RequestMapping("/web/school")
@CrossOrigin
public class SchoolController {
    @Autowired
    SchoolService schoolService;

//    @ApiOperation("增加学院")
//    @PostMapping("/department")
//    public ResponseEntity<Result> addDepartment(@RequestBody Department department) {
//        Result result = schoolService.addDepartment(department);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation("修改学院")
//    @PutMapping("/department/{departmentId}")
//    public ResponseEntity<Result> updateDepartment(@PathVariable Long departmentId, @RequestBody Department department) {
//        Result result = schoolService.updateDepartment(departmentId, department);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation("删除学院")
//    @DeleteMapping("/department/{departmentId}")
//    public ResponseEntity<Result> deleteDepartment(@PathVariable Long departmentId) {
//        Result result = schoolService.deleteDepartment(departmentId);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation("学院列表")
//    @PostMapping("/departments")
//    public ResponseEntity<Result> getDepartments(@RequestBody DepartmentSearch search) {
//        Result result = schoolService.getDepartments(search);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation("增加专业")
//    @PostMapping("/major")
//    public ResponseEntity<Result> addMajor(@RequestBody Major major) {
//        Result result = schoolService.addMajor(major);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation("修改专业")
//    @PutMapping("/major/{majorId}")
//    public ResponseEntity<Result> updateMajor(@PathVariable Long majorId, @RequestBody Major major) {
//        Result result = schoolService.updateMajor(majorId, major);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation("删除专业")
//    @DeleteMapping("/major/{majorId}")
//    public ResponseEntity<Result> deleteMajor(@PathVariable Long majorId) {
//        Result result = schoolService.deleteMajor(majorId);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }
//
//    @ApiOperation("专业列表")
//    @PostMapping("/majors")
//    public ResponseEntity<Result> getMajors(@RequestBody MajorSearch search) {
//        Result result = schoolService.getMajors(search);
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @ApiOperation("批量增加班级")
    @PostMapping("/classes")
    public ResponseEntity<Result> addClass(@RequestBody List<Class> classes) {
        Result result = schoolService.addClasses(classes);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("修改班级")
    @PutMapping("/class/{classId}")
    public ResponseEntity<Result> updateClass(@PathVariable Long classId, @RequestBody Class clazz) {
        Result result = schoolService.updateClass(classId, clazz);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("删除班级")
    @DeleteMapping("/class/{classId}")
    public ResponseEntity<Result> deleteClass(@PathVariable Long classId) {
        Result result = schoolService.deleteClass(classId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("班级列表")
    @PostMapping("/classes/list")
    public ResponseEntity<Result> getClasses(@RequestBody ClassSearch search) {
        Result result = schoolService.getClasses(search);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("所有")
    @GetMapping("/all")
    public ResponseEntity<Result> getAll() {
        Result result = schoolService.getSchoolAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("学生、辅导员、宿舍数量")
    @GetMapping("/count")
    public ResponseEntity<Result> getCount() {
        Result result = schoolService.getCount();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
