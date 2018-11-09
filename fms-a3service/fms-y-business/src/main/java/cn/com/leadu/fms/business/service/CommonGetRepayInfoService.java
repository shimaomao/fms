package cn.com.leadu.fms.business.service;/**
 * Created by ningyangyang on 2018/9/3.
 */

import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedAlreadyPayInfoVo;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/9/3 9:48
 */
public interface CommonGetRepayInfoService {

    /**
     * @Title:
     * @Description:  查看还款计划表已还金额和期数
     * @param contNo
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 16:12:19
     */
    ContRepaySkedAlreadyPayInfoVo commonGetRepayInfo(String contNo);
}
