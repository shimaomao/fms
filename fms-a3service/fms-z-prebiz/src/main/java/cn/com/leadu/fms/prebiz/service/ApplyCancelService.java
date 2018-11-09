package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCancel;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消
 */
public interface ApplyCancelService {
    public PageInfoExtend<ApplyCancelVo> findApplyCancelsByPage(ApplyCancelVo applyCancelVo, SysUser sysUser);

    /**
     * @Title:
     * @Description:  根据applyNo获取银行账号维护
     * @param applyNo
     * @return BasBankInfo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public ApplyCancelVo findApplyCancelVoByApplyNo(String applyNo);

    /**
     * @Title:
     * @Description:  融资申请取消
     * @param applyCancelVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public void modifyApplyCancel(ApplyCancelVo applyCancelVo,SysUser sysUser);
}
