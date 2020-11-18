import com.yuntu.biz.UserBiz;
import com.yuntu.dao.UserMapper;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.jdbc.Sql;

public class test {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserBiz  userBiz=(UserBiz) applicationContext.getBean("userBiz");
        int num1 = userBiz.delUser(11);
        System.out.println(num1);
        int num = userBiz.count();

        System.out.println(num);
    }
}
