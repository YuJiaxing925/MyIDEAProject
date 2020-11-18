import com.yuntu.dao.EmployeeMapper;
import com.yuntu.pojo.Employee;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class test {
    Logger log = Logger.getLogger(test.class);

    @org.junit.Test
    public void oneToone(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Employee> all = sqlSession.getMapper(EmployeeMapper.class).getEmployees();
        MybatisUtil.closeSqlSession(sqlSession);
        for (Employee t : all) {
            log.debug(t.toString());
        }
    }
}
