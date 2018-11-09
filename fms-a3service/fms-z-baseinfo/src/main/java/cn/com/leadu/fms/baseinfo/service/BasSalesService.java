package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.BasSalesSaveVo;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.BasSalesModifyVo;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.BasSalesDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.BasSalesDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author yanfengbo
 * @ClassName: BasSalesService
 * @Description: 实际销售方业务层
 * @date 2018-05-03
 */
public interface BasSalesService {

	/**
	 * @Title:
	 * @Description: 分页查询实际销售方
	 * @param basSalesVo
	 * @return PageInfoExtend<BasSales>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	PageInfoExtend<BasSalesVo> findBasSalessByPage(BasSalesVo basSalesVo);

	/**
	 * @Title:
	 * @Description: 保存实际销售方
	 * @param basSalesSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
    void saveBasSales(BasSalesSaveVo basSalesSaveVo,SysUser sysUser);


	/**
	 * @Title:
	 * @Description: 修改实际销售方
	 * @param basSalesModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	void modifyBasSales(BasSalesModifyVo basSalesModifyVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description:  通过salesId删除实际销售方
	 * @param basSalesDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	void deleteBasSales(BasSalesDeleteVo basSalesDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过salesId集合删除实际销售方
	 * @param basSalesDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	void deleteBasSalessBySalesIds(BasSalesDeleteListVo basSalesDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据salesId获取实际销售方
	 * @param salesId
	 * @return BasSales
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	BasSalesVo findBasSalesBySalesId(String salesId,String serviceId);

	/**
	 * @Title:
	 * @Description: 实际销售方审核通过
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public void approval(BasSalesVo basSalesVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 实际销售方审核退回
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public void sendBack(BasSalesVo basSalesVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 根据salesCode获取实际销售方
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	BasSales findBasSalesBySalesCode(String salesCode);

}
