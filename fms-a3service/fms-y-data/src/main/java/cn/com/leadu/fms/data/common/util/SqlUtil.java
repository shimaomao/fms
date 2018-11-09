package cn.com.leadu.fms.data.common.util;

import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SqlUtil
 * @Description: sql工具类
 * @date 2018/2/2
 */
public class SqlUtil {

    public static final String SQL_CREATE_TIME = " create_time ";

    public static final String SQL_ASC = " asc ";

    public static final String SQL_DESC = " desc ";

    public static final String ENTITY_DEL_FLAG = "delFlag";

    public static final String TABLE_DEL_FLAG = "del_flag";

    public static final String SQL_UPDATE_TIME = " update_time ";

    public static final String ENTITY_UPDATE_TIME = "updateTime";

    public static String createTimeAsc(){
        return SQL_CREATE_TIME + SQL_ASC;
    }
    
    public static String columnAsc(String column){
        return column + SQL_ASC;
    }

    public static String createTimeDesc(){
        return SQL_CREATE_TIME + SQL_DESC;
    }
    
    public static String columnDesc(String column){
        return column + SQL_DESC;
    }

    public static String updateTimeAsc() {return SQL_UPDATE_TIME + SQL_ASC; }

    public static String updateTimeDesc() {return SQL_UPDATE_TIME + SQL_DESC; }

    public static void setOrderByCreateTimeAsc(Example example){
        if(example != null)
            example.setOrderByClause(createTimeAsc());

    }

    public static void setOrderByCreateTimeDesc(Example example){
        if(example != null)
            example.setOrderByClause(createTimeDesc());

    }

    public static void setOrderByUpdateTimeAsc(Example example){
        if(example != null)
            example.setOrderByClause(updateTimeAsc());
    }

    public static void setOrderByUpdateTimeDesc(Example example){
        if(example != null)
            example.setOrderByClause(updateTimeDesc());
    }

    public static void andEqualToDeleteExist(Example.Criteria criteria){
        if(criteria != null)
            criteria.andEqualTo(ENTITY_DEL_FLAG, DeleteFlags.EXIST.getFlag());
    }

    public static void andEqualToDeleteExist(Example example){
        if(example != null){
            if(ArrayUtils.isNotNullAndLengthNotZero(example.getOredCriteria()))
                for(Example.Criteria criteria : example.getOredCriteria()) {
                    if(ArrayUtils.isNotNullAndLengthNotZero(criteria.getCriteria()))
                        criteria.setAndOr(" " + TABLE_DEL_FLAG + " = " + DeleteFlags.EXIST.getFlag() + " and ");
                    else
                        andEqualToDeleteExist(criteria);
                }
        }
    }

    public static void andEqualToDeleteExist(List<Example.Criteria> criteriaList){
        if(ArrayUtils.isNotNullAndLengthNotZero(criteriaList))
            for(Example.Criteria criteria : criteriaList)
                andEqualToDeleteExist(criteria);
    }


    public static void andEqualToDeleteNotExist(Example.Criteria criteria){
        if(criteria != null)
            criteria.andEqualTo(ENTITY_DEL_FLAG, DeleteFlags.NOT_EXIST.getFlag());
    }

    public static void andEqualToDeleteNotExist(List<Example.Criteria> criteriaList){
        if(ArrayUtils.isNotNullAndLengthNotZero(criteriaList))
            for(Example.Criteria criteria : criteriaList)
                andEqualToDeleteNotExist(criteria);
    }

    public static String likePattern(Object str){
        return "%" + str + "%";
    }
    
    public static void setOrderByColumnAsc(Example example,String column){
        example.setOrderByClause(columnAsc(column));
    }

    public static void setOrderByColumnAsc(Example example,String ...columns){
        StringBuffer tmp = new StringBuffer();
        for(String column : columns){
            tmp.append(" ");
            tmp.append(column);
            tmp.append(StringUtils.COMMA);
            tmp.append(" ");
        }
        if(tmp.length() > 0)
            tmp = tmp.deleteCharAt(tmp.length() - 2);
        example.setOrderByClause(columnAsc(tmp.toString()));
    }
    
    public static void setOrderByColumnDesc(Example example,String column){
        example.setOrderByClause(columnDesc(column));
    }

    /**
     * @Title:
     * @Description: 构建example查询
     * @param:  clazz
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/12 0012 22:32
     */
    public static Example newExample(Class clazz){
        if(clazz != null)
            return new Example(clazz,true,true);
        return null;
    }

}
