package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liujinge
 * @ClassName: WlTemp02
 * @Description: 数据迁移实体
 * @date 2018-08-04
 */
@Data
public class WlTemp02 extends BaseEntity<WlTemp02> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 序号
	 * @author liujinge
	 */
	private String columnk1;

	/**
	 * @Fields  : 注册登记日
	 * @author liujinge
	 */
	private String column102;

	/**
	 * @Fields  : 是否年检
	 * @author liujinge
	 */
	private String column103;

	/**
	 * @Fields  : 钥匙
	 * @author liujinge
	 */
	private String column104;

	/**
	 * @Fields  : 是否归档
	 * @author liujinge
	 */
	private String column105;

	/**
	 * @Fields  : 路桥费融资额
	 * @author liujinge
	 */
	private String column106;

	/**
	 * @Fields  : 路桥进度
	 * @author liujinge
	 */
	private String column107;

	/**
	 * @Fields  : 已缴年度
	 * @author liujinge
	 */
	private String column108;

	/**
	 * @Fields  : 租赁期限
	 * @author liujinge
	 */
	private String column109;

	/**
	 * @Fields  : 应缴年度
	 * @author liujinge
	 */
	private String column110;

	/**
	 * @Fields  : 首年路桥费
	 * @author liujinge
	 */
	private String column111;

	/**
	 * @Fields  : 第2年路桥费
	 * @author liujinge
	 */
	private String column112;

	/**
	 * @Fields  : 第3年路桥费
	 * @author liujinge
	 */
	private String column113;

	/**
	 * @Fields  : 滞纳金
	 * @author liujinge
	 */
	private String column114;

	/**
	 * @Fields  : GPS厂商
	 * @author liujinge
	 */
	private String column115;

	/**
	 * @Fields  : GPS安装时间
	 * @author liujinge
	 */
	private String column116;

	/**
	 * @Fields  : 有线数量
	 * @author liujinge
	 */
	private String column117;

	/**
	 * @Fields  : 无线数量
	 * @author liujinge
	 */
	private String column118;

	/**
	 * @Fields  : 有线型号
	 * @author liujinge
	 */
	private String column119;

	/**
	 * @Fields  : 断油电
	 * @author liujinge
	 */
	private String column120;

	/**
	 * @Fields  : GPS费用
	 * @author liujinge
	 */
	private String column121;

	/**
	 * @Fields  : GPS续费
	 * @author liujinge
	 */
	private String column122;

	/**
	 * @Fields  : 第1年保险报价
	 * @author liujinge
	 */
	private String column123;

	/**
	 * @Fields  : 第1年保险实付
	 * @author liujinge
	 */
	private String column124;

	/**
	 * @Fields  : 第1年商业险
	 * @author liujinge
	 */
	private String column125;

	/**
	 * @Fields  : 第1年交强险
	 * @author liujinge
	 */
	private String column126;

	/**
	 * @Fields  : 第1年车船税
	 * @author liujinge
	 */
	private String column127;

	/**
	 * @Fields  : 第1年gps盗抢
	 * @author liujinge
	 */
	private String column128;

	/**
	 * @Fields  : 1年盗抢赠送
	 * @author liujinge
	 */
	private String column129;

	/**
	 * @Fields  : 第1年盗抢公司
	 * @author liujinge
	 */
	private String column130;

	/**
	 * @Fields  : 是否购买VPS盗抢险
	 * @author liujinge
	 */
	private String column131;

	/**
	 * @Fields  : 第1年车上人员险
	 * @author liujinge
	 */
	private String column132;

	/**
	 * @Fields  : 第1年福州中宝特惠险
	 * @author liujinge
	 */
	private String column133;

	/**
	 * @Fields  : 第1年漳州玻璃
	 * @author liujinge
	 */
	private String column134;

	/**
	 * @Fields  : 第1年返利
	 * @author liujinge
	 */
	private String column135;

	/**
	 * @Fields  : 第1年客户补缴
	 * @author liujinge
	 */
	private String column136;

	/**
	 * @Fields  : 第1年保险公司
	 * @author liujinge
	 */
	private String column137;

	/**
	 * @Fields  : 第1年终保日期
	 * @author liujinge
	 */
	private String column138;

	/**
	 * @Fields  : 2年续保日期
	 * @author liujinge
	 */
	private String column139;

	/**
	 * @Fields  : 出险次数
	 * @author liujinge
	 */
	private String column140;

	/**
	 * @Fields  : 出险金额
	 * @author liujinge
	 */
	private String column141;

	/**
	 * @Fields  : 第2年保险公司
	 * @author liujinge
	 */
	private String column142;

	/**
	 * @Fields  : 2年保单是否归档
	 * @author liujinge
	 */
	private String column143;

	/**
	 * @Fields  : 2年报价
	 * @author liujinge
	 */
	private String column144;

	/**
	 * @Fields  : 2年保费
	 * @author liujinge
	 */
	private String column145;

	/**
	 * @Fields  : 2年商业
	 * @author liujinge
	 */
	private String column146;

	/**
	 * @Fields  : 2年强险
	 * @author liujinge
	 */
	private String column147;

	/**
	 * @Fields  : 2年车船税
	 * @author liujinge
	 */
	private String column148;

	/**
	 * @Fields  : 2年gps盗抢
	 * @author liujinge
	 */
	private String column149;

	/**
	 * @Fields  : gps盗抢赠送
	 * @author liujinge
	 */
	private String column150;

	/**
	 * @Fields  : 2年盗抢公司
	 * @author liujinge
	 */
	private String column151;

	/**
	 * @Fields  : 2年车上人员
	 * @author liujinge
	 */
	private String column152;

	/**
	 * @Fields  : 2年中宝特惠
	 * @author liujinge
	 */
	private String column153;

	/**
	 * @Fields  : 2年漳州玻璃
	 * @author liujinge
	 */
	private String column154;

	/**
	 * @Fields  : 2年返利
	 * @author liujinge
	 */
	private String column155;

	/**
	 * @Fields  : 2年客户补缴
	 * @author liujinge
	 */
	private String column156;

	/**
	 * @Fields  : 是否结算
	 * @author liujinge
	 */
	private String column157;

	/**
	 * @Fields  : 返利到账时间
	 * @author liujinge
	 */
	private String column158;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	private String column159;

	/**
	 * @Fields  : 第2年终保日期
	 * @author liujinge
	 */
	private String column160;

	/**
	 * @Fields  : 3年续保日期
	 * @author liujinge
	 */
	private String column161;

	/**
	 * @Fields  : 出险次数
	 * @author liujinge
	 */
	private String column162;

	/**
	 * @Fields  : 出险金额
	 * @author liujinge
	 */
	private String column163;

	/**
	 * @Fields  : 第3年保险公司
	 * @author liujinge
	 */
	private String column164;

	/**
	 * @Fields  : 3年保单是否归档
	 * @author liujinge
	 */
	private String column165;

	/**
	 * @Fields  : 3年报价
	 * @author liujinge
	 */
	private String column166;

	/**
	 * @Fields  : 3年保费
	 * @author liujinge
	 */
	private String column167;

	/**
	 * @Fields  : 3年商业
	 * @author liujinge
	 */
	private String column168;

	/**
	 * @Fields  : 3年交强
	 * @author liujinge
	 */
	private String column169;

	/**
	 * @Fields  : 3年车船
	 * @author liujinge
	 */
	private String column170;

	/**
	 * @Fields  : 第3年gps盗抢
	 * @author liujinge
	 */
	private String column171;

	/**
	 * @Fields  : GPS盗抢险公司
	 * @author liujinge
	 */
	private String column172;

	/**
	 * @Fields  : 3年盗抢赠送
	 * @author liujinge
	 */
	private String column173;

	/**
	 * @Fields  : 第3年车上人员
	 * @author liujinge
	 */
	private String column174;

	/**
	 * @Fields  : 第3年中宝特惠
	 * @author liujinge
	 */
	private String column175;

	/**
	 * @Fields  : 第3年漳州玻璃
	 * @author liujinge
	 */
	private String column176;

	/**
	 * @Fields  : 第3年返利
	 * @author liujinge
	 */
	private String column177;

	/**
	 * @Fields  : 3年客户补缴
	 * @author liujinge
	 */
	private String column178;

	/**
	 * @Fields  : 是否结算
	 * @author liujinge
	 */
	private String column179;

	/**
	 * @Fields  : 返利到账时间
	 * @author liujinge
	 */
	private String column180;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	private String column181;

	/**
	 * @Fields  : 保险已退客户
	 * @author liujinge
	 */
	private String column182;

	/**
	 * @Fields  : 客户保险补缴合计
	 * @author liujinge
	 */
	private String column183;

	/**
	 * @Fields  : 第3年终保日期
	 * @author liujinge
	 */
	private String column184;

	/**
	 * @Fields  : 4年续保日期
	 * @author liujinge
	 */
	private String column185;

	/**
	 * @Fields  : 出险次数
	 * @author liujinge
	 */
	private String column186;

	/**
	 * @Fields  : 出险金额
	 * @author liujinge
	 */
	private String column187;

	/**
	 * @Fields  : 第4年保险公司
	 * @author liujinge
	 */
	private String column188;

	/**
	 * @Fields  : 4年保单是否归档
	 * @author liujinge
	 */
	private String column189;

	/**
	 * @Fields  : 4年报价
	 * @author liujinge
	 */
	private String column190;

	/**
	 * @Fields  : 4年保费
	 * @author liujinge
	 */
	private String column191;

	/**
	 * @Fields  : 4年商业
	 * @author liujinge
	 */
	private String column192;

	/**
	 * @Fields  : 4年交强
	 * @author liujinge
	 */
	private String column193;

	/**
	 * @Fields  : 4年车船
	 * @author liujinge
	 */
	private String column194;

	/**
	 * @Fields  : 第4年gps盗抢
	 * @author liujinge
	 */
	private String column195;

	/**
	 * @Fields  : 4年盗抢赠送
	 * @author liujinge
	 */
	private String column196;

	/**
	 * @Fields  : 第4年车上人员
	 * @author liujinge
	 */
	private String column197;

	/**
	 * @Fields  : 第4年中宝特惠
	 * @author liujinge
	 */
	private String column198;

	/**
	 * @Fields  : 第4年漳州玻璃
	 * @author liujinge
	 */
	private String column199;

	/**
	 * @Fields  : 第4年返利
	 * @author liujinge
	 */
	private String column200;

	/**
	 * @Fields  : 4年客户补缴
	 * @author liujinge
	 */
	private String column201;

	/**
	 * @Fields  : 是否结算
	 * @author liujinge
	 */
	private String column202;

	/**
	 * @Fields  : 返利到账时间
	 * @author liujinge
	 */
	private String column203;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	private String column204;

	/**
	 * @Fields  : 第4年终保日期
	 * @author liujinge
	 */
	private String column205;

	/**
	 * @Fields  : 
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String temp02Id;

}