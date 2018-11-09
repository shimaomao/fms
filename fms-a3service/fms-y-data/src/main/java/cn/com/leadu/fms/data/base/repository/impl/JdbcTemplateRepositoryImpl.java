package cn.com.leadu.fms.data.base.repository.impl;

import cn.com.leadu.fms.common.constant.MarkedWordsConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.data.base.repository.JdbcTemplateRepository;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * @author qiaomengnan
 * @ClassName: JdbcTemplateRepositoryImpl
 * @Description:    使用jdbcTemplate实现批量操作
 * @date 2018/2/26
 */
@Repository
public class JdbcTemplateRepositoryImpl implements JdbcTemplateRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcTemplateRepositoryImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @Title:
     * @Description:   批量录入
     * @param params
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/26 10:03:48
     */
    public int insertList(List params){
        if(ArrayUtils.isNotNullAndLengthNotZero(params)) {
            Map<String,Object> logParams = new HashedMap();
            Class<?> entityClass = params.get(0).getClass();
            StringBuffer sql = new StringBuffer();
            sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
            //获取全部列
            List<EntityColumn> columnList = new ArrayList<>(EntityHelper.getColumns(entityClass));
            List<EntityColumn> pkColumnList = new ArrayList<>(EntityHelper.getPKColumns(entityClass));
            //field
            Map<String,Field> fieldMap = getMapField(entityClass);
            StringBuffer val = new StringBuffer();
            sql.append(" ( ");
            val.append(" VALUES ( ");
            for (EntityColumn entityColumn : columnList){
                sql.append(entityColumn.getColumn());
                sql.append(" ,");
                val.append(" ?,");

            }
            sql = sql.deleteCharAt(sql.length()-1);
            sql.append(" ) ");
            val = val.deleteCharAt(val.length()-1);
            val.append(" ) ");
            String insertSql = sql.toString()+val.toString();
            int [] result = jdbcTemplate.batchUpdate(insertSql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Object param = params.get(i);
                    for(int k = 0 ; k< columnList.size() ; k++) {
                        try{
                            String property = columnList.get(k).getProperty();
                            Field field = fieldMap.get(property);
                            Object val = field.get(param);
                            if(pkColumnList.contains(columnList.get(k))
                                    && columnList.get(k).getJavaType().equals(String.class)
                                    && StringUtils.isTrimBlank(val)){
                                val = UUIDUtils.getUUID();
                            }
                            ps.setObject(k + 1, val);
                        }catch (IllegalAccessException ex){
                            throw new RuntimeException("获取参数出错");
                        }
                    }
                }
                @Override
                public int getBatchSize() {
                    return params.size();
                }
            });
            int updates = ArrayUtils.count(result).intValue();
            LOGGER.debug("==>  Preparing: "+ insertSql);
            logParams.put("params",params);
            LOGGER.debug("==> Parameters: " + JSON.toJSONString(logParams));
            LOGGER.debug("<==    Updates: "+ updates);
            return updates;
        }
        return 0;
    }

    /**
     * @Title:
     * @Description:   批量更新
     * @param params
     * @param selective 是否只更新不为null的值
     * @param exclusive 是否排他
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/26 10:12:00
     */
    public int updateList(List params,boolean selective,boolean exclusive){

        if(ArrayUtils.isNotNullAndLengthNotZero(params)) {
            Class<?> entityClass = params.get(0).getClass();
            //获取全部列
            List<EntityColumn> columnList = new ArrayList<>(EntityHelper.getColumns(entityClass));
            List<EntityColumn> pkColumnList = new ArrayList<>(EntityHelper.getPKColumns(entityClass));
            if(ArrayUtils.isNullOrLengthZero(pkColumnList))
                throw new FmsServiceException("未获取到主键");
            //field
            Map<String,Field> fieldMap = getMapField(entityClass);
            List<String> updateSqlList = new ArrayList<>();
            for(Object param : params){
                StringBuffer updateSql = new StringBuffer();
                updateSql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
                updateSql.append(" SET ");
                for (EntityColumn entityColumn : columnList){
                    if(pkColumnList.contains(entityColumn))
                        continue;
                    Object columnVal = getValue(getFieldValue(entityColumn,fieldMap,param));
                    if(selective == true && columnVal != null) {
                        updateSql.append(entityColumn.getColumn());
                        updateSql.append(" = ");
                        updateSql.append(columnVal);
                        updateSql.append(" , ");
                    }
                    if(selective == false){
                        updateSql.append(entityColumn.getColumn());
                        updateSql.append(" = ");
                        updateSql.append(columnVal);
                        updateSql.append(" , ");
                    }
                }
                updateSql = updateSql.deleteCharAt(updateSql.lastIndexOf(","));
                for(EntityColumn pkColumn : pkColumnList){
                    updateSql.append(" WHERE ");
                    updateSql.append(pkColumn.getColumn());
                    updateSql.append(" = ");
                    updateSql.append(getFieldValue(pkColumn,fieldMap,param));
                    if(pkColumn != pkColumnList.get(pkColumnList.size() - 1))
                        updateSql.append(" and ");
                }
                //根据update_time进行排他
                if(exclusive){
                    if(param instanceof BaseEntity){
                        BaseEntity baseEntity = (BaseEntity)param;
                        if(baseEntity.getUpdateLastTime() == null){
                            throw new FmsServiceException("未获取到最后一次更新时间");
                        }
                        updateSql.append(" and update_time = '"+DateUtils.dateToStr(baseEntity.getUpdateLastTime(),DateUtils.formatStr_yyyyMMddHHmmssSSS)+"' ");
                    }
                }
                updateSqlList.add(updateSql.toString());
            }
            int [] result = jdbcTemplate.batchUpdate(updateSqlList.toArray(new String[]{}));
            LOGGER.debug("==>  Executing: "+ JSON.toJSONString(updateSqlList));
            int resultValue = ArrayUtils.count(result).intValue();
            if(exclusive && resultValue != params.size())
                throw new FmsServiceException(MarkedWordsConstants.SQL_EXCLUSIVE_ERROR_MESSAGE);
            return resultValue;
        }
        return 0;
    }

    /**
     * @Title:
     * @Description:   保存并返回实体列
     * @param entityClass
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/26 10:41:25
     */
    private Map<String,Field> getMapField(Class<?> entityClass){
        Map<String,Field> fieldMap = new HashMap<>();
        for(Field field : entityClass.getDeclaredFields()){
            field.setAccessible(true);
            fieldMap.put(field.getName(),field);
        }

        Class superClass = entityClass.getSuperclass();
        while(superClass != null){
            for(Field field : superClass.getDeclaredFields()){
                field.setAccessible(true);
                fieldMap.put(field.getName(),field);
            }
            superClass = superClass.getSuperclass();
        }
        return fieldMap;
    }

    /**
     * @Title:
     * @Description:   获取实际值
     * @param entityColumn
     * @param fieldMap
     * @param param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/26 11:16:25
     */
    private Object getFieldValue(EntityColumn entityColumn,Map<String,Field> fieldMap,Object param){
        Object columnVal = null;
        Field field = fieldMap.get(entityColumn.getProperty());
        try {
            columnVal = field.get(param);
            if(columnVal != null)
                return "'" + getValue(columnVal) + "'";
//            if(columnVal != null && entityColumn.getJavaType().equals(Date.class))
//                return "'" + getValue(columnVal) + "'";
//            else
//
//            if(columnVal != null && !entityColumn.getJavaType().equals(Integer.class)
//                    && !entityColumn.getJavaType().equals(int.class) )
//                return "'" + columnVal + "'";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return columnVal;
    }

    /**
     * @Title:
     * @Description:   获取实体类的表名
     * @param entityClass
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/26 10:41:17
     */
    private String tableName(Class<?> entityClass) {
        EntityTable entityTable = EntityHelper.getEntityTable(entityClass);
        return entityTable.getName();
    }

    /**
     * @Title:
     * @Description: 对值进行转换
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/14  14:28
     */
    private Object getValue(Object val){
        if(val instanceof Date){
            return DateUtils.dateToStr((Date) val,DateUtils.formatStr_yyyyMMddHHmmss);
        }
        return val;
    }

}
