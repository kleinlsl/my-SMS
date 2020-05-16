package com.team.sms.controller;

import com.team.sms.bean.Admin;
import com.team.sms.bean.LoginForm;
import com.team.sms.bean.Student;
import com.team.sms.bean.Teacher;
import com.team.sms.service.AdminService;
import com.team.sms.service.StudentService;
import com.team.sms.service.TeacherService;
import com.team.sms.util.CreateVerifiCodeImage;
import com.team.sms.util.SessionSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @project: my-sms
 * @description: 控制器-管理系统登录与主页面
 * @author: dell
 * @date: 2020/5/14 - 16:36
 * @version: 1.0
 * @website:
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    //注入业务对象
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    //存储返回给页面的对象数据
    private Map<String, Object> result = new HashMap<>();

    @GetMapping("/goLogin")
    public String goLogin() {
        /**
         * @description: 跳转到用户登录页面
         * @param: []
         * @date: 2020/5/14 - 16:45
         * @return: java.lang.String
         */
        return "system/login";
    }

    @GetMapping("/getVerifiCodeImage")
    public void getVerifiCodeImage(HttpServletRequest request, HttpServletResponse response) {
        /**
         * @description: 获取并显示验证码图片
         * @param: [request, response]
         * @date: 2020/5/14 - 16:45
         * @return: void
         */

        // 验证码图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        // 验证码
        String verifiCode = String.valueOf(CreateVerifiCodeImage.getVerifiCode());
        // 将验证码图片输出到登录页面
        try {
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 存储验证码Session
        request.getSession().setAttribute("verifiCode", verifiCode);
    }

    @PostMapping("login")
    @ResponseBody
    public Map<String, Object> login(LoginForm loginForm, HttpServletRequest request) {
        /**
         * @description: 验证用户登录信息
         * @param: [loginForm, request]
         * @date: 2020/5/14 - 16:45
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         */
        // 校验验证码信息
        String vcode = (String) request.getSession().getAttribute("verifiCode");
        if ("".equals(vcode)) {
            result.put("success", false);
            result.put("msg", "长时间未操作,会话已失效,请刷新页面后重试!");
            return result;
        } else if (!loginForm.getVerifiCode().equalsIgnoreCase(vcode)) {
            result.put("success", false);
            result.put("msg", "验证码错误!");
            return result;
        }
        request.getSession().removeAttribute("verifiCode");

        //效验用户登录信息
        switch (loginForm.getUserType()) {
            //管理员身份
            case 1:
                try {
                    Admin admin = adminService.login(loginForm);//验证账户和密码是否存在
                    if (admin != null) {
                        HttpSession session = request.getSession(); //将用户信息存储到Session
                        session.setAttribute("userInfo", admin);
                        session.setAttribute("userType", loginForm.getUserType());
                        result.put("success", true);
                        SessionSave.saveLoginSessionId(admin.getName(),request.getRequestedSessionId());
                        return result;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    result.put("success", false);
                    result.put("msg", "登录失败! 服务器端发生异常!");
                    return result;
                }
                break;
            //学生身份
            case 2:
                try {
                    Student student = studentService.login(loginForm);
                    if (student != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("userInfo", student);
                        session.setAttribute("userType", loginForm.getUserType());
                        result.put("success", true);
                        SessionSave.saveLoginSessionId(student.getName(),request.getRequestedSessionId());
                        return result;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    result.put("success", false);
                    result.put("msg", "登录失败! 服务器端发生异常!");
                    return result;
                }
                break;
            //教师身份
            case 3:
                try {
                    Teacher teacher = teacherService.login(loginForm);
                    if (teacher != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("userInfo", teacher);
                        session.setAttribute("userType", loginForm.getUserType());
                        result.put("success", true);
                        SessionSave.saveLoginSessionId(teacher.getName(),request.getRequestedSessionId());
                        return result;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    result.put("success", false);
                    result.put("msg", "登录失败! 服务器端发生异常!");
                    return result;
                }
                break;
        }
        //登录失败
        result.put("success", false);
        result.put("msg", "用户名或密码错误!");
        return result;
    }

    @GetMapping("/goSystemMainView")
    public String goSystemMainView() {
        /**
         * @description: 跳转到系统主页面
         * @param: []
         * @date: 2020/5/14 - 16:46
         * @return: java.lang.String
         */
        return "system/main";
    }


    @GetMapping("/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) {
        /**
         * @description: 注销用户信息
         * @param: [request, response]
         * @date: 2020/5/14 - 16:46
         * @return: void
         */
        request.getSession().removeAttribute("userInfo");
        request.getSession().removeAttribute("userType");
        request.getSession().setAttribute("loginOut","用户已退出登录！");
        //注销后重定向到登录页面
        try {
            response.sendRedirect("../index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
