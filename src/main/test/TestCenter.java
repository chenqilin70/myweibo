import com.huwl.oracle.myweibo.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by aierxuan on 2017/7/18.
 */
public class TestCenter {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-*.xml");
        final RedisTemplate<Serializable, Serializable> redisTemplate= (RedisTemplate<Serializable, Serializable>) ctx.getBean("redisTemplate");
        UserDao userDao= (UserDao) ctx.getBean("userDao");
        System.out.println(userDao.getUserByNicknameAndPwd("CHEN","123456"));
    }
}
