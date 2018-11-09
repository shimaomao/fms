package cn.com.leadu.fms.data.original.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileStatusVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: OrigFileDao
 * @Description: 资料邮寄附件dao层
 * @date 2018-05-03
 */
public interface OrigFileDao extends BaseDao<OrigFile> {

    /**
     * @Title:
     * @Description: 获取邮寄附件信息（原件归档）
     * @param origFileVo 查询条件
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<OrigFileVo> selectOrigFileVosByOrigFileStatus(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 获取邮寄附件信息（原件借阅）
     * @param origFileVo 查询条件
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<OrigFileVo> selectBorrowOrigFilesByOrigFileStatus(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 获取邮寄附件信息（续保归档）
     * @param origFileVo 查询条件
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<OrigFileVo> selectRenewalOrigFilesByOrigFileStatus(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 获取邮寄附件信息（贷前归档邮寄与上传）
     * @param origFileVo 查询条件
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<OrigFileVo> selectPreOrigFilesByOrigFileStatus(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 获取邮寄附件信息
     * @param origFileVo 查询条件
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    OrigFileVo selectOrigFileInfoByBizCodeAndBizCodeType(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 获取贷前归档明细一览画面数据
     * @param origFileDetailVo
     * @return OrigFileSortVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    OrigFileSortVo selectOrigFileSortDetailsByPage(@Param("origFileDetailVo") OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description: 获取保单归档明细一览画面数据
     * @param origFileDetailVo
     * @return OrigFileSortVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    OrigFileSortVo selectOrigFileRenewalSortDetailsByPage(@Param("origFileDetailVo") OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description: 获取邮寄附件明细表信息（资料邮寄用）
     * @param origFileVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    List<OrigFileDetailVo> selectOrigFileMailList(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 查询融保险资料邮寄附件信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 14:16:46
     */
    List<OrigFileVo> selectOrigFileVos(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * @Title:
     * @Description: 获取邮寄附件信息
     * @param origFileVo 查询条件
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<OrigFileVo>  selectOrigFileListByPage(@Param("origFileVo") OrigFileVo origFileVo);


    /**
     * @Title:
     * @Description: 获取邮寄附件信息
     * @param origFileVo 查询条件
     * @return List<OrigFileVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<OrigFileVo>  selectOrigFileInsListByPage(@Param("origFileVo") OrigFileVo origFileVo);

    /**
     * 根据合同号获取过户状态与收款状态
     * @param contNo
     * @return
     */
    OrigFileStatusVo selectOrigFileStatusVoByContNo(@Param("contNo") String contNo);
}