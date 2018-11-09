package cn.com.leadu.fms.data.base.repository;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: JdbcTemplateRepository
 * @Description:
 * @date 2018/2/26
 */
public interface JdbcTemplateRepository {

    /**
     * @Title:
     * @Description:   批量录入
     * @param params
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/26 10:03:48
     */
    int insertList(List params);

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
    int updateList(List params,boolean selective,boolean exclusive);

}
