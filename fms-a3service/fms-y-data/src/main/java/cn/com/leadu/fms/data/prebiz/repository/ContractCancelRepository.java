package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;

/**
 * Created by 融资合同取消 on 2018/3/28.
 */
public interface ContractCancelRepository {
    //分页查询融资申请取消vo
    public PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

    /**
     * @Title:
     * @Description:  根据contNo获取融资合同取消
     * @param contNo
     * @return ContractCancelVo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public ContractCancelVo selectContractCancelVoByContNo(String contNo);

}
