
import com.huwl.oracle.myweibo.biz.SearchBiz;
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

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-*.xml");
        UserGroupMapper userGroupMapper= (UserGroupMapper) ctx.getBean("userGroupMapper");
        User loginedUser=new User();
        loginedUser.setUserId(33);
        User targetUser=new User();
        targetUser.setUserId(493);
        System.out.println(userGroupMapper.getGroupIdByBoth(loginedUser,targetUser));

    }
}
