package cn.com.leadu.fms.business.service;/**
 * Created by ningyangyang on 2018/11/8.
 */

import java.util.List;

/**
 * @Title: fms
 * @Description: 通过机构代码获取当前机构用户以及子机构用户
 * @author: ningyangyang
 * @date 2018/11/8 9:53
 */
public interface CommonSysGroupService {

    /**
     * @Description: 获取子机构的所有用户
     * @param groupCode
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/10/7 17:04
     */
     List<String> getUserInSameGroup(String groupCode);
}
