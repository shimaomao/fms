package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasPartner;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author huchenghao
 * @ClassName: BasPartnerDao
 * @Description: 经销商信息维护dao层
 * @date 2018-03-17
 */
public interface BasPartnerDao extends BaseDao<BasPartner> {
    /**
     * @Title:
     * @Description: 根据经销商代码，取得用户组信息
     * @param partnerId 用户组
     * @return partner
     * @throws
     * @author wangxue
     * @date 2018-3-14 14:39:58
     */
    BasPartnerVo findBasPartnerByPartnerId(@Param("parentType") String parentType, @Param("partnerId") String partnerId);
}