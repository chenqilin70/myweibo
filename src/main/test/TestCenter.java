
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
        SearchBiz biz= (SearchBiz) ctx.getBean("searchBiz");
        User user=new User();
        user.setUserId(33);
        List list=biz.getGroupsByUser(user);
        for(Object o:list){
            System.out.print(o.getClass()+o.toString()+"\n");
        }
//        for(Object o:map.keySet()){
//            System.out.println(o+","+map.get(o));
//        }
    }
}
