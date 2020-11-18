import com.yuntu.dao.AddressMapper;
import com.yuntu.dao.ProviderMapper;
import com.yuntu.pojo.Address;
import com.yuntu.pojo.Provider;
import com.yuntu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class ProviderTest {
    Logger log = Logger.getLogger(ProviderTest.class);
    @Test
    public void getCountTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        int num = sqlSession.getMapper(ProviderMapper.class).getCount();
        MybatisUtil.closeSqlSession(sqlSession);
        log.debug("一共有"+num);
    }
    @Test
    public void getAllTest(){
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        List<Provider> providerList = sqlSession.getMapper(ProviderMapper.class).getAll();
        MybatisUtil.closeSqlSession(sqlSession);
        for (Provider p: providerList) {
            log.debug(p.getId()+"---------"+p.getProName());
        }
    }

}
