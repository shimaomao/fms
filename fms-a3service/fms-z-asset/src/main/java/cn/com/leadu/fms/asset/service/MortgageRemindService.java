package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import cn.com.leadu.fms.pojo.asset.vo.mortgageremind.MortgageRemindVo;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.MortgageRemindSaveVo;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.MortgageRemindModifyVo;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.MortgageRemindDeleteVo;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.MortgageRemindDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindService
 * @Description: 抵押提醒业务层
 * @date 2018-07-27
 */
public interface MortgageRemindService {

	/**
	 * @Title:
	 * @Description: 分页查询抵押提醒
	 * @param mortgageRemindVo
	 * @return PageInfoExtend<MortgageRemind>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	PageInfoExtend<MortgageRemindVo> findMortgageRemindsByPage(MortgageRemindVo mortgageRemindVo);

	/**
	 * @Title:
	 * @Description: 保存抵押提醒
	 * @param mortgageRemindSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
    void saveMortgageRemind(MortgageRemindSaveVo mortgageRemindSaveVo);


	/**
	 * @Title:
	 * @Description: 修改抵押提醒
	 * @param mortgageRemindModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	void modifyMortgageRemind(MortgageRemindModifyVo mortgageRemindModifyVo);

	/**
	 * @Title:
	 * @Description:  通过morRemindId删除抵押提醒
	 * @param mortgageRemindDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	void deleteMortgageRemind(MortgageRemindDeleteVo mortgageRemindDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过morRemindId集合删除抵押提醒
	 * @param mortgageRemindDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	void deleteMortgageRemindsByMorRemindIds(MortgageRemindDeleteListVo mortgageRemindDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据morRemindId获取抵押提醒
	 * @param morRemindId
	 * @return MortgageRemind
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	MortgageRemind findMortgageRemindByMorRemindId(String morRemindId);

	/**
	 * @Title:
	 * @Description:  根据morRemindId获取抵押提醒
	 * @param morRemindId
	 * @return MortgageRemind
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	MortgageRemindVo selectMortgageRemindVosBymorRemindId(String morRemindId);
}
