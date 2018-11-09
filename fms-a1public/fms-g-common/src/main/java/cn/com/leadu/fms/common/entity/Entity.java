package cn.com.leadu.fms.common.entity;

import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: Entity
 * @Description: entity接口基类
 * @date 2018/1/7
 */
public interface Entity {

    String getCreator();

    String getUpdater();

    Date getUpdateTime();

    Date getUpdateLastTime();

    Date getCreateTime();

    Integer getDelFlag();

}
