package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskPersonRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskPerson;
import cn.com.leadu.fms.pojo.riskmgmt.vo.riskperson.RiskPersonVo;
import cn.com.leadu.fms.riskmgmt.service.RiskPersonService;
import cn.com.leadu.fms.riskmgmt.validator.riskperson.vo.RiskPersonDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.riskperson.vo.RiskPersonDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.riskperson.vo.RiskPersonModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.riskperson.vo.RiskPersonSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskPersonService
 * @Description: 个人风险信息业务实现层
 * @date 2018-06-04
 */
@Service
public class RiskPersonServiceImpl implements RiskPersonService {

    /**
     * @Fields  : 个人风险信息repository
     */
    @Autowired
    private RiskPersonRepository riskPersonRepository;

    /**
     * @Title:
     * @Description: 分页查询个人风险信息
     * @param riskPersonVo
     * @return PageInfoExtend<RiskPerson>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    public PageInfoExtend<RiskPerson> findRiskPersonsByPage(RiskPersonVo riskPersonVo){
        Example example = SqlUtil.newExample(RiskPerson.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RiskPerson> pageInfo = riskPersonRepository.selectListByExamplePage(example,riskPersonVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存个人风险信息
     * @param riskPersonSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    public void saveRiskPerson(RiskPersonSaveVo riskPersonSaveVo){
        riskPersonRepository.insertData(riskPersonSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改个人风险信息
     * @param riskPersonModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    public void modifyRiskPerson(RiskPersonModifyVo riskPersonModifyVo){
        riskPersonRepository.updateByPrimaryKeySelectiveData(riskPersonModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskPersonId删除个人风险信息
     * @param riskPersonDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    public void deleteRiskPerson(RiskPersonDeleteVo riskPersonDeleteVo){
        riskPersonRepository.deleteData(riskPersonDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过riskPersonId集合删除个人风险信息
     * @param riskPersonDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    public void deleteRiskPersonsByRiskPersonIds(RiskPersonDeleteListVo riskPersonDeleteListVo){
        riskPersonRepository.deleteDataList(riskPersonDeleteListVo.getRiskPersonIds(),riskPersonDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据riskPersonId获取个人风险信息
     * @param riskPersonId
     * @return RiskPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    public RiskPerson findRiskPersonByRiskPersonId(String riskPersonId){
        return riskPersonRepository.selectByPrimaryKey(riskPersonId);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取个人风险信息
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    @Override
    public List<RiskPerson> findRiskPersonListByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(RiskPerson.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        return riskPersonRepository.selectListByExample(example);
    }

}
