package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCancel;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * Created by yanfengbo
 * 融资合同取消
 */
public interface ContractCancelService {
    public PageInfoExtend<ContractCancelVo> findContractCancelsByPage(ContractCancelVo contractCancelVo, SysUser sysUser);

    /**
     * @Title:
     * @Description:  根据contNo获取融资合同取消
     * @param contNo
     * @return BasBankInfo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public ContractCancelVo findContractCancelVoByContNo(String contNo);

    /**
     * @Title:
     * @Description:  融资合同取消
     * @param contractCancelVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public void modifyContractCancel(ContractCancelVo contractCancelVo,SysUser sysUser);
}
