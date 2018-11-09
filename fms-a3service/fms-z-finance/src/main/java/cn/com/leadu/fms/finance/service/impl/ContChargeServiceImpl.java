package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.finance.service.ContChargeService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeReceiptVo;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeVo;
import cn.com.leadu.fms.finance.validator.contcharge.vo.ContChargeSaveVo;
import cn.com.leadu.fms.finance.validator.contcharge.vo.ContChargeModifyVo;
import cn.com.leadu.fms.finance.validator.contcharge.vo.ContChargeDeleteVo;
import cn.com.leadu.fms.finance.validator.contcharge.vo.ContChargeDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ContChargeService
 * @Description: 财务待收款业务实现层
 * @date 2018-06-01
 */
@Service
public class ContChargeServiceImpl implements ContChargeService {

    /**
     * @Fields  : 财务待收款repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;

    /**
     * @Title:
     * @Description: 分页查询财务待收款
     * @param contChargeVo
     * @return PageInfoExtend<ContCharge>
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:47
     */
    public PageInfoExtend<ContCharge> findContChargesByPage(ContChargeVo contChargeVo){
        Example example = SqlUtil.newExample(ContCharge.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContCharge> pageInfo = contChargeRepository.selectListByExamplePage(example,contChargeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存财务待收款
     * @param contChargeSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:47
     */
    public void saveContCharge(ContChargeSaveVo contChargeSaveVo){
        contChargeRepository.insertData(contChargeSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改财务待收款
     * @param contChargeModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:47
     */
    public void modifyContCharge(ContChargeModifyVo contChargeModifyVo){
        contChargeRepository.updateByPrimaryKeySelectiveData(contChargeModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contChargeId删除财务待收款
     * @param contChargeDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:47
     */
    public void deleteContCharge(ContChargeDeleteVo contChargeDeleteVo){
        contChargeRepository.deleteData(contChargeDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contChargeId集合删除财务待收款
     * @param contChargeDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:47
     */
    public void deleteContChargesByContChargeIds(ContChargeDeleteListVo contChargeDeleteListVo){
        contChargeRepository.deleteDataList(contChargeDeleteListVo.getContChargeIds(),contChargeDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据contChargeId获取财务待收款
     * @param contChargeId
     * @return ContCharge
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:47
     */
    public ContCharge findContChargeByContChargeId(String contChargeId){
        return contChargeRepository.selectByPrimaryKey(contChargeId);
    }

    /**
     * @param chargeBizId
     * @param chargeBizType
     * @Description: 根据 业务类型 业务号查询待收款数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 11:05
     */
    @Override
    public List<ContCharge> fingContChargeListByBizIdAndBizType(String chargeBizId, String chargeBizType) {
        //查询财务待收款数据
        Example example = SqlUtil.newExample(ContCharge.class);
        example.createCriteria().andEqualTo("chargeBizId",chargeBizId)
                .andEqualTo("chargeBizType", chargeBizType);
        example.setOrderByClause("charge_fund asc");
        List<ContCharge> contChargeList = contChargeRepository.selectListByExample(example);
        return contChargeList;
    }

    /**
     * @param chargeBizId
     * @param chargeBizType
     * @Description: 根据业务类型和业务号查询待收款数据和收款数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/28 10:56
     */
    @Override
    public List<ContChargeReceiptVo> fingContChargeAndReceiptByBizIdAndBizType(String chargeBizId, String chargeBizType,String chargeFund) {

        return contChargeRepository.selectContChargeAndReceiptByBizIdAndBizType(chargeBizId,chargeBizType, chargeFund);
    }

}
