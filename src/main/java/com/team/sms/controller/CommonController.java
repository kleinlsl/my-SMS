package com.team.sms.controller;

import com.team.sms.bean.Admin;
import com.team.sms.bean.Student;
import com.team.sms.bean.Teacher;
import com.team.sms.service.AdminService;
import com.team.sms.service.StudentService;
import com.team.sms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @project: my-sms
 * @description: 控制器-管理个人信息管理页面
 * @author: dell
 * @date: 2020/5/14 - 16:47
 * @version: 1.0
 * @website:
 */
@Controller
@RequestMapping("/common")
public class CommonController {


    //注入业务对象
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    //存储预返回给页面的结果对象
    private Map<String, Object> result = new HashMap<>();

    @GetMapping("/goSettingView")
    public String getAdminList() {
        /**
         * @description: 跳转到个人信息管理页面
         * @param: []
         * @date: 2020/5/14 - 16:47
         * @return: java.lang.String
         */
        return "common/settings";
    }


    @PostMapping("/editPassword")
    @ResponseBody
    public Map<String, Object> editPassword(String oldPassword, String newPassword, HttpServletRequest request) {
        /**
         * @description: 修改密码
         * @param: [oldPassword, newPassword, request]
         * @date: 2020/5/14 - 16:48
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         */
        //判断当前登录用户的用户类型
        int userType = Integer.parseInt(request.getSession().getAttribute("userType").toString());
        //管理员身份
        if (userType == 1) {
            Admin admin = (Admin) request.getSession().getAttribute("userInfo");
            if (!admin.getPassword().equals(oldPassword)) {
                result.put("success", false);
                result.put("msg", "原密码错误!");
                return result;
            }
            try {
                //修改密码
                admin.setPassword(newPassword);//覆盖旧密码值,存储待更新的密码
                if (adminService.updatePassowrd(admin) > 0) {
                    result.put("success", true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success", false);
                result.put("msg", "修改失败! 服务器端发生异常!");
            }
        }

        //学生身份
        if (userType == 2) {
            Student student = (Student) request.getSession().getAttribute("userInfo");
            if (!student.getPassword().equals(oldPassword)) {
                result.put("success", false);
                result.put("msg", "原密码错误!");
                return result;
            }
            try {
                student.setPassword(newPassword);
                if (studentService.updatePassowrd(student) > 0) {
                    result.put("success", true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success", false);
                result.put("msg", "修改失败! 服务器端发生异常!");
            }
        }

        //教师身份
        if (userType == 3) {
            Teacher teacher = (Teacher) request.getSession().getAttribute("userInfo");
            if (!teacher.getPassword().equals(oldPassword)) {
                result.put("success", false);
                result.put("msg", "原密码错误!");
                return result;
            }
            try {
                teacher.setPassword(newPassword);
                if (teacherService.updatePassowrd(teacher) > 0) {
                    result.put("success", true);
                }
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success", false);
                result.put("msg", "修改失败! 服务器端发生异常!");
            }
        }

        return result;
    }

}
