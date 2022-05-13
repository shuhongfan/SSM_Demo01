package com.itheima;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

    @Autowired
    private UserDao userDao;

    /**
     * 方式一：条件查询
     */
    @Test
    public void test1(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lt("age", 18);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);
    }

    /**
     * 方式二：lambda格式按条件查询
     */
    @Test
    public void test2(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().lt(User::getAge,10);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);
    }

    /**
     * 方式三： lambda格式按条件查询（推荐）
     */
    @Test
    public void test3(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.lt(User::getAge,10);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    /**
     * 10-30岁之间：(age < ? AND age > ?)
     */
    @Test
    public void test4(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.lt(User::getAge,30).gt(User::getAge,10);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    /**
     * (age < ? OR age > ?)
     */
    @Test
    public void test5(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.lt(User::getAge,30).or().gt(User::getAge,10);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    /**
     * 条件查询-----null值处理
     */
    @Test
    public void test6(){
//        模拟页面传递过来的查询数据
        UserQuery uq = new UserQuery();
//        uq.setAge(10);
        uq.setAge2(30);

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//        先判定第一个参数是否为true，如果为true连接当前条件
        lqw.lt(null!=uq.getAge2(),User::getAge,uq.getAge2())
            .gt(null!=uq.getAge(),User::getAge,uq.getAge());

        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    /**
     * 查询投影（lambda格式）
     * 查询结果中包含模型类中部分属性
     */
    @Test
    public void test7(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.select(User::getId,User::getName,User::getAge);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    /**
     * 查询投影
     * 查询结果中包含模型类中部分属性
     */
    @Test
    public void test8(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.select("id","name","age","tel");
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);
    }

    /**
     * 查询投影（查询结构包含模型类中为定义的属性，使用selectMaps方法）
     */
    @Test
    public void test9(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.select("count(*) as count,tel");
        qw.groupBy("tel");
        List<Map<String, Object>> mapList = userDao.selectMaps(qw);
        System.out.println(mapList);
    }


    /**
     * eq 相当于 =
     */
    @Test
    public void test10(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getName,"Tom").eq(User::getPassword,"tom");

        User loginUser = userDao.selectOne(lqw);
        System.out.println(loginUser);
    }

    @Test
    public void test11(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.between(User::getAge,10,30);

        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    /**
     * 模糊匹配 %
     */
    @Test
    public void test12(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.likeRight(User::getName,"J");

        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
    }

    @Test
    void testGetAll() {
        //方式一：按条件查询
//        QueryWrapper qw = new QueryWrapper();
//        qw.lt("age",18);
//        List<User> userList = userDao.selectList(qw);
//        System.out.println(userList);

        //方式二：lambda格式按条件查询
//        QueryWrapper<User> qw = new QueryWrapper<User>();
//        qw.lambda().lt(User::getAge, 10);
//        List<User> userList = userDao.selectList(qw);
//        System.out.println(userList);

        //方式三：lambda格式按条件查询
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.lt(User::getAge, 10);
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);




        //并且与或者关系
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //并且关系：10到30岁之间
//        //lqw.lt(User::getAge, 30).gt(User::getAge, 10);
//        //或者关系：小于10岁或者大于30岁
//        lqw.lt(User::getAge, 10).or().gt(User::getAge, 30);
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);




        //模拟页面传递过来的查询数据
//        UserQuery uq = new UserQuery();
//        uq.setAge(10);
//        uq.setAge2(30);

        //null判定
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.lt(User::getAge, uq.getAge2());
//        if( null != uq.getAge()) {
//            lqw.gt(User::getAge, uq.getAge());
//        }
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //先判定第一个参数是否为true，如果为true连接当前条件
////        lqw.lt(null != uq.getAge2(),User::getAge, uq.getAge2());
////        lqw.gt(null != uq.getAge(),User::getAge, uq.getAge());
//        lqw.lt(null != uq.getAge2(),User::getAge, uq.getAge2())
//           .gt(null != uq.getAge(),User::getAge, uq.getAge());
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);




        //查询投影
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        lqw.select(User::getId,User::getName,User::getAge);
//        QueryWrapper<User> lqw = new QueryWrapper<User>();
//        lqw.select("id","name","age","tel");
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

//        QueryWrapper<User> lqw = new QueryWrapper<User>();
//        lqw.select("count(*) as count, tel");
//        lqw.groupBy("tel");
//        List<Map<String, Object>> userList = userDao.selectMaps(lqw);
//        System.out.println(userList);




        //条件查询
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //等同于=
//        lqw.eq(User::getName,"Jerry").eq(User::getPassword,"jerry");
//        User loginUser = userDao.selectOne(lqw);
//        System.out.println(loginUser);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //范围查询 lt le gt ge eq between
//        lqw.between(User::getAge,10,30);
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);

//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
//        //模糊匹配 like
//        lqw.likeLeft(User::getName,"J");
//        List<User> userList = userDao.selectList(lqw);
//        System.out.println(userList);


        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);












    }

}
