package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskCompanyRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskCompany;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskcompany.RiskCompanyVo;
import cn.com.leadu.fms.riskmgmt.service.RiskCompanyService;
import cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo.RiskCompanyDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo.RiskCompanyDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo.RiskCompanyModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskcompany.vo.RiskCompanySaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskCompanyService
 * @Description: 企业风险信息业务实现层
 * @date 2018-06-04
 */
@Service
public class RiskCompanyServiceImpl implements RiskCompanyService {

    /**
     * @Fields  : 企业风险信息repository
     */
    @Autowired
    private RiskCompanyRepository riskCompanyRepository;

    /**
     * @Title:
     * @Description: 分页查询企业风险信息
     * @param riskCompanyVo
     * @return PageInfoExtend<RiskCompany>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    public PageInfoExtend<RiskCompany> findRiskCompanysByPage(RiskCompanyVo riskCompanyVo){
        Example example = SqlUtil.newExample(RiskCompany.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RiskCompany> pageInfo = riskCompanyRepository.selectListByExamplePage(example,riskCompanyVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存企业风险信息
     * @param riskCompanySaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    public void saveRiskCompany(RiskCompanySaveVo riskCompanySaveVo){
        riskCompanyRepository.insertData(riskCompanySaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改企业风险信息
     * @param riskCompanyModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    public void modifyRiskCompany(RiskCompanyModifyVo riskCompanyModifyVo){
        riskCompanyRepository.updateByPrimaryKeySelectiveData(riskCompanyModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskCompanyId删除企业风险信息
     * @param riskCompanyDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    public void deleteRiskCompany(RiskCompanyDeleteVo riskCompanyDeleteVo){
        riskCompanyRepository.deleteData(riskCompanyDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskCompanyId集合删除企业风险信息
     * @param riskCompanyDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    public void deleteRiskCompanysByRiskCompanyIds(RiskCompanyDeleteListVo riskCompanyDeleteListVo){
        riskCompanyRepository.deleteDataList(riskCompanyDeleteListVo.getRiskCompanyIds(),riskCompanyDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据riskCompanyId获取企业风险信息
     * @param riskCompanyId
     * @return RiskCompany
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:44
     */
    public RiskCompany findRiskCompanyByRiskCompanyId(String riskCompanyId){
        return riskCompanyRepository.selectByPrimaryKey(riskCompanyId);
    }
    /**
     * @Title:
     * @Description:  根据applyNo获取企业风险信息
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    @Override
    public List<RiskCompany> findRiskCompanyListByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(RiskCompany.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        return riskCompanyRepository.selectListByExample(example);
   }

}
