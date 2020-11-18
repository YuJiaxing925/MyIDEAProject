import com.yuntu.pojo.HelloSpring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
        HelloSpring helloSpring1 = (HelloSpring) applicationContext.getBean("helloSpring1");
        helloSpring.print();
        helloSpring1.print();
    }
}
