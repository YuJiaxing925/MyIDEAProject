import com.yuntu.dao.PositionMapper;
import com.yuntu.pojo.Position;
import com.yuntu.pojo.Student;
import com.yuntu.pojo.Teacher;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class PositionTest {

    Logger log = Logger.getLogger(PositionTest.class);
    @Test
    public void oneToMore(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Position position = sqlSession.getMapper(PositionMapper.class).getTeacherByPositionId(1);
        MybatisUtil.closeSqlSession(sqlSession);
        log.debug(position.toString()+"\n");
        for (Teacher t:position.getTlist()) {
            log.debug("----------"+t.toString());
        }
    }

    @Test
    public void oneToMoretoMore(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Position position = sqlSession.getMapper(PositionMapper.class).selTeacherStudentByPositionId(1);
        MybatisUtil.closeSqlSession(sqlSession);
        log.debug(position.toString()+"\n");
        for (Teacher t:position.getTlist()) {
            log.debug("-----"+t.toString());
            for (Student s :t.getStudentList()){
                log.debug("=============="+s.toString());
            }
        }
    }
}
