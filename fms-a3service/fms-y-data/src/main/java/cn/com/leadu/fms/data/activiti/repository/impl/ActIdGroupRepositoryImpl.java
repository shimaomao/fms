package cn.com.leadu.fms.data.activiti.repository.impl;

import cn.com.leadu.fms.data.activiti.dao.ActIdGroupDao;
import cn.com.leadu.fms.data.activiti.repository.ActIdGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActIdGroupRepositoryImpl
 * @Description: 用户组repository实现类
 * @date 2018/6/19
 */
@Repository
public class ActIdGroupRepositoryImpl implements ActIdGroupRepository {

    @Autowired
    private ActIdGroupDao actIdGroupDao;

    /**
     * @Title:
     * @Description: 根据用户查询到用户所在的组id
     * @param user
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    public List<String> selectActIdGroupIdsByUser(String user){
        return actIdGroupDao.selectActIdGroupIdsByUser(user);
    }

}


