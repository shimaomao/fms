package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import cn.com.leadu.fms.pojo.prebiz.vo.crmcompany.CrmCompanyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyDao
 * @Description: CRM企业信息dao层
 * @date 2018-05-23
 */
public interface CrmCompanyDao extends BaseDao<CrmCompany> {

    /**
     * @Description: 获取crm企业信息及其股东信息
     * @param:contRepaySkedVo
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/3 17:32
     */
    List<CrmCompanyVo> selectCrmCompanyVosByPage(@Param("crmCompanyVo") CrmCompanyVo crmCompanyVo);
}