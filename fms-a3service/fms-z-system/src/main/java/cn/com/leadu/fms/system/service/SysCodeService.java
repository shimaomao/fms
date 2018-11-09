package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.common.vo.CommonCodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeDeleteListVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeDeleteVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeModifyVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeSaveVo;

import java.util.List;
import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: SysCodeService
 * @Description: 字典数数值业务层
 * @date 2018-03-09
 */
public interface SysCodeService {

	/**
	 * @Title:
	 * @Description: 保存字典数数值
	 * @param sysCodeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:54
	 */
	Map<String,Object> saveSysCode(SysCodeSaveVo sysCodeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改字典数数值
	 * @param sysCodeModifyVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:54
	 */
	Map<String,Object> modifySysCode(SysCodeModifyVo sysCodeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过codeValueId删除字典数数值
	 * @param sysCodeDeleteVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:54
	 */
	Map<String,Object> deleteSysCode(SysCodeDeleteVo sysCodeDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过codeValueId集合删除字典数数值
	 * @param sysCodeDeleteListVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:54
	 */
	Map<String,Object> deleteSysCodeByCodeValueIds(SysCodeDeleteListVo sysCodeDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据codeValueId获取字典数数值
	 * @param codeValueId
	 * @return SysCode
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:54
	 */
	SysCodeVo findSysCodeByCodeValueId(String codeValueId);
	/**
	 * @Title:
	 * @Description:  根据codeValue和codeType查询
	 * @param sysCodeVo
	 * @return SysCode
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:54
	 */
	SysCode findSysCodeByCodeValue(SysCodeVo sysCodeVo);

	/**
	 * @Title:
	 * @Description: 分页查询字典数数值
	 * @param sysCodeVo
	 * @return PageInfoExtend<SysCode>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:54
	 */
	PageInfoExtend<SysCode> findSysCodesByPage(SysCodeVo sysCodeVo);


	/**
	* @Description: 分页查询字典值（关联字典类型表）
	* @Param:
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/4/27 14:19
	*/ 
	PageInfoExtend<SysCodeVo> findSysCodesWithTypeNameByPage(SysCodeVo sysCodeVo);

	/**
	 * @Title:
	 * @Description: 查询所有数据字典与值,并按照顺序排序
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/27 02:09:55
	 */
	List<SysCode> findSysCodesByAll();

	/**
	 * @Title:
	 * @Description: 通过数据字典类型查询对应数据字典集合
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/27 02:09:55
	 */
	List<SysCode> findSysCodesByCodeType(String codeType);

	/**
	 * @Title:
	 * @Description:   根据codeTypes删除数据字典
	 * @param codeTypes
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/04/03 01:26:07
	 */
	int deleteSysCodesByCodeTypes(List<String> codeTypes);

	/**
	 * @Title:
	 * @Description:  刷新字典缓存
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/04/03 12:56:59
	 */
	Map<String,Object> initCommonCodeValue();

	/**
	 * @Title:
	 * @Description:   获取code版本
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/27 04:09:38
	 */
	Integer getCommonCodeValueVersion();

	/**
	 * @Title:
	 * @Description:   获取所有的值
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/27 04:13:52
	 */
	Map<String,Object> getCommonCodeValuesAll();

	/**
	 * @Title:
	 * @Description:   获取所有的数据字典,key以codeType_codeValue拼接
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/27 03:52:54
	 */
	Map<String,CommonCodeVo> getCommonCodeValues();

	/**
	 * @Title:
	 * @Description:   获取所有的数据字典,key为codeType,值为该codeType下的集合
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/27 03:53:30
	 */
	Map<String,List<CommonCodeVo>> getCommonCodeValuesTree();

}
