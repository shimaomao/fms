package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.OverdueCstmTelSaveVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.OverdueCstmTelModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.OverdueCstmTelDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.OverdueCstmTelDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmTelService
 * @Description: 逾期客户电话信息业务层
 * @date 2018-05-17
 */
public interface OverdueCstmTelService {

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户电话信息
	 * @param overdueCstmTelVo
	 * @return PageInfoExtend<OverdueCstmTel>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	PageInfoExtend<OverdueCstmTel> findOverdueCstmTelsByPage(OverdueCstmTelVo overdueCstmTelVo);

	/**
	 * @Title:
	 * @Description: 保存逾期客户电话信息
	 * @param overdueCstmTelSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
    void saveOverdueCstmTel(OverdueCstmTelSaveVo overdueCstmTelSaveVo);


	/**
	 * @Title:
	 * @Description: 修改逾期客户电话信息
	 * @param overdueCstmTelModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	void modifyOverdueCstmTel(OverdueCstmTelModifyVo overdueCstmTelModifyVo);

	/**
	 * @Title:
	 * @Description:  通过overdueCstmTelId删除逾期客户电话信息
	 * @param overdueCstmTelDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	void deleteOverdueCstmTel(OverdueCstmTelDeleteVo overdueCstmTelDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过overdueCstmTelId集合删除逾期客户电话信息
	 * @param overdueCstmTelDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	void deleteOverdueCstmTelsByOverdueCstmTelIds(OverdueCstmTelDeleteListVo overdueCstmTelDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据overdueCstmTelId获取逾期客户电话信息
	 * @param overdueCstmTelId
	 * @return OverdueCstmTel
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	OverdueCstmTel findOverdueCstmTelByOverdueCstmTelId(String overdueCstmTelId);

}
