package cn.com.leadu.fms.common.util;

import java.util.UUID;

/**
 * Created by qiaohao on 2017/9/12.
 */
public class UUIDUtils {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }

}
