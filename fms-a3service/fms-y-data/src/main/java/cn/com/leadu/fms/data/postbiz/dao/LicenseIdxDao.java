package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ReportStatisticsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author license_idx
 * @ClassName: LicenseIdxDao
 * @Description: 指标管理表dao层
 */
public interface LicenseIdxDao extends BaseDao<LicenseIdx> {

    /**
     * @Title:
     * @Description:   根据licenseIdxId查询指标管理信息表
     * @param licenseIdxId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 13:51:56
     */
    LicenseIdxVo selectLicenseIdxVoById(@Param("licenseIdxId") String licenseIdxId);

    /**
     * @Title:
     * @Description:   根据licenseIdxId查询指标管理信息表
     * @param licenseIdxVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 11:51:56
     */
    List<LicenseIdxVo> selectLicenseIdxVos(@Param("licenseIdxVo") LicenseIdxVo licenseIdxVo);

    /**
     * @Title:
     * @Description:  根据licenseIdxNo获取指标管理表是否存在
     * @param licenseIdxNo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-13 11:38:16
     */
    LicenseIdxVo selectLicenseIdxNoById(@Param("licenseIdxNo") String licenseIdxNo);

    /**
     * @Title:
     * @Description:   根据licenseIdxId查询指标管理信息表
     * @param licenseIdxVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/20 11:51:56
     */
    List<LicenseIdxVo> selectLicenseIdxVobySysgroup(@Param("licenseIdxVo") LicenseIdxVo licenseIdxVo);

}