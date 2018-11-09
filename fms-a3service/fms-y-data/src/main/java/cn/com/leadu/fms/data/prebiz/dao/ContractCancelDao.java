package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCancel;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractCancel;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消
 */
public interface ContractCancelDao extends BaseDao<ContractCancel>{
    //分页查询融资申请取消
    List<ContractCancelVo> selectContractCancelByPage(@Param("contractCancelVo") ContractCancelVo contractCancelVo);

    /**
     * @Title:
     * @Description:  根据contNo获取融资申请取消
     * @param contNo
     * @return ContractCancelVo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    ContractCancelVo selectContractCancelVoByContNo(@Param("contNo") String contNo);

}
