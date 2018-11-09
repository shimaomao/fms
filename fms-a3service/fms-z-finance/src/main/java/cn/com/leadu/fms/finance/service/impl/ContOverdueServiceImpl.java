package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.exception.FmsException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.finance.service.ContOverdueService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContOverdueRepository;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.ContOverdueSaveVo;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.ContOverdueModifyVo;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.ContOverdueDeleteVo;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.ContOverdueDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContOverdueService
 * @Description: 还款逾期罚息业务实现层
 * @date 2018-05-08
 */
@Service
public class ContOverdueServiceImpl implements ContOverdueService {

    /**
     * @Fields  : 还款逾期罚息repository
     */
    @Autowired
    private ContOverdueRepository contOverdueRepository;

    /**
     * @Title:
     * @Description: 分页查询还款逾期罚息
     * @param contOverdueVo
     * @return PageInfoExtend<ContOverdue>
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public PageInfoExtend<ContOverdue> findContOverduesByPage(ContOverdueVo contOverdueVo){
        Example example = SqlUtil.newExample(ContOverdue.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContOverdue> pageInfo = contOverdueRepository.selectListByExamplePage(example,contOverdueVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存还款逾期罚息
     * @param contOverdueSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public void saveContOverdue(ContOverdueSaveVo contOverdueSaveVo){
        contOverdueRepository.insertData(contOverdueSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改还款逾期罚息
     * @param contOverdueModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public void modifyContOverdue(ContOverdueModifyVo contOverdueModifyVo){
        contOverdueRepository.updateByPrimaryKeySelectiveData(contOverdueModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contOverdueId删除还款逾期罚息
     * @param contOverdueDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public void deleteContOverdue(ContOverdueDeleteVo contOverdueDeleteVo){
        contOverdueRepository.deleteData(contOverdueDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contOverdueId集合删除还款逾期罚息
     * @param contOverdueDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public void deleteContOverduesByContOverdueIds(ContOverdueDeleteListVo contOverdueDeleteListVo){
        contOverdueRepository.deleteDataList(contOverdueDeleteListVo.getContOverdueIds(),contOverdueDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据contOverdueId获取还款逾期罚息
     * @param contOverdueId
     * @return ContOverdue
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public ContOverdue findContOverdueByContOverdueId(String contOverdueId){
        return contOverdueRepository.selectByPrimaryKey(contOverdueId);
    }

    /**
     * @param contNo
     * @Description: 查询逾期罚息表中，扣款状态<>成功 的剩余罚息金额合计
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 14:46
     */
    @Override
    public BigDecimal findOverdueInterestSum(String contNo) {
        ContOverdueVo contOverdueVo = new ContOverdueVo();
        contOverdueVo.setContNo(contNo);
        contOverdueVo.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());
        return contOverdueRepository.selectOverdueInterestSum(contOverdueVo);
    }

    /**
     * @Description: 根据合同号查找总罚息
     * @param:
     * @return:BigDecimal
     * @Author: ningyangyang
     * @Date: 2018/5/23 14:46
     */
    @Override
    public BigDecimal findContOverdueAmountByContNo(String contNo) {
        return contOverdueRepository.selectContOverdueAmountByContNo(contNo);
    }

    /**
     * @Title:
     * @Description: 根据合同号关联查询逾期罚息表和还款计划表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public List<ContOverdueVo> findContOverdueByCont(String contNo){
        if(StringUtils.isNotTrimBlank(contNo)){
            return contOverdueRepository.selectContOverdueByCont(contNo);
        }else {
            throw new FmsServiceException("无法获得合同号!");
        }

    }
}
