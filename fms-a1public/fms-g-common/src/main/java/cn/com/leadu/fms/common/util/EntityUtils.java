package cn.com.leadu.fms.common.util;

import cn.com.leadu.fms.common.entity.BaseUser;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EntityUtil
 * @Description: 实体类工具类
 * @date 2018/2/24
 */
public class EntityUtils {

    /**
     * @Title:
     * @Description:   创建一个实体并拷贝value进去
     * @param source
     * @param target
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/24 01:39:51
     */
    public static <T> T getEntity(Object source,T target){
        if(source != null)
            BeanUtils.copyProperties(source,target);
        return target;
    }

    public static List getEntitys(List sources,Class target){
        List list = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(sources)){
            for(Object source : sources){
                try {
                    Object tmpTarget = target.newInstance();
                    BeanUtils.copyProperties(source,tmpTarget);
                    list.add(tmpTarget);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }


}
