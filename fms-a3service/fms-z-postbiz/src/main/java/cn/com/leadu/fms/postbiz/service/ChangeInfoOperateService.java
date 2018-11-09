package cn.com.leadu.fms.postbiz.service;/**
 * Created by ningyangyang on 2018/9/10.
 */

import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;

import java.util.List;

/**
 * @Title: fms
 * @Description: 承租人变更信息
 * @author: ningyangyang
 * @date 2018/9/10 16:51
 */
public interface ChangeInfoOperateService {

    /**
     * @Title:
     * @Description: 保存个人的基本信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    void saveCstmPerson(ApplyInputVo applyInputVo, String taskNo);

    /**
     * @Title:
     * @Description: 保存个人的配偶信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    void saveCstmPersMate(ApplyInputVo applyInputVo, String taskNo);

    /**
     * @Title:
     * @Description: 保存个人的职业信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    void saveCstmPersJob(ApplyInputVo applyInputVo, String taskNo);

    /**
     * @Title:
     * @Description: 保存个人的地址信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    void saveCstmPersAddr(ApplyInputVo applyInputVo, String taskNo);

    /**
     * @Title:
     * @Description: 保存企业的基本信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    void saveCstmCompany(ApplyInputVo applyInputVo, String taskNo);

    /**
     * @Title:
     * @Description: 保存企业的股东信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    void saveStockAssetsList(ApplyInputVo applyInputVo, String taskNo);

    /**
     * @Title:
     * @Description:  根据订单编号更新担保人信息
     * @param taskNo
     * @param guaranteePersList
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 14:22:35
     */
    void  updateGuaranteePersByTaskNo(List<GuaranteePers> guaranteePersList, String taskNo);

    /**
     * @Title:
     * @Description:  根据订单编号更新担保公司信息
     * @param taskNo
     * @param guaranteeCompList
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 14:22:35
     */
    void  updateGuaranteeCompsByApplyNo(List<GuaranteeComp> guaranteeCompList, String taskNo);
}
