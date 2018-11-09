package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import cn.com.leadu.fms.pojo.postbiz.vo.collectionperson.CollectionPersonVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonDao
 * @Description: 催收组员dao层
 */
public interface CollectionPersonDao extends BaseDao<CollectionPerson> {

    /**
     * @Title:
     * @Description: 关联用户表获取用户名称
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    List<CollectionPersonVo> selectCollectionPersonVosByPage(@Param("collectionPersonVo")CollectionPersonVo collectionPersonVo);

}