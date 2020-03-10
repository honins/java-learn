import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTest {
    @Test
    public void test() {
        Logger log = LoggerFactory.getLogger(LogTest.class);
        log.warn("this is message {}", 1);
        Exception ex = new Exception("this is a message.");
        log.error("a new exeception", ex);
        log.trace("trace message.");
        log.info("info message.");
        for (int i = 0; i < 10; i++)
            log.debug("debug message:{}={}", "line", i);
    }
}