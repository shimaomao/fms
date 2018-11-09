package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.riskmgmt.service.RiskTelchkService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskTelchkRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchk;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchk.RiskTelchkVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo.RiskTelchkSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo.RiskTelchkModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo.RiskTelchkDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo.RiskTelchkDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkService
 * @Description: 风控电核信息业务实现层
 * @date 2018-06-04
 */
@Service
public class RiskTelchkServiceImpl implements RiskTelchkService {

    /**
     * @Fields  : 风控电核信息repository
     */
    @Autowired
    private RiskTelchkRepository riskTelchkRepository;

    /**
     * @Title:
     * @Description: 分页查询风控电核信息
     * @param riskTelchkVo
     * @return PageInfoExtend<RiskTelchk>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:45
     */
    public PageInfoExtend<RiskTelchk> findRiskTelchksByPage(RiskTelchkVo riskTelchkVo){
        Example example = SqlUtil.newExample(RiskTelchk.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RiskTelchk> pageInfo = riskTelchkRepository.selectListByExamplePage(example,riskTelchkVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存风控电核信息
     * @param riskTelchkSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:45
     */
    public void saveRiskTelchk(RiskTelchkSaveVo riskTelchkSaveVo){
        riskTelchkRepository.insertData(riskTelchkSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改风控电核信息
     * @param riskTelchkModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:45
     */
    public void modifyRiskTelchk(RiskTelchkModifyVo riskTelchkModifyVo){
        riskTelchkRepository.updateByPrimaryKeySelectiveData(riskTelchkModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskTelchkId删除风控电核信息
     * @param riskTelchkDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:45
     */
    public void deleteRiskTelchk(RiskTelchkDeleteVo riskTelchkDeleteVo){
        riskTelchkRepository.deleteData(riskTelchkDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskTelchkId集合删除风控电核信息
     * @param riskTelchkDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:45
     */
    public void deleteRiskTelchksByRiskTelchkIds(RiskTelchkDeleteListVo riskTelchkDeleteListVo){
        riskTelchkRepository.deleteDataList(riskTelchkDeleteListVo.getRiskTelchkIds(),riskTelchkDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据riskTelchkId获取风控电核信息
     * @param riskTelchkId
     * @return RiskTelchk
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:45
     */
    public RiskTelchk findRiskTelchkByRiskTelchkId(String riskTelchkId){
        return riskTelchkRepository.selectByPrimaryKey(riskTelchkId);
    }

    /**
     * @Title:
     * @Description:  根据ApplyNo获取风控电核信息
     * @param applyNo
     * @return RiskTelchk
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:45
     */
    @Override
    public List<RiskTelchkVo> findRiskTelchkByApplyNo(String applyNo) {
        return riskTelchkRepository.selectRiskTelchkByApplyNo(applyNo);
    }

}
