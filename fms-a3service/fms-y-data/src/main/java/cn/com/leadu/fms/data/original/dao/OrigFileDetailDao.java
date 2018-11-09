package cn.com.leadu.fms.data.original.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowPostVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: OrigFileDetailDao
 * @Description: 资料邮寄附件明细dao层
 * @date 2018-05-03
 */
public interface OrigFileDetailDao extends BaseDao<OrigFileDetail> {


    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细
     * @param origFileDetailVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileDetailVo> selectOrigFileDetailVosByPage(@Param("origFileDetailVo") OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细
     * @param origFileDetailVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileDetailVo> selectOrigFileDetailsVosByPage(@Param("origFileDetailVo") OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细
     * @param origFileDetailVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileDetailVo> selectOrigFileBorrowDetails(@Param("origFileDetailVo") OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细
     * @param borrowTaskNo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileDetailVo> selectOrigFileBorrowMailByBorrowTaskNo(@Param("borrowTaskNo") String borrowTaskNo);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细（借阅归还）
     * @param origFileDetailVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileDetailVo> selectOrigFileBorrowBackMailByBorrowTaskNo(@Param("origFileDetailVo") OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description: 分页查询资料回寄一览信息
     * @param origFileVo
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileVo> selectOrigFileBorrowBackSendByPage(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 据借阅归还任务号获取财务制单初始化信息
     * @param borrowBackTaskNo
     * @return BorrowBackTaskVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    BorrowBackTaskVo selectBorrowTaskMakeVoucherByBorrowBackTaskNo(@Param("borrowBackTaskNo") String borrowBackTaskNo);

    /**
     * @Title:
     * @Description: 据借阅归还任务号获取资管审核邮寄附件明细信息列表
     * @param borrowBackTaskNo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileDetailVo> selectOrigFileBorrowMailByBorrowBackTaskNo(@Param("borrowBackTaskNo") String borrowBackTaskNo);

    /**
     * @Title:
     * @Description: 据借阅归还任务号获取资管审核邮寄附件明细信息列表
     * @param origFileDetailVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileDetailVo> selectOrigFileBorrowExamineByBorrowBackTaskNo(@Param("origFileDetailVo") OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description: 取待打印客户信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    BorrowBackTaskVo selectCustomerInformationByBorrowBackTaskNo(@Param("borrowBackTaskNo") String borrowBackTaskNo,@Param("bizCodeType") String bizCodeType);
}