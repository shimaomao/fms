package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.riskmgmt.service.RiskMgmtPersonService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskMgmtPersonRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskmgmtperson.RiskMgmtPersonVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo.RiskMgmtPersonSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo.RiskMgmtPersonModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo.RiskMgmtPersonDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskmgmtperson.vo.RiskMgmtPersonDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author liujinge
 * @ClassName: RiskMgmtPersonService
 * @Description: 风控个人信息业务实现层
 * @date 2018-06-04
 */
@Service
public class RiskMgmtPersonServiceImpl implements RiskMgmtPersonService {

    /**
     * @Fields  : 风控个人信息repository
     */
    @Autowired
    private RiskMgmtPersonRepository riskMgmtPersonRepository;

    /**
     * @Title:
     * @Description: 分页查询风控个人信息
     * @param riskMgmtPersonVo
     * @return PageInfoExtend<RiskMgmtPerson>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    public PageInfoExtend<RiskMgmtPerson> findRiskMgmtPersonsByPage(RiskMgmtPersonVo riskMgmtPersonVo){
        Example example = SqlUtil.newExample(RiskMgmtPerson.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RiskMgmtPerson> pageInfo = riskMgmtPersonRepository.selectListByExamplePage(example,riskMgmtPersonVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存风控个人信息
     * @param riskMgmtPersonSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    public void saveRiskMgmtPerson(RiskMgmtPersonSaveVo riskMgmtPersonSaveVo){
        riskMgmtPersonRepository.insertData(riskMgmtPersonSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改风控个人信息
     * @param riskMgmtPersonModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    public void modifyRiskMgmtPerson(RiskMgmtPersonModifyVo riskMgmtPersonModifyVo){
        riskMgmtPersonRepository.updateByPrimaryKeySelectiveData(riskMgmtPersonModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskMgmtPersonId删除风控个人信息
     * @param riskMgmtPersonDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    public void deleteRiskMgmtPerson(RiskMgmtPersonDeleteVo riskMgmtPersonDeleteVo){
        riskMgmtPersonRepository.deleteData(riskMgmtPersonDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskMgmtPersonId集合删除风控个人信息
     * @param riskMgmtPersonDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    public void deleteRiskMgmtPersonsByRiskMgmtPersonIds(RiskMgmtPersonDeleteListVo riskMgmtPersonDeleteListVo){
        riskMgmtPersonRepository.deleteDataList(riskMgmtPersonDeleteListVo.getRiskMgmtPersonIds(),riskMgmtPersonDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据riskMgmtPersonId获取风控个人信息
     * @param riskMgmtPersonId
     * @return RiskMgmtPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    public RiskMgmtPerson findRiskMgmtPersonByRiskMgmtPersonId(String riskMgmtPersonId){
        return riskMgmtPersonRepository.selectByPrimaryKey(riskMgmtPersonId);
    }


    /**
     * @Title:
     * @Description:  根据applyNo获取风控个人信息
     * @param applyNo
     * @return RiskMgmtPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    @Override
    public RiskMgmtPerson findRiskMgmtPersonByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(RiskMgmtPerson.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        return riskMgmtPersonRepository.selectOneByExample(example);
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
    public RiskMgmtPerson findRiskMgmtPersonByMain(String certifNo,String applyNo){
        return riskMgmtPersonRepository.selectRiskMgmtPersonByMain(certifNo,applyNo);
    }
}
