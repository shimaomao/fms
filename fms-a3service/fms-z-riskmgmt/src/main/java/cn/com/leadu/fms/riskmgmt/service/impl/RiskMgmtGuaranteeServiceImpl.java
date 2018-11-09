package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskMgmtGuaranteeRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtGuarantee;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskmgmtguarantee.RiskMgmtGuaranteeVo;
import cn.com.leadu.fms.riskmgmt.service.RiskMgmtGuaranteeService;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo.RiskMgmtGuaranteeDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo.RiskMgmtGuaranteeDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo.RiskMgmtGuaranteeModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo.RiskMgmtGuaranteeSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtGuaranteeService
 * @Description: 风控担保人信息业务实现层
 * @date 2018-06-04
 */
@Service
public class RiskMgmtGuaranteeServiceImpl implements RiskMgmtGuaranteeService {

    /**
     * @Fields  : 风控担保人信息repository
     */
    @Autowired
    private RiskMgmtGuaranteeRepository riskMgmtGuaranteeRepository;

    /**
     * @Title:
     * @Description: 分页查询风控担保人信息
     * @param riskMgmtGuaranteeVo
     * @return PageInfoExtend<RiskMgmtGuarantee>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    public PageInfoExtend<RiskMgmtGuarantee> findRiskMgmtGuaranteesByPage(RiskMgmtGuaranteeVo riskMgmtGuaranteeVo){
        Example example = SqlUtil.newExample(RiskMgmtGuarantee.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RiskMgmtGuarantee> pageInfo = riskMgmtGuaranteeRepository.selectListByExamplePage(example,riskMgmtGuaranteeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存风控担保人信息
     * @param riskMgmtGuaranteeSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    public void saveRiskMgmtGuarantee(RiskMgmtGuaranteeSaveVo riskMgmtGuaranteeSaveVo){
        riskMgmtGuaranteeRepository.insertData(riskMgmtGuaranteeSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改风控担保人信息
     * @param riskMgmtGuaranteeModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    public void modifyRiskMgmtGuarantee(RiskMgmtGuaranteeModifyVo riskMgmtGuaranteeModifyVo){
        riskMgmtGuaranteeRepository.updateByPrimaryKeySelectiveData(riskMgmtGuaranteeModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskMgmtGuaranteeId删除风控担保人信息
     * @param riskMgmtGuaranteeDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    public void deleteRiskMgmtGuarantee(RiskMgmtGuaranteeDeleteVo riskMgmtGuaranteeDeleteVo){
        riskMgmtGuaranteeRepository.deleteData(riskMgmtGuaranteeDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskMgmtGuaranteeId集合删除风控担保人信息
     * @param riskMgmtGuaranteeDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    public void deleteRiskMgmtGuaranteesByRiskMgmtGuaranteeIds(RiskMgmtGuaranteeDeleteListVo riskMgmtGuaranteeDeleteListVo){
        riskMgmtGuaranteeRepository.deleteDataList(riskMgmtGuaranteeDeleteListVo.getRiskMgmtGuaranteeIds(),riskMgmtGuaranteeDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据riskMgmtGuaranteeId获取风控担保人信息
     * @param riskMgmtGuaranteeId
     * @return RiskMgmtGuarantee
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    public RiskMgmtGuarantee findRiskMgmtGuaranteeByRiskMgmtGuaranteeId(String riskMgmtGuaranteeId){
        return riskMgmtGuaranteeRepository.selectByPrimaryKey(riskMgmtGuaranteeId);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取风控担保人信息
     * @param applyNo
     * @return List<RiskMgmtGuarantee>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:28
     */
    @Override
    public List<RiskMgmtGuarantee> findRiskMgmtGuaranteeListByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(RiskMgmtGuarantee.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        return riskMgmtGuaranteeRepository.selectListByExample(example);
    }

}
