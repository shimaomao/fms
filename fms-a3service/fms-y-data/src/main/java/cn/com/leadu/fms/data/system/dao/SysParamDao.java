package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.common.vo.CommonParamVo;
import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysParam;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: SysParamDao
 * @Description: 系统常量表dao层
 * @date 2018-03-09
 */
public interface SysParamDao extends BaseDao<SysParam> {

    /**
     * @Title:
     * @Description:   查询所有系统常量,用于前后台系统常量取得
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 09:07:08
     */
    List<CommonParamVo> selectSysParams();

}