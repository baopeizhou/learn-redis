package org.bob.learn.redis.common.util;

import java.util.UUID;

public class CommonUtils {

    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
