import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//注解：可以标注再类、属性、方法、方法的参数等位置，
// 可以为当前的标注的内容去提供一写额外的数据
// 这些是可以再编码期间、编译期间、运行期间、程序可以动态的进行使用

//不经常改变的数据使用注解，进行携带经常发生的数据、使用xml进行携带

//滴定仪注解时，@ElementType和@RetentionPolicy两个必不可少
@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
