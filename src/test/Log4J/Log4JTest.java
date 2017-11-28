package Log4J;

import org.apache.log4j.Logger;
import org.junit.Test;

/** 测试Log4j
 * Created by hk on 2017/11/28.
 */
public class Log4JTest {

    private Logger logger = Logger.getLogger(Log4JTest.class);

    @Test
    public void logsTest(){
        logger.fatal("致命错误");
        logger.error("普通错误");
        logger.warn("警告信息");
        logger.info("普通信息");
        logger.debug("调试信息");
        logger.trace("堆栈信息");
    }

}
