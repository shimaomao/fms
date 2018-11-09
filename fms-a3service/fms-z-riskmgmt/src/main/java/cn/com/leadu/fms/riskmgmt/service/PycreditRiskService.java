package cn.com.leadu.fms.riskmgmt.service;

import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;

/**
 * @author liujinge
 * @ClassName: ApplyRiskService
 * @Description:
 * @date 2018-06-04
 */
public interface PycreditRiskService {
    /**
     * @Description: 保存风控数据
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/8 15:33
     */
    PycreditListVo saveApplyRiskPyCredit(PycreditListVo pycreditListVo);
}
