package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeDao
 * @Description: 附件类型管理表dao层
 * @date 2018-03-19
 */
public interface BasFileTypeDao extends BaseDao<BasFileType> {

    /**
     * @Title:
     * @Description:  查询附件类型管理树
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    List<BasFileTypeVo> selectBasFileTypeByTree();

    /**
     * @Title:
     * @Description:  通过一个上级类型代码查询旗下所有层级节点的上级类型代码
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    List<BasFileTypeVo> selectAllNodesFromBasFileType(@Param("parentFileType")String parentFileType);

    /**
     * @Title:
     * @Description:  通过上级类型代码获得下一级子节点集合
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    List<BasFileTypeVo> selectNextBasFileTypeVosByParentFileType(@Param("parentFileType")String parentFileType);

    /**
     * @Title:
     * @Description:  根据fileTypeId获取BasFileTypeVo
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    BasFileTypeVo selectBasFileTypeVoByPrimaryKey(@Param("fileTypeId")String fileTypeId);

    /**
     * @Title:
     * @Description:  根据产品代码取得获取BasFileTypeVo
     * @param product 产品代码
     * @return
     * @throws
     * @author wangxue
     * @date 2018-4-26 22:06:58
     */
    List<BasFileTypeVo> selectBasFileTypeVoByProduct(@Param("product")String product);

    /**
     * @Title:
     * @Description:  取得获取所有BasFileType，并按照orderno进行排序
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-26 22:06:58
     */
    List<BasFileType> selectAllBasFileTypeList();

}