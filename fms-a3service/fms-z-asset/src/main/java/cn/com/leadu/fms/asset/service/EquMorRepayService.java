package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.asset.validator.equmorrepay.vo.EquMorRepayDeleteListVo;
import cn.com.leadu.fms.asset.validator.equmorrepay.vo.EquMorRepayDeleteVo;
import cn.com.leadu.fms.asset.validator.equmorrepay.vo.EquMorRepayModifyVo;
import cn.com.leadu.fms.asset.validator.equmorrepay.vo.EquMorRepaySaveVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepay.EquMorRepayVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorRepayService
 * @Description: 资方抵押还款计划业务层
 * @date 2018-05-30
 */
public interface EquMorRepayService {

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押还款计划
	 * @param equMorRepayVo
	 * @return PageInfoExtend<EquMorRepay>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:36
	 */
	PageInfoExtend<EquMorRepay> findEquMorRepaysByPage(EquMorRepayVo equMorRepayVo);

	/**
	 * @Title:
	 * @Description: 保存资方抵押还款计划
	 * @param equMorRepaySaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:36
	 */
    void saveEquMorRepay(EquMorRepaySaveVo equMorRepaySaveVo);


	/**
	 * @Title:
	 * @Description: 修改资方抵押还款计划
	 * @param equMorRepayModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:36
	 */
	void modifyEquMorRepay(EquMorRepayModifyVo equMorRepayModifyVo);

	/**
	 * @Title:
	 * @Description:  通过equMorRepayId删除资方抵押还款计划
	 * @param equMorRepayDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:36
	 */
	void deleteEquMorRepay(EquMorRepayDeleteVo equMorRepayDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过equMorRepayId集合删除资方抵押还款计划
	 * @param equMorRepayDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:36
	 */
	void deleteEquMorRepaysByEquMorRepayIds(EquMorRepayDeleteListVo equMorRepayDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据equMorRepayId获取资方抵押还款计划
	 * @param equMorRepayId
	 * @return EquMorRepay
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:36
	 */
	EquMorRepay findEquMorRepayByEquMorRepayId(String equMorRepayId);

	/**
	 * @Fields  : 解析还款计划excel
	 * @author qiaomengnan
	 */
	List<EquMorRepayVo> parseEquMorRepayVoExcel(String filePath);

	/**
	 * @Title:
	 * @Description:   还款计划表下载
	 * @param httpServletResponse
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/25 03:23:28
	 */
	void downloadEquMorRepayExcelTemplate(HttpServletResponse httpServletResponse);

	/**
	 * @Title:
	 * @Description:   保存还款计划集合
	 * @param equMorRepays
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/06 04:00:31
	 */
	void saveEquMorRepay(List<EquMorRepay> equMorRepays);

	/**
	 * @Title:
	 * @Description:   根据抵押任务号查询还款计划
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/11 04:07:04
	 */
	List<EquMorRepay> findEquMorRepayByEquMorTaskNo(String equMorTaskNo);

	/**
	 * @Title:
	 * @Description:   根据抵押任务号删除还款计划
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/11 04:48:30
	 */
	void deleteEquMorRepayByEquMorTaskNo(String equMorTaskNo);


}
