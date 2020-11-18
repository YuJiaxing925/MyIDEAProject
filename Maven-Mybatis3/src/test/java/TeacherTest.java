import com.yuntu.dao.TeacherMapper;
import com.yuntu.pojo.Teacher;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class TeacherTest {
    Logger log = Logger.getLogger(TeacherTest.class);

    @org.junit.Test
    public void oneToone(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Teacher> all = sqlSession.getMapper(TeacherMapper.class).getTeacherPositionById();
        MybatisUtil.closeSqlSession(sqlSession);
        for (Teacher t : all) {
            log.debug(t.getId()+"-"+t.getT_no()+"-"+t.getT_name()+"-"+t.getPosition_id()+"="+t.getP().getId()+"-"+t.getP().getT_pos_name());
        }
    }


    @Test
    public void getAll(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Teacher> teacherList = sqlSession.getMapper(TeacherMapper.class).getAll("",1);
        MybatisUtil.closeSqlSession(sqlSession);

        for (Teacher t :
             teacherList) {
            log.debug("----"+t.toString());
        }
    }
    @Test
    public void updTeacher1(){
        SqlSession sql = MybatisUtil.createSqlSession();
        Teacher teacher = new Teacher(1,"2222","",3);
        int num = sql.getMapper(TeacherMapper.class).updTeacher1(teacher);
        if(num!=0){
            log.debug("修改成功");
        }else{
            log.debug("修改失败");
        }
        sql.commit();
        MybatisUtil.closeSqlSession(sql);
    }
}
