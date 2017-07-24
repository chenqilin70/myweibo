
import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.*;

/**
 * Created by aierxuan on 2017/7/18.
 */
public class TestCenter {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-*.xml");
        /*final RedisTemplate<Serializable, Serializable> redisTemplate= (RedisTemplate<Serializable, Serializable>) ctx.getBean("redisTemplate");
        UserDao userDao= (UserDao) ctx.getBean("userDao");
        System.out.println(userDao.getUserByNicknameAndPwd("CHEN","123456"));
        System.out.println("");*/
        /*WeiboDao weiboDao= (WeiboDao) ctx.getBean("weiboDao");
        List<Weibo> list=
                weiboDao.getUserWeiboList(new PageBean(10,1,0),33);
        System.out.println(list);*/
    }
}
