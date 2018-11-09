package cn.com.leadu.fms.data.activiti.repository.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.activiti.dao.ActIdMembershipDao;
import cn.com.leadu.fms.data.activiti.repository.ActIdMembershipRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.activiti.entity.ActIdMembership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ActIdMembershipRepositoryImpl
 * @Description: 工作流用户组repository实现类
 * @date 2018/3/12
 */
@Repository
public class ActIdMembershipRepositoryImpl implements ActIdMembershipRepository {

    @Autowired
    private ActIdMembershipDao actIdMembershipDao;

    /**
     * @Title:
     * @Description:   根据条件返回一个实体
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 06:33:43
     */
    public ActIdMembership selectOneByExample(Example example){
        List<ActIdMembership> results = actIdMembershipDao.selectByExample(example);
        if(ArrayUtils.isNotNullAndLengthNotZero(results))
            return results.get(0);
        return null;
    }

    /**
     * @Title:
     * @Description:   根据条件返回列表
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:08:09
     */
    public List<ActIdMembership> selectListByExample(Example example){
        return actIdMembershipDao.selectByExample(example);
    }

    /**
     * @Title:
     * @Description:   根据用户组id返回用户id
     * @param actGroupId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/20 05:26:12
     */
    public List<String> selectActUserIdsByActGroupId(String actGroupId){
        return actIdMembershipDao.selectActUserIdsByActGroupId(actGroupId);
    }

}
