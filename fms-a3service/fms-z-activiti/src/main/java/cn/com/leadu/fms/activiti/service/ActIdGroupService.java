package cn.com.leadu.fms.activiti.service;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActIdGroupService
 * @Description:
 * @date 2018/6/19
 */
public interface ActIdGroupService {

    /**
     * @Title:
     * @Description: 根据用户查询到用户所在的组id
     * @param user
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    List<String> findActIdGroupIdsByUser(String user);

}
