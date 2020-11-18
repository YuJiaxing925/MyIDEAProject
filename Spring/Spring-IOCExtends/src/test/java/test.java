import com.yuntu.biz.UserBiz;
import com.yuntu.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserBiz userBiz =(UserBiz) applicationContext.getBean("UserBiz");
        User user =(User) applicationContext.getBean("user1");
        User u = userBiz.login(new User("aaa","123"));
        System.out.println(u.getUserName()+"-----"+u.getPassword());
        System.out.println(user.toString());
    }
}
