package cn.com.leadu.fms.baseinfo.validator.baspartner.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasPartner;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasPartnerVo
 * @Description: 经销商信息维护删除时载体及验证
 * @date 2018-03-17
 */
@Data
public class BasPartnerDeleteListVo extends BaseVo<BasPartner> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 合作商ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> partnerIds;

}