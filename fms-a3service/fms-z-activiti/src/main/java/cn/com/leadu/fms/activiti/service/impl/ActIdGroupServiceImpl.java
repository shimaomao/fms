package cn.com.leadu.fms.activiti.service.impl;

import cn.com.leadu.fms.activiti.service.ActIdGroupService;
import cn.com.leadu.fms.data.activiti.repository.ActIdGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActIdGroupServiceImpl
 * @Description:
 * @date 2018/6/19
 */
@Service
public class ActIdGroupServiceImpl implements ActIdGroupService {

    @Autowired
    private ActIdGroupRepository actIdGroupRepository;

    /**
     * @Title:
     * @Description: 根据用户查询到用户所在的组id
     * @param user
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    public List<String> findActIdGroupIdsByUser(String user){
        return actIdGroupRepository.selectActIdGroupIdsByUser(user);
    }

}
