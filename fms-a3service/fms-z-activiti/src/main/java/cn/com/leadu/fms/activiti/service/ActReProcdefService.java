package cn.com.leadu.fms.activiti.service;

import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.activiti.vo.actreprocdef.ActReProcdefVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActReProcdefService
 * @Description: 流程定义service
 * @date 2018/3/13
 */
public interface ActReProcdefService {

    /**
     * @Title:
     * @Description:   分页查询流程定义vos
     * @param actReProcdefVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/13 05:00:50
     */
    PageInfoExtend<ActReProcdefVo> findActReProcdefVosByPage(ActReProcdefVo actReProcdefVo);

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:18:12
     */
    List<ActReProcdefVo> findActReProcdefVosByUserOrGroup(SysUser sysUser);

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型，并得到树形
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/12 11:15:14
     */
    List<BootstrapTreeViewNodeVo> findProcdefTree(SysUser sysUser);

}
