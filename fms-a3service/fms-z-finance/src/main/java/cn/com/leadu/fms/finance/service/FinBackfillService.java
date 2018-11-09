package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.FinBackfillSaveVo;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.FinBackfillModifyVo;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.FinBackfillDeleteVo;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.FinBackfillDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVoExcel;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinBackfillService
 * @Description: 融资回填业务层
 * @date 2018-05-11
 */
public interface FinBackfillService {

	/**
	 * @Title:
	 * @Description: 分页查询融资回填
	 * @param finBackfillVo
	 * @return PageInfoExtend<FinBackfillVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	PageInfoExtend<FinBackfillVo> findFinBackfillsByPage(FinBackfillVo finBackfillVo);

	/**
	 * @Title:
	 * @Description: 保存融资回填
	 * @param finBackfillSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
    void saveFinBackfill(FinBackfillSaveVo finBackfillSaveVo);


	/**
	 * @Title:
	 * @Description: 修改融资回填
	 * @param finBackfillModifyVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	void modifyFinBackfill(FinBackfillModifyVo finBackfillModifyVo);

	/**
	 * @Title:
	 * @Description:  通过filBackfillId删除融资回填
	 * @param finBackfillDeleteVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	void deleteFinBackfill(FinBackfillDeleteVo finBackfillDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过filBackfillId集合删除融资回填
	 * @param finBackfillDeleteListVo
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	void deleteFinBackfillsByFilBackfillIds(FinBackfillDeleteListVo finBackfillDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据filBackfillId获取融资回填
	 * @param filBackfillId
	 * @return FinBackfillVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	FinBackfillVo findFinBackfillByFilBackfillId(String filBackfillId);

	/**
	 * @Title:
	 * @Description:  财务回填
	 * @param finBackfillVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	void finBackfill(FinBackfillVo finBackfillVo);

	/**
	 * @Title:
	 * @Description: 导出财务回填excel
	 * @param finBackfillVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 */
	PageInfoExtend<FinBackfillVoExcel> findFinBackfillsForExportExcel(FinBackfillVo finBackfillVo);

}
