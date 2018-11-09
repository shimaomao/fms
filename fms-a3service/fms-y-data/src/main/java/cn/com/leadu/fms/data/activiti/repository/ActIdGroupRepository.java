package cn.com.leadu.fms.data.activiti.repository;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActIdGroupRepository
 * @Description: 用户组repository
 * @date 2018/6/19
 */
public interface ActIdGroupRepository {

    /**
     * @Title:
     * @Description: 根据用户查询到用户所在的组id
     * @param user
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    List<String> selectActIdGroupIdsByUser(String user);

}
