package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskMgmtCompRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtComp;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskmgmtcomp.RiskMgmtCompVo;
import cn.com.leadu.fms.riskmgmt.service.RiskMgmtCompService;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo.RiskMgmtCompDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo.RiskMgmtCompDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo.RiskMgmtCompModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo.RiskMgmtCompSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author liujinge
 * @ClassName: RiskMgmtCompService
 * @Description: 风控企业信息业务实现层
 * @date 2018-06-04
 */
@Service
public class RiskMgmtCompServiceImpl implements RiskMgmtCompService {

    /**
     * @Fields  : 风控企业信息repository
     */
    @Autowired
    private RiskMgmtCompRepository riskMgmtCompRepository;

    /**
     * @Title:
     * @Description: 分页查询风控企业信息
     * @param riskMgmtCompVo
     * @return PageInfoExtend<RiskMgmtComp>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    public PageInfoExtend<RiskMgmtComp> findRiskMgmtCompsByPage(RiskMgmtCompVo riskMgmtCompVo){
        Example example = SqlUtil.newExample(RiskMgmtComp.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RiskMgmtComp> pageInfo = riskMgmtCompRepository.selectListByExamplePage(example,riskMgmtCompVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存风控企业信息
     * @param riskMgmtCompSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    public void saveRiskMgmtComp(RiskMgmtCompSaveVo riskMgmtCompSaveVo){
        riskMgmtCompRepository.insertData(riskMgmtCompSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改风控企业信息
     * @param riskMgmtCompModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    public void modifyRiskMgmtComp(RiskMgmtCompModifyVo riskMgmtCompModifyVo){
        riskMgmtCompRepository.updateByPrimaryKeySelectiveData(riskMgmtCompModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskMgmtCompId删除风控企业信息
     * @param riskMgmtCompDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    public void deleteRiskMgmtComp(RiskMgmtCompDeleteVo riskMgmtCompDeleteVo){
        riskMgmtCompRepository.deleteData(riskMgmtCompDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskMgmtCompId集合删除风控企业信息
     * @param riskMgmtCompDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    public void deleteRiskMgmtCompsByRiskMgmtCompIds(RiskMgmtCompDeleteListVo riskMgmtCompDeleteListVo){
        riskMgmtCompRepository.deleteDataList(riskMgmtCompDeleteListVo.getRiskMgmtCompIds(),riskMgmtCompDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据riskMgmtCompId获取风控企业信息
     * @param riskMgmtCompId
     * @return RiskMgmtComp
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:53
     */
    public RiskMgmtComp findRiskMgmtCompByRiskMgmtCompId(String riskMgmtCompId){
        return riskMgmtCompRepository.selectByPrimaryKey(riskMgmtCompId);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取风控企业信息
     * @param applyNo
     * @return RiskMgmtComp
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public RiskMgmtComp findRiskMgmtCompByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(RiskMgmtComp.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        return riskMgmtCompRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据主贷人获取风控个人信息
     * @param certifNo
     * @return RiskMgmtPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public RiskMgmtComp findRiskMgmtCompByMain(String certifNo,String applyNo){
        return riskMgmtCompRepository.selectRiskMgmtCompByMain(certifNo,applyNo);
    }
}
