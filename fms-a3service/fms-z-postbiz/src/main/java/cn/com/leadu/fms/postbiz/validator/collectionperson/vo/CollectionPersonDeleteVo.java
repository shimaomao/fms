package cn.com.leadu.fms.postbiz.validator.collectionperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonVo
 * @Description: 催收组员删除时载体及验证
 */
@Data
public class CollectionPersonDeleteVo extends BaseVo<CollectionPerson> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 催收人员id

     * @author qinmuqiao
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String collectionPersonId;

}