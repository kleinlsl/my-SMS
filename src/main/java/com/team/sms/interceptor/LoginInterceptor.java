package com.team.sms.interceptor;

import com.team.sms.bean.Admin;
import com.team.sms.bean.Student;
import com.team.sms.bean.Teacher;
import com.team.sms.util.SessionSave;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @project: sms
 * @description: 用户登录拦截器
 * @author: 黄宇辉
 * @date: 6/11/2019-5:15 PM
 * @version: 1.0
 * @website: https://yubuntu0109.github.io/
 */
public class LoginInterceptor implements HandlerInterceptor {

    //该方法会在控制器方法前执行,其返回值表示是否中断后续操作
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        HttpSession session=request.getSession();
        //判断用户是否已登录
        if (session.getAttribute("userInfo") != null) {
            Integer userType= (Integer) session.getAttribute("userType");
            String userName=null;
            switch (userType){
                case 1:  //管理员
                    Admin admin= (Admin) session.getAttribute("userInfo");
                    userName=admin.getName();
                    break;
                case 2://学生
                    Student student= (Student) session.getAttribute("userInfo");
                    userName=student.getName();
                    break;
                case 3://教师
                    Teacher teacher= (Teacher) session.getAttribute("userInfo");
                    userName=teacher.getName();
                    break;
            }
            if(userName!=null && SessionSave.isSessionIdAvailable(userName,session.getId())){
                return true;
            }
//            return true;
        }
        //用户未登录,拦击其请求并将其转发到用户登录页面
        request.getRequestDispatcher("/WEB-INF/view/system/login.jsp").forward(request, response);
        return false;
    }

    //该方法会在控制器方法调用之后,且解析视图之前调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //该方法会在整个请求完成,既视图渲染结束之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
