package cn.com.leadu.fms.data.common.util;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: PageInfoExtendUtils
 * @Description: PageInfoExtend工具类
 * @date 2018/3/12
 */
public class PageInfoExtendUtils {

    /**
     * @Title:
     * @Description:
     * @param list
     * @param total
     * @param pageQuery
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 10:41:01
     */
    public static PageInfoExtend getPageInfoExtend(List list,Long total, PageQuery pageQuery){
        PageInfoExtend pageInfoExtend = new PageInfoExtend();
        pageInfoExtend.setDraw(pageQuery.getDraw());
        pageInfoExtend.setData(list);
        pageInfoExtend.setRecordsTotal(total);
        pageInfoExtend.setRecordsFiltered(total);
        return pageInfoExtend;
    }


    /**
     * @Title:
     * @Description:
     * @param list
     * @param total
     * @param pageQuery
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 10:41:01
     */
    public static PageInfoExtend getPageInfoExtend(List list,Long total, PageQuery pageQuery,Class clazz){
        PageInfoExtend pageInfoExtend = new PageInfoExtend();
        pageInfoExtend.setDraw(pageQuery.getDraw());
        pageInfoExtend.setData(list);
        pageInfoExtend.setRecordsTotal(total);
        pageInfoExtend.setRecordsFiltered(total);
        pageInfoExtend.setClazz(clazz.toString().replace("class ",""));
        return pageInfoExtend;
    }

}
