
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.myweibo.biz.SearchBiz;
import com.huwl.oracle.myweibo.biz.UserCenterBiz;
import com.huwl.oracle.myweibo.pojo.*;
import com.huwl.oracle.myweibo.wrapper.*;
import org.mybatis.caches.redis.RedisCache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.*;

/**
 * Created by aierxuan on 2017/7/18.
 */
public class TestCenter {

    public static void main(String[] args) throws JsonProcessingException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-*.xml");
        UserCenterBiz biz= (UserCenterBiz) ctx.getBean("userCenterBiz");
        ObjectMapper objectMapper=new ObjectMapper();
        User u=new User();
        u.setUserId(33);
        System.out.println(biz.like(u,10));

    }
}
