//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.resumeims.resume_config.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import com.resumeims.resume_config.utils.StringUtil;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {
    public LoggerStartupListener() {
    }

    @Override
    public void start() {
//        Context context = this.getContext();
//        context.putProperty("ELK_MODE", "FALSE");
//        context.putProperty("STDOUT_APPENDER", "STDOUT");
//        context.putProperty("INFO_APPENDER", "INFO");
//        context.putProperty("ERROR_APPENDER", "ERROR");
//        context.putProperty("DESTINATION", "127.0.0.1:9982");
//        String destination = ElkPropsUtil.getDestination();
//        if (StringUtil.isNotBlank(destination)) {
//            context.putProperty("ELK_MODE", "TRUE");
//            context.putProperty("STDOUT_APPENDER", "STDOUT_LOGSTASH");
//            context.putProperty("INFO_APPENDER", "INFO_LOGSTASH");
//            context.putProperty("ERROR_APPENDER", "ERROR_LOGSTASH");
//            context.putProperty("DESTINATION", destination);
//        }
//
        Logger logger = (Logger) LoggerFactory.getLogger(LoggerStartupListener.class);
        logger.info("LogbackStartupListener start()");
        String userDir = System.getProperty("user.dir");
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String javaVersion = System.getProperty("java.version");
        String weblogicName = System.getProperty("weblogic.Name");

        System.out.println("userDir===" + userDir);
        System.out.println("osName===" + osName);
        System.out.println("osVersion===" + osVersion);
        System.out.println("javaVersion===" + javaVersion);
        System.out.println("weblogicName===" + weblogicName);


        if (StringUtils.isEmpty(weblogicName)) {
            weblogicName = "notWeblogic";
        }
        System.out.println("weblogicName2===" + weblogicName);

        Context context = getContext();
        context.putProperty("weblogicName", weblogicName);
    }

    public void stop() {
    }

    public boolean isStarted() {
        return false;
    }

    public boolean isResetResistant() {
        return false;
    }

    public void onStart(LoggerContext context) {
    }

    public void onReset(LoggerContext context) {
    }

    public void onStop(LoggerContext context) {
    }

    public void onLevelChange(Logger logger, Level level) {
    }
}
