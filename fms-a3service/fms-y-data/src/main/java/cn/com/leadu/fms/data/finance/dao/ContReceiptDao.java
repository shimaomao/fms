package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContReceiptDao
 * @Description: 黑名单dao层
 * @date 2018-05-07
 */
public interface ContReceiptDao extends BaseDao<ContReceipt> {

    /**
     * @Title:
     * @Description:  分页获取收款明细一览
     * @param contReceiptVo
     * @return List<ContReceiptVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-26 13:51:12
     */
    List<ContReceiptVo> selectContReceiptsByPage(@Param("contReceiptVo") ContReceiptVo contReceiptVo);


    /**
     * @Title:
     * @Description:  分页获取收款明细导入
     * @param contReceiptVo
     * @return List<ContReceiptVo>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 13:51:12
     */
    List<ContReceiptVo> selectContReceiptsImport(@Param("contReceiptVo") ContReceiptVo contReceiptVo);

}