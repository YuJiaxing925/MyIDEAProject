import com.yuntu.biz.UserBiz;
import com.yuntu.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserBiz biz  = (UserBiz)applicationContext.getBean("UserBizImpl");
        User user = new User() ;
        user.setName("你好");
        user.setPassword("123");

        try {
            biz.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
