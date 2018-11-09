package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContDeleteListVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContSaveVo;

/**
 * @author lijunjun
 * @ClassName: OverdueContService
 * @Description: 逾期合同信息业务层
 * @date 2018-05-16
 */
public interface OverdueContService {

	/**
	 * @Title:
	 * @Description: 分页查询逾期合同信息
	 * @param overdueContVo
	 * @return PageInfoExtend<OverdueCont>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	PageInfoExtend<OverdueContVo> findOverdueContsByPage(OverdueContVo overdueContVo);

	/**
	 * @Title:
	 * @Description: 保存逾期合同信息
	 * @param overdueContSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
    void saveOverdueCont(OverdueContSaveVo overdueContSaveVo);


	/**
	 * @Title:
	 * @Description: 修改逾期合同信息
	 * @param overdueContModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	void modifyOverdueCont(OverdueContModifyVo overdueContModifyVo);

	/**
	 * @Title:
	 * @Description:  通过overdueContId删除逾期合同信息
	 * @param overdueContDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	void deleteOverdueCont(OverdueContDeleteVo overdueContDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过overdueContId集合删除逾期合同信息
	 * @param overdueContDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	void deleteOverdueContsByOverdueContIds(OverdueContDeleteListVo overdueContDeleteListVo);

	/**
	 * @param contNo
	 * @return
	 * @throws
	 * @Title:
	 * @Description: 通过contNo取得逾期合同信息
	 * @author yanfengbo
	 * @date 2018-5-16 14:32:22
	 */
    OverdueContVo findOverdueContByContNo(String contNo);

	/**
	 * @Title:
	 * @Description:
	 * @param overdueContVo 分页查询逾期合同vo数据
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/14 05:45:06
	 */
	PageInfoExtend<OverdueContVo> findOverdueContVosByPage(OverdueContVo overdueContVo);

	/**
	 * @Title:
	 * @Description:   根据合同号获取逾期合同号
	 * @param contNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/17 04:14:21
	 */
	OverdueContVo findOverdueContVoByContNo(String contNo);

}
