import com.ws.demo.entity.TUser;
import com.ws.demo.mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserServiceTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        //加载mybatis-config.xml文件的配置
        String sources = "mybatis-config.xml";
        //用mybatis来创建一个配置文件的数据流
        InputStream inputStream  = Resources.getResourceAsStream(sources);
        //使用 SqlSessionFactoryBuilder的build方法 创建 sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void selectUser(){
        //1.从工厂里拿出sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.用sqlSession通过动态代理 生成TUserMapper
        TUserMapper userMapper = sqlSession.getMapper(TUserMapper.class);
        //3.使用TUserMapper来执行查询
        TUser user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
