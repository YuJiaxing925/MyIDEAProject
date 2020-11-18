import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Equip;
import pojo.Player;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Player player = (Player) applicationContext.getBean("zhangsan");
        Equip lanmo = (Equip) applicationContext.getBean("zhangsanRing");
        System.out.println(lanmo.toString());
        System.out.println(player.toString());
        player.updateEquip(lanmo);
        System.out.println(lanmo.toString());
    }
}
