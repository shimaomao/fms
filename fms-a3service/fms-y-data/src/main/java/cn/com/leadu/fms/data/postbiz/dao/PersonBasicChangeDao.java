package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.PersonBasicChange;
import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangeVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeDao
 * @Description: 个人基本信息变更表dao层
 * @date 2018-08-31
 */
public interface PersonBasicChangeDao extends BaseDao<PersonBasicChange> {

    /**
     * 获取个人基本信息
     * @param applyNo
     * @return
     */
    PersonBasicChangeVo selectPersonBasicChangeByApplyNo(@Param("applyNo") String applyNo);
}