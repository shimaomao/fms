package cn.com.leadu.fms.pojo.postbiz.vo.collectionperson;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import lombok.Data;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonVo
 * @Description: 催收组员载体
 */
@ExcelTitle(value = "催收组员")

@Data
public class CollectionPersonVo extends PageQuery<CollectionPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 催收人员id

	 * @author qinmuqiao
	 */
	private String collectionPersonId;

	/**
	 * @Fields  : 0-电催，1-上门，2-收车，3-诉讼
	 * @author qinmuqiao
	 */
	private String collectionType;

	/**
	 * @Fields  : 催收人员账号
	 * @author qinmuqiao
	 */
	private String collectionPersonNum;

	/**
	 * @Fields  : 催收人员姓名
	 * @author qinmuqiao
	 */
	private String collectionPersonName;

	/**
	 * @Fields  : 备注
	 * @author qinmuqiao
	 */
	private String remark;

	/**
	 * @Fields  : 启用标识
	 * @author qinmuqiao
	 */
	private String enableFlag;

	/**
	 * @Fields  : 催收人员id

	 * @author qinmuqiao
	 */
	private List<String> collectionPersonIds;


	@ExcelTitle(value = "催收组员账号", sort = 1 ,types = {ExcelTypeConstants.ONE})
	public String getCollectionPersonNum(){return this.collectionPersonNum;}


	@ExcelTitle(value = "催收类型", sort = 2,codeType = CommonCodeTypeConstants.ASSIGNMENT_TYPE, types = {ExcelTypeConstants.ONE})
	public String getCollectionType(){return this.collectionType;}

    @ExcelTitle(value = "启用标识", sort = 3, codeType = CommonCodeTypeConstants.enableFlag)
    public String getEnableFlag() {return this.enableFlag;}


	@ExcelTitle(value = "备注", sort = 4)
	public String getRemark(){return this.remark;}

	@ExcelTitle(value = "更新时间", sort = 5)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 6)
	public String getUpdater(){
		return updater;
	}

}