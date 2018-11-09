package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasBlacklist;
import cn.com.leadu.fms.pojo.baseinfo.vo.basblacklist.BasBlacklistVo;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.BasBlacklistSaveVo;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.BasBlacklistModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.BasBlacklistDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.BasBlacklistDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistService
 * @Description: 黑名单业务层
 * @date 2018-05-04
 */
public interface BasBlacklistService {

	/**
	 * @Title:
	 * @Description: 分页查询黑名单
	 * @param basBlacklistVo
	 * @return PageInfoExtend<BasBlacklist>
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:29
	 */
	PageInfoExtend<BasBlacklist> findBasBlacklistsByPage(BasBlacklistVo basBlacklistVo);

	/**
	 * @Title:
	 * @Description: 保存黑名单
	 * @param basBlacklistSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:29
	 */
    void saveBasBlacklist(BasBlacklistSaveVo basBlacklistSaveVo);


	/**
	 * @Title:
	 * @Description: 修改黑名单
	 * @param basBlacklistModifyVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:29
	 */
	void modifyBasBlacklist(BasBlacklistModifyVo basBlacklistModifyVo);

	/**
	 * @Title:
	 * @Description:  通过blacklistId删除黑名单
	 * @param basBlacklistDeleteVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:29
	 */
	void deleteBasBlacklist(BasBlacklistDeleteVo basBlacklistDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过blacklistId集合删除黑名单
	 * @param basBlacklistDeleteListVo
	 * @return
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:29
	 */
	void deleteBasBlacklistsByBlacklistIds(BasBlacklistDeleteListVo basBlacklistDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据blacklistId获取黑名单
	 * @param blacklistId
	 * @return BasBlacklist
	 * @throws
	 * @author yangyiquan
	 * @date 2018-5-4 14:06:29
	 */
	BasBlacklist findBasBlacklistByBlacklistId(String blacklistId);

	/**
	 * @Title:
	 * @Description:  根据订单编号，获取该订单中全部的黑名单中的人员
	 * @param basBlacklistVo 参数
	 * @return 数据
	 * @throws
	 * @author wangxue
	 * @date 2018-9-21 14:06:28
	 */
	List<BasBlacklistVo> findBasBlacklistVosByApplyNo(BasBlacklistVo basBlacklistVo);

	/**
	 * @Title:
	 * @Description: 保存订单中全部热人员信息到黑名单中
	 * @param basBlacklistVo 参数
	 * @throws
	 * @author wangxue
	 * @date 2018-9-21 14:06:28
	 */
	void saveBasBlacklistByApplyNo(BasBlacklistVo basBlacklistVo);

}
