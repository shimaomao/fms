package cn.com.leadu.fms.extend.aop.repository;

import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;

import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: AopRepositoryUtil
 * @Description:
 * @date 2018/2/24
 */
public class AopRepositoryUtil {

    public static void insert(Object object){
        if(object instanceof BaseEntity){
            BaseEntity entity = (BaseEntity) object;
            Date nowDate = new Date();
            entity.setCreateTime(nowDate);
            entity.setUpdateTime(nowDate);
            if(StringUtils.isNotTrimBlank(UserInfoUtils.getUserName()))
                entity.setCreator(UserInfoUtils.getUserName());
            if(StringUtils.isNotTrimBlank(UserInfoUtils.getUserName()))
                entity.setUpdater(UserInfoUtils.getUserName());
            if(entity.getDelFlag() == null)
                entity.setDelFlag(DeleteFlags.EXIST.getFlag());
        }
    }

    public static void update(Object object){
        if(object instanceof BaseEntity){
            BaseEntity entity = (BaseEntity) object;
            //保存最后一次更新时间 做排他处理
            entity.setUpdateLastTime(entity.getUpdateTime());
            Date nowDate = new Date();
            //放上本次更新时间
            entity.setUpdateTime(nowDate);
            if(StringUtils.isNotTrimBlank(UserInfoUtils.getUserName()))
                entity.setUpdater(UserInfoUtils.getUserName());
            if(entity.getDelFlag() == null)
                entity.setDelFlag(DeleteFlags.EXIST.getFlag());
        }
    }

    public static void delete(Object object){
        if(object instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) object;
            Date nowDate = new Date();
            entity.setUpdateTime(nowDate);
            if(StringUtils.isNotTrimBlank(UserInfoUtils.getUserName()))
                entity.setUpdater(UserInfoUtils.getUserName());
            entity.setDelFlag(DeleteFlags.NOT_EXIST.getFlag());
        }
    }

    public static void insertList(Object object){
        if(object instanceof List){
            List objectList = (List)object;
            for(Object element : objectList){
                if(element instanceof BaseEntity){
                    insert(element);
                }
            }
        }
    }

    public static void updateList(Object object){
        if(object instanceof List){
            List objectList = (List)object;
            for(Object element : objectList){
                if(element instanceof BaseEntity){
                    update(element);
                }
            }
        }
    }

}
