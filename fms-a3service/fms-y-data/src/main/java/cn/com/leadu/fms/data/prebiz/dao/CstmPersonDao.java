package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.CstmPersonAddTelVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author ningyangyang
 * @ClassName: CstmPersonDao
 * @Description: 客户个人基本信息dao层
 * @date 2018-03-26
 */
public interface CstmPersonDao extends BaseDao<CstmPerson> {
    /**
     * @Description: 根据身亲编号获取客户的地址信息和电话信息
     * @param:  applyNo 申请编号
     * @return: CstmPersonAddTelVo
     * @Author: wangxue
     * @Date: 2018/9/4 17:32
     */
    CstmPersonAddTelVo selectCstmPersonAddTelVoByApplyNo(@Param("applyNo") String applyNo);
}