package com.fruitsalesplatform.db;

import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.dao.impl.UserDaoImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBConnectionTest{
    //MyBatis配置文件
    private String strResource = "beans.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession = null;

    @Test
    public void testDBConnection() throws Exception {
        //获取Spring类加载配置对象
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(strResource);
        sqlSessionFactory = (SqlSessionFactory)context.getBean("sessionFactory");
        sqlSession = sqlSessionFactory.openSession();
        if (sqlSession != null) {
            System.out.println("MyBatis-数据库连接成功!目前SQL配置数目");
            System.out.println(sqlSession.getConfiguration().getMappedStatements().size());
        } else {
            System.out.println("MyBatis-数据库连接失败!");
        }
    }

    @Test
    public void testDbUserInsert(){
        User user = new User();
        user.setUserName("jack");
        user.setPassword("1234");
        user.setName("张三");
        user.setTelephone("15558/5111554");
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        System.out.println(userDaoImpl.insertUser(user));
    }
}
