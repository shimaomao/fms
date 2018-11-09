package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoRetreatsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: TransferInfoDao
 * @Description: 过户流程dao层
 * @date 2018-08-30
 */
public interface TransferInfoDao extends BaseDao<TransferInfo> {

    /**
     * @Description: 分页取得过户一览信息数据
     * @param: transferInfoVo
     * @return: List<TransferInfoVo>
     * @Author: wangxue
     * @Date: 2018/8/30 14:42
     */
    List<TransferInfoVo> selectTransferInfosByPage(@Param("transferInfoVo") TransferInfoVo transferInfoVo);

    /**
     * @Description: 根据合同编号 获取过户处理明细信息
     * @param: contNo 合同编号
     * @return: TransferInfoVo
     * @Author: wangxue
     * @Date: 2018/8/31 10:22
     */
    TransferInfoVo selectTransferDetailByContNo(@Param("contNo") String contNo,@Param("cancelMortgageStatus") String cancelMortgageStatus,@Param("invalidMortgageStatus") String invalidMortgageStatus);

    /**
     * @Description: 根据过户任务号 获取过户处理明细信息
     * @param: transferNo 过户任务号
     * @return: TransferInfoVo
     * @Author: wangxue
     * @Date: 2018/8/31 10:22
     */
    TransferInfoVo selectTransferInfoVoByTransferNo(@Param("transferNo") String transferNo,@Param("cancelMortgageStatus") String cancelMortgageStatus,@Param("invalidMortgageStatus") String invalidMortgageStatus);

    /**
     * 获取确认书需要数据
     * @param contNo
     * @return
     */
    TransferInfoLetterVo selectTransferInfoLetterVo(@Param("contNo") String contNo);

    /**
     * @Title:
     * @Description: 分页查询过户退保一览
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<TransferInfoRetreatsVo> selectTransferInfoRetreatsVosByPage(@Param("transferInfoRetreatsVo") TransferInfoRetreatsVo transferInfoRetreatsVo);

    /**
     * @Title:
     * @Description: 根据退保任务号查询过户退保信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    TransferInfoRetreatsVo selectTransferInfoRetreatVoByRetreatsNo(@Param("retreatsNo") String retreatsNo);

    /**
     * @Title:
     * @Description: 根据合同号查询过户退保信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    TransferInfoRetreatsVo selectTransferInfoRetreatVoByContNo(@Param("contNo") String contNo);

    /**
     * @Title:
     * @Description: 根据退保任务号和业务类型查询财务付款表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    ContPay selectContPayByRetreatsNo(@Param("bizCode")String bizCode, @Param("paymentType")String paymentType);
}