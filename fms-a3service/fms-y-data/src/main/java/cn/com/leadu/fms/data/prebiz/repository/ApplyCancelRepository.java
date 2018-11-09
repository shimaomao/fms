package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCancel;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;

/**
 * Created by 融资申请取消 on 2018/3/28.
 */
public interface ApplyCancelRepository {
    //分页查询融资申请取消vo
    public PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

    /**
     * @Title:
     * @Description:  根据applyNo获取融资申请取消
     * @param applyNo
     * @return ApplyCancelVo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public ApplyCancelVo selectApplyCancelVoByApplyNo(String applyNo);

}
