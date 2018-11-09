package cn.com.leadu.fms.common.vo;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: BaseVo
 * @Description:
 * @date 2018/2/5
 */
@Slf4j
@Data
public abstract class BaseVo<T> implements Vo,Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmssSSS)
    protected Date createTime;

    protected String creator;

    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmssSSS)
    protected Date updateTime;

    protected String updater;

    @JsonIgnore
    protected Integer delFlag;

    @JsonIgnore
    @JSONField(serialize = false)
    public T getEntity(){
        try{
            Class clazz = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return EntityUtils.getEntity(this,(T)clazz.newInstance());
        }catch (IllegalAccessException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }catch (InstantiationException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @Fields  : 用于保存上一次数据库的更新时间,在更新时做排他处理
     * @author qiaomengnan
     */
    @JsonIgnore
    protected Date updateLastTime;

}
