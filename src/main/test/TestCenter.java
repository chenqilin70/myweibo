
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public static void main(String[] args) throws JsonProcessingException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-*.xml");
        SearchBiz biz= (SearchBiz) ctx.getBean("searchBiz");
        ObjectMapper objectMapper=new ObjectMapper();
        List<Weibo> list=biz.searchWeiboByStr(1,"测试");
        System.out.println(objectMapper.writeValueAsString(list.get(0)));

    }
}
