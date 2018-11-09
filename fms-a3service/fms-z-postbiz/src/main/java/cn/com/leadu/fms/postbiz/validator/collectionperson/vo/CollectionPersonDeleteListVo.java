package cn.com.leadu.fms.postbiz.validator.collectionperson.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonVo
 * @Description: 催收组员删除时载体及验证
 */
@Data
public class CollectionPersonDeleteListVo extends BaseVo<CollectionPerson> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 催收人员id

     * @author qinmuqiao
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> collectionPersonIds;

}