package Debug;
import org.apache.commons.logging.*;

public class Log4j{
    //定义的是static成员，以避免产生多个实例
    //LogFactory.getLog()方法的参数使用的是当前类的class，这是目前被普通认为的最好的方式。
    //为什么不写作LogFactory.getLog(this.getClass())？因为static类成员访问不到this指针！
    private static Log log = LogFactory.getLog(Log4j.class);
    public void test()

    {
        log.debug("111");
        log.info("222");
        log.warn("333");
        log.error("444");
        log.fatal("555");
    }
    public static void main(String[] args)
    {
        Log4j testLog = new Log4j();
        testLog.test();
    }
}
