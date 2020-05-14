package com.team.SMS.dao;

import com.team.SMS.bean.Admin;
import com.team.SMS.bean.LoginForm;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @project: my-SMS
 * @description:
 * @author: dell
 * @date: 2020/5/11 - 20:50
 * @version: 1.0
 * @website:
 */
public class AdminMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private AdminMapper adminMapper;
    @Before
    public void init() {
        // 读取mybatis配置文件
        String resource = "mybatis-conf/mybatis-config.xml";
        InputStream inputStream;
        try {
            // 得到配置文件流
            inputStream = Resources.getResourceAsStream(resource);
            // 根据配置文件信息，创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // 获得Mapper接口的代理对象
            adminMapper= sqlSession.getMapper(AdminMapper.class);
        }
    }

    /**
     * @description: 验证登录信息是否正确
     * @param:
     * @date: 2020/5/11 - 20:23
     * @return:
     */
    @Test
    public void login(){

        // 直接调用接口的方法，查询编号为1的UserInfo对象
        LoginForm loginForm=new LoginForm();
        loginForm.setUsername("root");
        loginForm.setPassword("root");
        Admin admin = adminMapper.login(loginForm);
        if (admin!=null)
        {
            // 打印输出结果
            System.out.println("success");
            System.out.println(admin.toString());
        }
        else {
            System.out.println("未找到");
        }
    }

    /**
     * @description: 通过姓名查询指定管理员信息
     * @param:
     * @date: 2020/5/11 - 20:23
     * @return:
     */
    @Test
    public void findByName() {
        // 直接调用接口的方法，查询编号为1的UserInfo对象
        Admin admin = adminMapper.findByName("root");
        if (admin!=null)
        {
            // 打印输出结果
            System.out.println(admin.toString());
        }
        else {
            System.out.println("未找到");
        }
    }


    /**
     * @description: 添加管理员信息
     * @param:
     * @date: 2020/5/11 - 20:24
     * @return:
     */
//    int insert(Admin admin);
    @Test
    public void insert(){
        //创建管理员对象
        Admin admin =new Admin();
        admin.setName("klein");
        admin.setPassword("klein");
        admin.setGender('男');
        admin.setEmail("2445859460@qq.com");
        admin.setTelephone("15036455256");
        admin.setAddress("洛阳市");


        //添加管理员
        int res=adminMapper.insert(admin);
        if (res>0){
            System.out.println("inster is success!");
        }
        else {
            System.out.println("insert is fail");
        }

    }

    /**
     * @description: 根据姓名模糊查询指定|所有管理员信息 列表
     * @param:
     * @date: 2020/5/11 - 20:25
     * @return:
     */
//    List<Admin> selectList(Admin admin);
    @Test
    public void selectList(){
        //创建管理员对象
        Admin admin =new Admin();
        admin.setName("k");
        List<Admin> adminList=adminMapper.selectList(admin);
        if (adminList!=null){
            for (Admin admin1:adminList){
                System.out.println(admin1);
            }
        }

    }

    /**
     * @description: 根据id更新指定管理员信息列表
     * @param:
     * @date: 2020/5/11 - 20:26
     * @return:
     */
//    int update(Admin admin);
    @Test
    public void update(){
        //创建管理员对象
        Admin admin =new Admin();
        admin.setId(156);
        admin.setGender('男');
        admin.setEmail("2445859460@qq.com");
        admin.setTelephone("132456789562");
        admin.setAddress("洛阳市");
        System.out.println(admin);

        int res=adminMapper.update(admin);
        if (res>0){
            System.out.println("update is success!");
        }
        else {
            System.out.println("update is fail!");
        }
    }

//    /**
//     * @description: 根据id修改指定管理员密码
//     * @param:
//     * @date: 2020/5/11 - 20:27
//     * @return:
//     */
//    int updatePassword(Admin admin);
    @Test
    public void updatePassword(){
        //创建管理员对象
        Admin admin =new Admin();
        admin.setId(156);
        admin.setPassword("031516");

        System.out.println(admin);

        //通过代理对象，调用接口
        int res=adminMapper.updatePassword(admin);
        if (res>0){
            System.out.println("updatePassword is success!");
        }
        else {
            System.out.println("updatePassword is faile!");
        }
    }

//    /**
//     * @description:  根据id删除指定管理员信息
//     * @param:
//     * @date: 2020/5/11 - 20:29
//     * @return:
//     */
//    int deleteById(Integer[] ids);
    @Test
    public void deleteById(){
        //创建要删除的id列表
        Integer ids[]={156,157};
        int res=adminMapper.deleteById(ids);
        if (res>0){
            System.out.println("deleteById is success!");
        }
        else {
            System.out.println("deleteById is faile!");
        }
    }

    @After
    public void destroy() {
        // 提交事务
        sqlSession.commit();
        // 关闭sqlSession
        sqlSession.close();
    }




}