package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: CarCollectComp
 * @Description: 收车机构维护实体
 * @date 2018-05-22
 */
@ExcelTitle(value = "收车机构信息")
@Data
public class CarCollectComp extends BaseEntity<CarCollectComp> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 收车机构ID
	 * @author yanfengbo
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String carCollectCompId;

	/**
	 * @Fields  : 收车机构代码
	 * @author yanfengbo
	 */
	private String carCollectCompCode;

	/**
	 * @Fields  : 收车机构名称
	 * @author yanfengbo
	 */
	private String carCollectCompName;

	/**
	 * @Fields  : 联系电话
	 * @author yanfengbo
	 */
	private String contactTel;

	/**
	 * @Fields  : 联系地址
	 * @author yanfengbo
	 */
	private String address;

	/**
	 * @Fields  : 邮箱
	 * @author yanfengbo
	 */
	private String mailAddress;

	/**
	 * @Fields  : 所在省份
	 * @author yanfengbo
	 */
	private String addrProv;

	/**
	 * @Fields  : 所在城市
	 * @author yanfengbo
	 */
	private String addrCity;

	@ExcelTitle(value = "收车机构代码", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getCarCollectCompCode(){
		return this.carCollectCompCode;
	}

	@ExcelTitle(value = "收车机构名称", sort = 2)
	public String getCarCollectCompName(){
		return this.carCollectCompName;
	}

	@ExcelTitle(value = "联系电话", sort = 3)
	public String getContactTel(){
		return this.contactTel;
	}

	@ExcelTitle(value = "联系地址", sort = 4)
	public String getAddress(){
		return address;
	}

	@ExcelTitle(value = "邮箱", sort = 5)
	public String getMailAddress(){
		return this.mailAddress;
	}

	@ExcelTitle(value = "所在省份", sort = 6, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getAddrProv(){
		return addrProv;
	}

	@ExcelTitle(value = "所在城市", sort = 7, areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getAddrCity(){
		return this.addrCity;
	}

	@ExcelTitle(value = "更新时间", sort = 8)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 9)
	public String getUpdater(){
		return updater;
	}

}