package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfilegroup.BasFileGroupVo;
import cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo.BasFileGroupSaveVo;
import cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo.BasFileGroupModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo.BasFileGroupDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo.BasFileGroupDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupService
 * @Description: 附件组业务层
 */
public interface BasFileGroupService {

	/**
	 * @Title:
	 * @Description: 分页查询附件组
	 * @param basFileGroupVo
	 * @return PageInfoExtend<BasFileGroup>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	PageInfoExtend<BasFileGroup> findBasFileGroupsByPage(BasFileGroupVo basFileGroupVo);

	/**
	 * @Title:
	 * @Description: 保存附件组
	 * @param basFileGroupSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
    void saveBasFileGroup(BasFileGroupSaveVo basFileGroupSaveVo);


	/**
	 * @Title:
	 * @Description: 修改附件组
	 * @param basFileGroupModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	void modifyBasFileGroup(BasFileGroupModifyVo basFileGroupModifyVo);

	/**
	 * @Title:
	 * @Description:  通过basFileGroupId删除附件组
	 * @param basFileGroupDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	void deleteBasFileGroup(BasFileGroupDeleteVo basFileGroupDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过basFileGroupId集合删除附件组
	 * @param basFileGroupDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	void deleteBasFileGroupsByBasFileGroupIds(BasFileGroupDeleteListVo basFileGroupDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据basFileGroupId获取附件组
	 * @param basFileGroupId
	 * @return BasFileGroup
	 * @throws
	 * @author ningyangyang
	 * @date 2018-10-29 10:03:27
	 */
	BasFileGroup findBasFileGroupByBasFileGroupId(String basFileGroupId);

}
