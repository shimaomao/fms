package cn.com.leadu.fms.postbiz.validator.licenseidx.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author license_idx
 * @ClassName: LicenseIdxVo
 * @Description: 指标管理表删除时载体及验证
 */
@Data
public class LicenseIdxDeleteVo extends BaseVo<LicenseIdx> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 指标管理id
     * @author license_idx
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String licenseIdxId;

}