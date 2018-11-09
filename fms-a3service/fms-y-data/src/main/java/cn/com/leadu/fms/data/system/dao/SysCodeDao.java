package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeDao
 * @Description: 字典数数值dao层
 * @date 2018-03-09
 */
public interface SysCodeDao extends BaseDao<SysCode> {

    /** 
    * @Description: 分页查询字典值（关联字典类型表） 
    * @Param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/4/27 14:28
    */  
    List<SysCodeVo> selectSysCodesWithTypeNameByPage(@Param("sysCodeVo")SysCodeVo sysCodeVo);

    SysCodeVo selectSysCodeVoById(@Param("codeValueId")String codeValueId);
}