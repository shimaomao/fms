package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupDao
 * @Description: 附件组dao层
 */
public interface BasFileGroupDao extends BaseDao<BasFileGroup> {

    /**
     * @Title:
     * @Description:  查询附件类型下一级子类附件
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-30 22:06:58
     */
    List<BasFileTypeVo> selectBasFileTypeChiByFileType(@Param("fileType")String fileType);

}