package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.riskmgmt.service.PycreditCardCheckService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditCardCheckRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCardCheck;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcardcheck.PycreditCardCheckVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo.PycreditCardCheckSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo.PycreditCardCheckModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo.PycreditCardCheckDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo.PycreditCardCheckDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yangyiquan
 * @ClassName: PycreditCardCheckService
 * @Description: 卡核查及交易业务实现层
 * @date 2018-06-14
 */
@Service
public class PycreditCardCheckServiceImpl implements PycreditCardCheckService {

    /**
     * @Fields  : 卡核查及交易repository
     */
    @Autowired
    private PycreditCardCheckRepository pycreditCardCheckRepository;

    /**
     * @Title:
     * @Description: 分页查询卡核查及交易
     * @param pycreditCardCheckVo
     * @return PageInfoExtend<PycreditCardCheck>
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    public PageInfoExtend<PycreditCardCheck> findPycreditCardChecksByPage(PycreditCardCheckVo pycreditCardCheckVo){
        Example example = SqlUtil.newExample(PycreditCardCheck.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditCardCheck> pageInfo = pycreditCardCheckRepository.selectListByExamplePage(example,pycreditCardCheckVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存卡核查及交易
     * @param pycreditCardCheckSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    public void savePycreditCardCheck(PycreditCardCheckSaveVo pycreditCardCheckSaveVo){
        pycreditCardCheckRepository.insertData(pycreditCardCheckSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改卡核查及交易
     * @param pycreditCardCheckModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    public void modifyPycreditCardCheck(PycreditCardCheckModifyVo pycreditCardCheckModifyVo){
        pycreditCardCheckRepository.updateByPrimaryKeySelectiveData(pycreditCardCheckModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditCardCheckId删除卡核查及交易
     * @param pycreditCardCheckDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    public void deletePycreditCardCheck(PycreditCardCheckDeleteVo pycreditCardCheckDeleteVo){
        pycreditCardCheckRepository.deleteData(pycreditCardCheckDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditCardCheckId集合删除卡核查及交易
     * @param pycreditCardCheckDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    public void deletePycreditCardChecksByPycreditCardCheckIds(PycreditCardCheckDeleteListVo pycreditCardCheckDeleteListVo){
        pycreditCardCheckRepository.deleteDataList(pycreditCardCheckDeleteListVo.getPycreditCardCheckIds(),pycreditCardCheckDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditCardCheckId获取卡核查及交易
     * @param pycreditCardCheckId
     * @return PycreditCardCheck
     * @throws
     * @author yangyiquan
     * @date 2018-6-14 19:59:30
     */
    public PycreditCardCheck findPycreditCardCheckByPycreditCardCheckId(String pycreditCardCheckId){
        return pycreditCardCheckRepository.selectByPrimaryKey(pycreditCardCheckId);
    }

}
