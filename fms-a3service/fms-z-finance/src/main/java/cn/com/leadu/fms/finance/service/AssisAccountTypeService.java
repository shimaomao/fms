package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.AssisAccountTypeSaveVo;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.AssisAccountTypeModifyVo;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.AssisAccountTypeDeleteVo;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.AssisAccountTypeDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeService
 * @Description: 辅助核算类型管理业务层
 * @date 2018-06-23
 */
public interface AssisAccountTypeService {

	/**
	 * @Title:
	 * @Description: 分页查询辅助核算类型管理
	 * @param assisAccountTypeVo
	 * @return PageInfoExtend<AssisAccountType>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	PageInfoExtend<AssisAccountType> findAssisAccountTypesByPage(AssisAccountTypeVo assisAccountTypeVo);

	/**
	 * @Title:
	 * @Description: 保存辅助核算类型管理
	 * @param assisAccountTypeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
    void saveAssisAccountType(AssisAccountTypeSaveVo assisAccountTypeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改辅助核算类型管理
	 * @param assisAccountTypeModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	void modifyAssisAccountType(AssisAccountTypeModifyVo assisAccountTypeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过assisAccountTypeId删除辅助核算类型管理
	 * @param assisAccountTypeDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	void deleteAssisAccountType(AssisAccountTypeDeleteVo assisAccountTypeDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过assisAccountTypeId集合删除辅助核算类型管理
	 * @param assisAccountTypeDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	void deleteAssisAccountTypesByAssisAccountTypeIds(AssisAccountTypeDeleteListVo assisAccountTypeDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据assisAccountTypeId获取辅助核算类型管理
	 * @param assisAccountTypeId
	 * @return AssisAccountType
	 * @throws
	 * @author ningyangyang
	 * @date 2018-6-23 13:46:17
	 */
	AssisAccountType findAssisAccountTypeByAssisAccountTypeId(String assisAccountTypeId);

	/**
	 * @Title:
	 * @Description:   根据types集合获取辅助核算类型管理
	 * @param assisAccountTypes
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/26 10:49:32
	 */
	List<AssisAccountType> findAssisAccountTypesByAccTypes(List<String> assisAccountTypes);

	/**
	 * @Title:
	 * @Description: 分页查询辅助核算类型管理信息弹出框
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	PageInfoExtend<AssisAccountTypeVo> findAssisAccountTypesByPage2(AssisAccountTypeVo assisAccountTypeVo);

}
