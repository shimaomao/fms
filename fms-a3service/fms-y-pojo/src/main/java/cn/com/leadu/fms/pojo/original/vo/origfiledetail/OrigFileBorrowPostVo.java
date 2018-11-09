package cn.com.leadu.fms.pojo.original.vo.origfiledetail;

import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lijunjun on 2018/5/30.
 */
@Data
public class OrigFileBorrowPostVo {

    /**
     * @Fields  : 原件归档明细List
     * @author lijunjun
     */
    private List<OrigFileDetailVo> origFileDetailVoList;

    /**
     * @Fields  : 附件信息
     * @author lijunjun
     */
    private CommonBizFilesVo commonBizFilesVo;
}
