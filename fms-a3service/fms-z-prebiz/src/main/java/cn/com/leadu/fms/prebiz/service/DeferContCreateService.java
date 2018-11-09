package cn.com.leadu.fms.prebiz.service;/**
 * Created by ningyangyang on 2018/10/31.
 */

import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @Title: fms
 * @Description: 合同展期合同生成
 * @author: ningyangyang
 * @date 2018/10/31 9:48
 */
public interface DeferContCreateService {

    /**
     * @Title:
     * @Description:  根据contNo获取展期合同的当前合同信息
     * @param deferTaskVo
     * @return DeferTaskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    DeferTaskVo findDeferTaskVoByContNo(DeferTaskVo deferTaskVo);

    /**
     * @Title:
     * @Description: 展期合同生成
     * @param deferTaskVo 展期实体Vo
     * @param  sysUser 当前登陆用户信息
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    void generateDeferContract(DeferTaskVo deferTaskVo, SysUser sysUser);
}
