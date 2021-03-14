import com.hy.learn.spring.ioc.Beans;
import com.hy.learn.spring.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Created by hy
 * @date on 2021/2/23 14:50
 */
public class ApplicationContextTest {

    @Test
    public void getBean(){

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        User user = ctx.getBean(User.class);
        Assert.assertEquals(user.getId().intValue(), 1);

    }


}
