import com.yuntu.dao.UserMapper;
import com.yuntu.pojo.Address;
import com.yuntu.pojo.User;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {
    Logger log = Logger.getLogger(UserTest.class);
    @Test
    public void getCountTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(UserMapper.class).getCount();
        MybatisUtil.closeSqlSession(sqlSession);
        log.debug("一共有"+num);
    }
    @Test
    public void getAllTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<User> userList = sqlSession.getMapper(UserMapper.class).getAll();
        MybatisUtil.closeSqlSession(sqlSession);
        for (User u: userList) {
            log.debug(u.getId()+"----"+u.getUserName()+"------"+u.getRole().getRoleName()+"----"+u.getRole().getId());
        }
    }
    @Test
    public void getAll2Test(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<User> userList = sqlSession.getMapper(UserMapper.class).getAll2();
        MybatisUtil.closeSqlSession(sqlSession);
        for (User u: userList) {
            log.debug(u.getId()+"用户名："+u.getUserName()+"密码："+u.getUserPassword());
            for (Address add:u.getAdd()){
                log.debug("========收货人"+add.getContact()+"电话"+add.getTel());
            }
        }
    }
    @Test
    public void delUserTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(UserMapper.class).delUser(19);
        if (num!=0){
            log.debug("!!!!!!!!!!!!!!!!!删除成功");
            sqlSession.commit();
        }else{
            log.debug("!!!!!!!!!!!!!!!!!删除失败");
        }
        MybatisUtil.closeSqlSession(sqlSession);
    }
    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        User u = new User("你好","123","123",1,new Date(),"123","123",1,1,new Date(),1,new Date());
        int num = sqlSession.getMapper(UserMapper.class).addUser(u);
        if (num!=0){
            log.debug("!!!!!!!!!!!!!!!!!添加成功");
            sqlSession.commit();
        }else{
            log.debug("!!!!!!!!!!!!!!!!!添加失败");
        }
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
    }
    @Test
    public void updUserTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        User u = new User(20,"你好1111","123","123",1,new Date(),"123","123",1,1,new Date());
        int num = sqlSession.getMapper(UserMapper.class).updUser(u);
        if (num!=0){
            log.debug("!!!!!!!!!!!!!!!!!xiugai成功");
            sqlSession.commit();
        }else{
            log.debug("!!!!!!!!!!!!!!!!xiugai失败");
        }
        sqlSession.commit();
        MybatisUtil.closeSqlSession(sqlSession);
    }
    @Test
    public void getLikeTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<User> userList = sqlSession.getMapper(UserMapper.class).getLike("136");
        MybatisUtil.closeSqlSession(sqlSession);
        for (User u: userList) {
            log.debug(u.getId()+"----"+u.getPhone());
        }
    }
    @Test
    public void getLikeTest2(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        User u1  = new User();
        u1.setGender(1);
        u1.setPhone("136");
        List<User> userList = sqlSession.getMapper(UserMapper.class).getLike2(u1);
        MybatisUtil.closeSqlSession(sqlSession);
        for (User u: userList) {
            log.debug(u.getId()+"----"+u.getPhone());
        }
    }
    @Test
    public void getLikeTest3(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("p","136");
        map.put("g",1);
        List<User> userList = sqlSession.getMapper(UserMapper.class).getLike3(map);
        MybatisUtil.closeSqlSession(sqlSession);
        for (User u: userList) {
            log.debug(u.getId()+"----"+u.getPhone());
        }
    }
    @Test
    public void getLikeTest4(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<User> userList = sqlSession.getMapper(UserMapper.class).getLike4("136",2);
        MybatisUtil.closeSqlSession(sqlSession);
        for (User u: userList) {
            log.debug(u.getId()+"----"+u.getPhone());
        }
    }
}
