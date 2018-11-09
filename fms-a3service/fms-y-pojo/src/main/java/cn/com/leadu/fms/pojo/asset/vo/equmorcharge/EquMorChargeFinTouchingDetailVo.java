package cn.com.leadu.fms.pojo.asset.vo.equmorcharge;

import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeFinTouchingDetailVo
 * @Description: 财务制单 详情vo
 * @date 2018/6/11
 */
@Data
public class EquMorChargeFinTouchingDetailVo {

    private BasBankInfoVo basBankInfoVo;

    private EquMorCharge equMorCharge;

    private List<EquMorDetailVo> equMorDetailVos;

    private List<BizFiles> bizFilesList;

}
