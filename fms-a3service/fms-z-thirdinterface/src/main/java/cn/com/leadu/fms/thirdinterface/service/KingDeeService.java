package cn.com.leadu.fms.thirdinterface.service;

import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeResultFileVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeResultVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeVchVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeService
 * @Description: 金蝶接口service
 * @date 2018/7/17 0017
 */
public interface KingDeeService {

    /**
     * @Title:
     * @Description:   金蝶客户同步
     * @param kingDeeCusVos 客户信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:23:51
     */
    KingDeeResultVo kingDeeCus(List<KingDeeCusVo> kingDeeCusVos);

    /**
     * @Title:
     * @Description:   金蝶财务核算代码同步
     * @param kingDeeVchVos 核算代码信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:24:49
     */
    KingDeeResultFileVo kingDeeVoucher(List<KingDeeVchVo> kingDeeVchVos);

}
