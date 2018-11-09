package cn.com.leadu.fms.pojo.prebiz.vo.crmperson;
/**
 * Created by ningyangyang on 2018/5/25.
 */

import cn.com.leadu.fms.pojo.prebiz.entity.*;
import lombok.Data;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/5/25 16:51
 */
@Data
public class CrmPersonCarrierVo {

    /**
     * @Fields  : 主贷人信息
     * @author ningyangyang
     */
    private CstmPerson cstmPerson;

    /**
     * @Fields  : 主贷人配偶信息
     * @author ningyangyang
     */
    private CstmPersMate cstmPersMate;

    /**
     * @Fields  : 担保人信息
     * @author ningyangyang
     */
    private GuaranteePers guaranteePers;

    /**
     * @Fields  : 主贷人职业信息
     * @author ningyangyang
     */
    private CstmPersJob cstmPersJob;

    /**
     * @Fields  : 主贷人地址信息
     * @author ningyangyang
     */
    private CstmPersAddr cstmPersAddr;

    /**
     * @Fields  : 共同借款人
     * @author ningyangyang
     */
    private CommonBorrower commonBorrower;

    /**
     * @Fields  : 担保人配偶信息
     * @author ningyangyang
     */
    private GuaranteeMate guaranteeMate;
}
