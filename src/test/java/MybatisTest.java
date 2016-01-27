import com.mvc.dal.StudentDao;
import com.mvc.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chen on 16-1-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MybatisTest {
    private static Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Resource
    private StudentDao studentDao;
    @Test
    public void test(){
        List<Student> list=studentDao.selectAll();
    }
}
