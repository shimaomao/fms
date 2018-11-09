package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyTaskVo;
import cn.com.leadu.fms.asset.validator.equmorapply.EquMorOtherApplyVo;
import cn.com.leadu.fms.asset.validator.equmorapply.EquMorSeaWingApplyVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingPrintVo;
import cn.com.leadu.fms.pojo.asset.vo.equmorcharge.EquMorChargeFinTouchingVo;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.asset.vo.equmortask.EquMorTaskVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeApplyService
 * @Description: 资方抵押申请
 * @date 2018/5/31
 */
public interface EquMorApplyService {

    /**
     * @Title:
     * @Description: 查询资方抵押申请模板下载详情
     * @param contNos
     * @return  List<EquMorOtherApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    PageInfoExtend<EquMorApplyVo> exportEquMorApplyVos(List<String> contNos);


    /**
     * @Title:
     * @Description: 分页查询资方抵押申请vos
     * @param equMorApplyVo
     * @return PageInfoExtend<EquMorChargeVos>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    PageInfoExtend<EquMorApplyVo> findEquMorApplyVosByPage(EquMorApplyVo equMorApplyVo);

    /**
     * @Title:
     * @Description: 根据任务号返回资方抵押申请列表
     * @param: equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/3 0003 14:55
     */
    EquMorTaskVo findEquMorTaskVoByEquMorTaskNo(String equMorTaskNo);

    /**
     * @Title:
     * @Description:   根据合同号 查询资方抵押合同详细信息
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 10:20:05
     */
    EquMorApplyVo findEquMorApplyVoByContNo(String contNo);

    /**
     * @Title:
     * @Description:   保存海翼申请
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 06:25:59
     */
    void saveEquMorSeaWingApply(EquMorSeaWingApplyVo equMorSeaWingApplyVo);

    /**
     * @Title:
     * @Description:   海翼申请 二次提交
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 03:27:58
     */
    void modifyEquMorSeaWingApply(EquMorSeaWingApplyVo equMorSeaWingApplyVo);

    /**
     * @Title:
     * @Description:   暂存海翼申请
     * @param equMorSeaWingApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 05:49:03
     */
    EquMorApplyVo storageEquMorSeaWingApply(EquMorSeaWingApplyVo equMorSeaWingApplyVo);

    /**
     * @Title:
     * @Description:   查询海翼申请明细
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/11 02:53:02
     */
    EquMorApplyVo findEquMorApplyVoByEquMorTaskNo(String equMorTaskNo);

    /**
     * @Title:
     * @Description:   返回每期租金
     * @param equMorDetailVo 抵押明细
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/04 04:04:08
     */
    BigDecimal findRent(EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:   保存其他资方抵押
     * @param equMorOtherApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 10:10:01
     */
    void saveEquMorOtherApply(EquMorOtherApplyVo equMorOtherApplyVo);

    /**
     * @Title:
     * @Description:   修改其他资方抵押 (二次提交)
     * @param equMorOtherApplyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/05 10:10:01
     */
    void modifyEquMorOtherApply(EquMorOtherApplyVo equMorOtherApplyVo);

    /**
     * @Title:
     * @Description:   退回操作
     * @param EquMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    void equMorApplyReturn(EquMorApplyTaskVo EquMorApplyTaskVo);

    /**
     * @Title:
     * @Description:   通过操作
     * @param equMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    void equMorApplyAgree(EquMorApplyTaskVo equMorApplyTaskVo);

    /**
     * @Title:
     * @Description:   打印海翼申请合同
     * @param equMorTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 01:48:00
     */
    String printEquMorChargeSeaWingApply(String equMorTaskNo);

    /**
     * @Title:
     * @Description:   取消操作
     * @param EquMorApplyTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/09 03:28:07
     */
    void equMorApplyCancel(EquMorApplyTaskVo EquMorApplyTaskVo);

    /**
     * @Title:
     * @Description: 资方抵押付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    String printEquMor(EquMorChargeFinTouchingPrintVo equMorChargeFinTouchingPrintVo);

}
