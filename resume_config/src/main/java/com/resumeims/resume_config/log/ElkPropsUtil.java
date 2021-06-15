//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.resumeims.resume_config.log;

import java.util.Properties;

public class ElkPropsUtil {
    public ElkPropsUtil() {
    }

    public static String getDestination() {
        Properties props = System.getProperties();
        return props.getProperty("blade.log.elk.destination", "");
    }
}
