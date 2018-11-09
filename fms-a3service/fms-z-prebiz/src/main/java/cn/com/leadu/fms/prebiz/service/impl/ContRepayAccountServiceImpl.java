package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContRepayAccountRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepayAccount;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountVo;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.prebiz.service.ContRepayAccountService;
import cn.com.leadu.fms.prebiz.validator.contrepayaccount.vo.ContRepayAccountModifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;

/**
 * @author liujinge
 * @ClassName: ContRepayAccountService
 * @Description: 融资合同还款信息业务实现层
 * @date 2018-03-23
 */
@Service
public class ContRepayAccountServiceImpl implements ContRepayAccountService {

    /**
     * @Fields  : 融资合同还款信息repository
     */
    @Autowired
    private ContRepayAccountRepository contRepayAccountRepository;

    /**
     * @Title:
     * @Description: 分页查询融资合同还款信息
     * @param contRepayAccountVo
     * @return PageInfoExtend<ContRepayAccount>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:16
     */
    public PageInfoExtend<ContRepayAccount> findContRepayAccountsByPage(ContRepayAccountVo contRepayAccountVo){
        Example example = SqlUtil.newExample(ContRepayAccount.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContRepayAccount> pageInfo = contRepayAccountRepository.selectListByExamplePage(example,contRepayAccountVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据repayAccId获取融资合同还款信息
     * @param repayAccId
     * @return ContRepayAccount
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:16
     */
    public ContRepayAccount findContRepayAccountByRepayAccId(String repayAccId){
        return contRepayAccountRepository.selectByPrimaryKey(repayAccId);
    }


    /**
     * @Title:
     * @Description:  保存融资合同还款信息
     * @param contRepayAccountVo
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:16
     */
    @Transactional
    public int saveContRepayAccount(@Valid @RequestBody ContRepayAccountVo contRepayAccountVo){
        return contRepayAccountRepository.insertData(contRepayAccountVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据合同号取得融资合同还款信息
     * @param contNo
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:16
     */
    @Override
    public ContRepayAccount findContRepayAccountByContNo(String contNo){
        Example example = SqlUtil.newExample(ContRepayAccount.class);
        example.createCriteria().andEqualTo("contNo",contNo);
        return contRepayAccountRepository.selectOneByExample(example);
    }

    /** 
    * @Description: 动态修改客户还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 17:56
    */
    @Transactional
    @Override
    public int modifyContRepayAccount(ContRepayAccountModifyVo contRepayAccountModifyVo){
        return contRepayAccountRepository.updateByPrimaryKeySelectiveData(contRepayAccountModifyVo.getEntity());
    }

    /**
     * @param contRepayAccountVo
     * @Description: 动态修改客户还款信息(通过contRepayAccountVo)，生成合同时使用
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/9 17:58
     */
    @Transactional
    @Override
    public int modifyContRepayAccountByVo(@RequestBody ContRepayAccountVo contRepayAccountVo) {
        return contRepayAccountRepository.updateByPrimaryKeySelectiveData(contRepayAccountVo.getEntity());
    }

    /**
     * @param contRepayAccountListVo
     * @Description: 分页查询客户信息一览
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/8 18:27
     */
    @Override
    public PageInfoExtend<ContRepayAccountListVo> findContRepayAccountListByPage(ContRepayAccountListVo contRepayAccountListVo) {
        //合同号
        if(StringUtils.isTrimBlank(contRepayAccountListVo.getContNo()))
            contRepayAccountListVo.setContNo(null);
        else
            contRepayAccountListVo.setContNo(SqlUtil.likePattern(contRepayAccountListVo.getContNo()));

        //申请编号
        if (StringUtils.isTrimBlank(contRepayAccountListVo.getApplyNo()))
            contRepayAccountListVo.setApplyNo(null);
        else
            contRepayAccountListVo.setApplyNo(SqlUtil.likePattern(contRepayAccountListVo.getApplyNo()));

        //客户姓名
        if(StringUtils.isTrimBlank(contRepayAccountListVo.getName()))
            contRepayAccountListVo.setName(null);
        else
            contRepayAccountListVo.setName(SqlUtil.likePattern(contRepayAccountListVo.getName()));

        //设置合同状态（合同生效(财务已付款)）
        contRepayAccountListVo.setBizStatus(BizStatusEnums.CONTRACT_EFFECT.getType());

        //设置个人标志
        contRepayAccountListVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());
        //设置企业标志
        contRepayAccountListVo.setCompanyFlag(ApplyTypeEnums.COMPANY.getType());

        PageInfoExtend<ContRepayAccountListVo> pageInfo = contRepayAccountRepository.selectListVoByPage("selectContRepayAccountListByPage",contRepayAccountListVo,contRepayAccountListVo.getPageQuery());
        return pageInfo;
    }


}
