package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.prebiz.dao.ContractCancelDao;
import cn.com.leadu.fms.data.prebiz.repository.ContractCancelRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractCancel;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;
import org.springframework.stereotype.Repository;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消
 */
@Repository
public class ContractCancelRepositoryImpl extends AbstractBaseRepository<ContractCancelDao, ContractCancel> implements ContractCancelRepository {

    //分页查询融资申请取消vo
    public PageInfoExtend<ContractCancel> selectListVoByPage(String methodName, Object param, PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }


    /**
     * @Title:
     * @Description:  根据contNo获取融资合同取消
     * @param contNo
     * @return ContractCancelVo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public ContractCancelVo selectContractCancelVoByContNo(String contNo){
        return baseDao.selectContractCancelVoByContNo(contNo);

    }
}

