package cn.com.leadu.fms.pojo.system.vo.wltemp01;

import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.WlTemp01;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTemp01Vo
 * @Description: 数据迁移载体
 * @date 2018-08-04
 */
@Data
public class WlTempAllVo extends PageQuery<WlTemp01> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 序号
	 * @author liujinge
	 */
	@ExcelImportTitle("序号")
	private String column1;

	/**
	 * @Fields  : 公司
	 * @author liujinge
	 */
	@ExcelImportTitle("公司")
	private String column2;

	/**
	 * @Fields  : 年度
	 * @author liujinge
	 */
	@ExcelImportTitle("年度")
	private String column3;

	/**
	 * @Fields  : 年月
	 * @author liujinge
	 */
	@ExcelImportTitle("年月")
	private String column4;

	/**
	 * @Fields  : 产品类型
	 * @author liujinge
	 */
	@ExcelImportTitle("产品类型")
	private String column5;

	/**
	 * @Fields  : 是否报贴息
	 * @author liujinge
	 */
	@ExcelImportTitle("是否报贴息")
	private String column6;

	/**
	 * @Fields  : 品牌分类
	 * @author liujinge
	 */
	@ExcelImportTitle("品牌分类")
	private String column7;

	/**
	 * @Fields  : 客户分类
	 * @author liujinge
	 */
	@ExcelImportTitle("客户分类")
	private String column8;

	/**
	 * @Fields  : 租赁性质
	 * @author liujinge
	 */
	@ExcelImportTitle("租赁性质")
	private String column9;

	/**
	 * @Fields  : 合同编号
	 * @author liujinge
	 */
	@ExcelImportTitle("合同编号")
	private String column10;

	/**
	 * @Fields  : 租赁状态
	 * @author liujinge
	 */
	@ExcelImportTitle("租赁状态")
	private String column11;

	/**
	 * @Fields  : 租赁标注
	 * @author liujinge
	 */
	@ExcelImportTitle("租赁标注")
	private String column12;

	/**
	 * @Fields  : 是否结清
	 * @author liujinge
	 */
	@ExcelImportTitle("是否结清")
	private String column13;

	/**
	 * @Fields  : 是否过户
	 * @author liujinge
	 */
	@ExcelImportTitle("是否过户")
	private String column14;

	/**
	 * @Fields  : 过户时间
	 * @author liujinge
	 */
	@ExcelImportTitle("过户时间")
	private String column15;

	/**
	 * @Fields  : 凭票款项
	 * @author liujinge
	 */
	@ExcelImportTitle("凭票款项")
	private String column16;

	/**
	 * @Fields  : 是否抵押
	 * @author liujinge
	 */
	@ExcelImportTitle("是否抵押")
	private String column17;

	/**
	 * @Fields  : 续保押金
	 * @author liujinge
	 */
	@ExcelImportTitle("续保押金")
	private String column18;

	/**
	 * @Fields  : 盗抢公司
	 * @author liujinge
	 */
	@ExcelImportTitle("盗抢公司")
	private String column19;

	/**
	 * @Fields  : 客户性质
	 * @author liujinge
	 */
	@ExcelImportTitle("客户性质")
	private String column20;

	/**
	 * @Fields  : 承租人
	 * @author liujinge
	 */
	@ExcelImportTitle("承租人")
	private String column21;

	/**
	 * @Fields  : 担保人
	 * @author liujinge
	 */
	@ExcelImportTitle("担保人")
	private String column22;

	/**
	 * @Fields  : 联系电话
	 * @author liujinge
	 */
	@ExcelImportTitle("联系电话")
	private String column23;

	/**
	 * @Fields  : 租金联系人
	 * @author liujinge
	 */
	@ExcelImportTitle("租金联系人")
	private String column24;

	/**
	 * @Fields  : 租金联系电话
	 * @author liujinge
	 */
	@ExcelImportTitle("租金联系电话")
	private String column25;

	/**
	 * @Fields  : 品牌
	 * @author liujinge
	 */
	@ExcelImportTitle("品牌")
	private String column26;

	/**
	 * @Fields  : 车系
	 * @author liujinge
	 */
	@ExcelImportTitle("车系")
	private String column27;

	/**
	 * @Fields  : 车型
	 * @author liujinge
	 */
	@ExcelImportTitle("车型")
	private String column28;

	/**
	 * @Fields  : 车架号
	 * @author liujinge
	 */
	@ExcelImportTitle("车架号")
	private String column29;

	/**
	 * @Fields  : 发动机号
	 * @author liujinge
	 */
	@ExcelImportTitle("发动机号")
	private String column30;

	/**
	 * @Fields  : 车牌号
	 * @author liujinge
	 */
	@ExcelImportTitle("车牌号")
	private String column31;

	/**
	 * @Fields  : 销售渠道
	 * @author liujinge
	 */
	@ExcelImportTitle("销售渠道")
	private String column32;

	/**
	 * @Fields  : 开票经销商
	 * @author liujinge
	 */
	@ExcelImportTitle("开票经销商")
	private String column33;

	/**
	 * @Fields  : 万量车源
	 * @author liujinge
	 */
	@ExcelImportTitle("万量车源")
	private String column34;

	/**
	 * @Fields  : 业务经理
	 * @author liujinge
	 */
	@ExcelImportTitle("业务经理")
	private String column35;

	/**
	 * @Fields  : 融资类型
	 * @author liujinge
	 */
	@ExcelImportTitle("融资类型")
	private String column36;

	/**
	 * @Fields  : 审批日期
	 * @author liujinge
	 */
	@ExcelImportTitle("审批日期")
	private String column37;

	/**
	 * @Fields  : 合同签约日期
	 * @author liujinge
	 */
	@ExcelImportTitle("合同签约日期")
	private String column38;

	/**
	 * @Fields  : 放款日期
	 * @author liujinge
	 */
	@ExcelImportTitle("放款日期")
	private String column39;

	/**
	 * @Fields  : GPS安装日期
	 * @author liujinge
	 */
	@ExcelImportTitle("GPS安装日期")
	private String column40;

	/**
	 * @Fields  : 交车日期
	 * @author liujinge
	 */
	@ExcelImportTitle("交车日期")
	private String column41;

	/**
	 * @Fields  : 还款日期
	 * @author liujinge
	 */
	@ExcelImportTitle("还款日期")
	private String column42;

	/**
	 * @Fields  : 起租日期
	 * @author liujinge
	 */
	@ExcelImportTitle("起租日期")
	private String column43;

	/**
	 * @Fields  : 止租日期
	 * @author liujinge
	 */
	@ExcelImportTitle("止租日期")
	private String column44;

	/**
	 * @Fields  : 租金总额
	 * @author liujinge
	 */
	@ExcelImportTitle("租金总额")
	private String column45;

	/**
	 * @Fields  : 已还期数
	 * @author liujinge
	 */
	@ExcelImportTitle("已还期数")
	private String column46;

	/**
	 * @Fields  : 提前还款期数
	 * @author liujinge
	 */
	@ExcelImportTitle("提前还款期数")
	private String column47;

	/**
	 * @Fields  : 未还期数
	 * @author liujinge
	 */
	@ExcelImportTitle("未还期数")
	private String column48;

	/**
	 * @Fields  : 已还租金
	 * @author liujinge
	 */
	@ExcelImportTitle("已还租金")
	private String column49;

	/**
	 * @Fields  : 剩余期数
	 * @author liujinge
	 */
	@ExcelImportTitle("剩余期数")
	private String column50;

	/**
	 * @Fields  : 剩余租金
	 * @author liujinge
	 */
	@ExcelImportTitle("剩余租金")
	private String column51;

	/**
	 * @Fields  : 指导价格
	 * @author liujinge
	 */
	@ExcelImportTitle("指导价格")
	private String column52;

	/**
	 * @Fields  : 客户成交价
	 * @author liujinge
	 */
	@ExcelImportTitle("客户成交价")
	private String column53;

	/**
	 * @Fields  : 万量采购价
	 * @author liujinge
	 */
	@ExcelImportTitle("万量采购价")
	private String column54;

	/**
	 * @Fields  : 贸易收入
	 * @author liujinge
	 */
	@ExcelImportTitle("贸易收入")
	private String column55;

	/**
	 * @Fields  : 宝马贴息补贴
	 * @author liujinge
	 */
	@ExcelImportTitle("宝马贴息补贴")
	private String column56;

	/**
	 * @Fields  : 首付款
	 * @author liujinge
	 */
	@ExcelImportTitle("首付款")
	private String column57;

	/**
	 * @Fields  : 保证金
	 * @author liujinge
	 */
	@ExcelImportTitle("保证金")
	private String column58;

	/**
	 * @Fields  : 保证金处理
	 * @author liujinge
	 */
	@ExcelImportTitle("保证金处理")
	private String column59;

	/**
	 * @Fields  : 尾款
	 * @author liujinge
	 */
	@ExcelImportTitle("尾款")
	private String column60;

	/**
	 * @Fields  : 报价手续费
	 * @author liujinge
	 */
	@ExcelImportTitle("报价手续费")
	private String column61;

	/**
	 * @Fields  : 手续费纯收入
	 * @author liujinge
	 */
	@ExcelImportTitle("手续费纯收入")
	private String column62;

	/**
	 * @Fields  : 月租金
	 * @author liujinge
	 */
	@ExcelImportTitle("月租金")
	private String column63;

	/**
	 * @Fields  : 年供
	 * @author liujinge
	 */
	@ExcelImportTitle("年供")
	private String column64;

	/**
	 * @Fields  : 租赁期限
	 * @author liujinge
	 */
	@ExcelImportTitle("租赁期限")
	private String column65;

	/**
	 * @Fields  : 租赁年利率
	 * @author liujinge
	 */
	@ExcelImportTitle("租赁年利率")
	private String column66;

	/**
	 * @Fields  : IRR
	 * @author liujinge
	 */
	@ExcelImportTitle("IRR")
	private String column67;

	/**
	 * @Fields  : 利息收入
	 * @author liujinge
	 */
	@ExcelImportTitle("利息收入")
	private String column68;

	/**
	 * @Fields  : 预留佣金
	 * @author liujinge
	 */
	@ExcelImportTitle("预留佣金")
	private String column69;

	/**
	 * @Fields  : 粗利
	 * @author liujinge
	 */
	@ExcelImportTitle("粗利")
	private String column70;

	/**
	 * @Fields  : 购置税
	 * @author liujinge
	 */
	@ExcelImportTitle("购置税")
	private String column71;

	/**
	 * @Fields  : 挂牌费
	 * @author liujinge
	 */
	@ExcelImportTitle("挂牌费")
	private String column72;

	/**
	 * @Fields  : 过户费
	 * @author liujinge
	 */
	@ExcelImportTitle("过户费")
	private String column73;

	/**
	 * @Fields  : 商业险第一年
	 * @author liujinge
	 */
	@ExcelImportTitle("商业险第一年")
	private String column74;

	/**
	 * @Fields  : 交强险第一年
	 * @author liujinge
	 */
	@ExcelImportTitle("交强险第一年")
	private String column75;

	/**
	 * @Fields  : 车船税第一年
	 * @author liujinge
	 */
	@ExcelImportTitle("车船税第一年")
	private String column76;

	/**
	 * @Fields  : 商业险第二年
	 * @author liujinge
	 */
	@ExcelImportTitle("商业险第二年")
	private String column77;

	/**
	 * @Fields  : 交强险第二年
	 * @author liujinge
	 */
	@ExcelImportTitle("交强险第二年")
	private String column78;

	/**
	 * @Fields  : 车船税第二年
	 * @author liujinge
	 */
	@ExcelImportTitle("车船税第二年")
	private String column79;

	/**
	 * @Fields  : 商业险第三年
	 * @author liujinge
	 */
	@ExcelImportTitle("商业险第三年")
	private String column80;

	/**
	 * @Fields  : 交强险第三年
	 * @author liujinge
	 */

	@ExcelImportTitle("交强险第三年")
	private String column81;

	/**
	 * @Fields  : 车船税第三年
	 * @author liujinge
	 */

	@ExcelImportTitle("车船税第三年")
	private String column82;

	/**
	 * @Fields  : 包含保险费年限
	 * @author liujinge
	 */
	@ExcelImportTitle("包含保险费年限")
	private String column83;

	/**
	 * @Fields  : 总保险费
	 * @author liujinge
	 */
	@ExcelImportTitle("总保险费")
	private String column84;

	/**
	 * @Fields  : 加装费
	 * @author liujinge
	 */
	@ExcelImportTitle("加装费")
	private String column85;

	/**
	 * @Fields  : 路桥费
	 * @author liujinge
	 */
	@ExcelImportTitle("路桥费")
	private String column86;

	/**
	 * @Fields  : 其他费用
	 * @author liujinge
	 */
	@ExcelImportTitle("其他费用")
	private String column87;

	/**
	 * @Fields  : 总融资额
	 * @author liujinge
	 */
	@ExcelImportTitle("总融资额")
	private String column88;

	/**
	 * @Fields  : 租赁概算本金-扣除首付
	 * @author liujinge
	 */
	@ExcelImportTitle("租赁概算本金-扣除首付")
	private String column89;

	/**
	 * @Fields  : 购车款
	 * @author liujinge
	 */
	@ExcelImportTitle("实付购车款")
	private String column90;

	/**
	 * @Fields  : 4S店手续费
	 * @author liujinge
	 */
	@ExcelImportTitle("实付4S店手续费")
	private String column91;

	/**
	 * @Fields  : 4S店佣金
	 * @author liujinge
	 */
	@ExcelImportTitle("实付4S店佣金")
	private String column92;

	/**
	 * @Fields  : 精品费
	 * @author liujinge
	 */
	@ExcelImportTitle("实付精品费")
	private String column93;

	/**
	 * @Fields  : 购置税
	 * @author liujinge
	 */
	@ExcelImportTitle("实付购置税")
	private String column94;

	/**
	 * @Fields  : 首年商业险
	 * @author liujinge
	 */
	@ExcelImportTitle("实付首年商业险")
	private String column95;

	/**
	 * @Fields  : 首年交强险
	 * @author liujinge
	 */
	@ExcelImportTitle("实付首年交强险")
	private String column96;

	/**
	 * @Fields  : 首年车船税
	 * @author liujinge
	 */
	@ExcelImportTitle("实付首年车船税")
	private String column97;

	/**
	 * @Fields  : 首年路桥费
	 * @author liujinge
	 */
	@ExcelImportTitle("实付首年路桥费")
	private String column98;

	/**
	 * @Fields  : 上牌费
	 * @author liujinge
	 */
	@ExcelImportTitle("实付上牌费")
	private String column99;

	/**
	 * @Fields  : GPS费用
	 * @author liujinge
	 */
	@ExcelImportTitle("实付GPS费用")
	private String column100;

	/**
	 * @Fields  : 万量佣金
	 * @author liujinge
	 */
	@ExcelImportTitle("实付万量佣金")
	private String column101;

	/**
	 * @Fields  : 注册登记日
	 * @author liujinge
	 */
	@ExcelImportTitle("注册登记日")
	private String column102;

	/**
	 * @Fields  : 是否年检
	 * @author liujinge
	 */
	@ExcelImportTitle("是否年检")
	private String column103;

	/**
	 * @Fields  : 钥匙
	 * @author liujinge
	 */
	@ExcelImportTitle("钥匙")
	private String column104;

	/**
	 * @Fields  : 是否归档
	 * @author liujinge
	 */
	@ExcelImportTitle("是否归档")
	private String column105;

	/**
	 * @Fields  : 路桥费融资额
	 * @author liujinge
	 */
	@ExcelImportTitle("路桥费融资额")
	private String column106;

	/**
	 * @Fields  : 路桥进度
	 * @author liujinge
	 */
	@ExcelImportTitle("路桥进度")
	private String column107;

	/**
	 * @Fields  : 已缴年度
	 * @author liujinge
	 */
	@ExcelImportTitle("已缴年度")
	private String column108;

	/**
	 * @Fields  : 租赁期限
	 * @author liujinge
	 */
	@ExcelImportTitle("归档租赁期限")
	private String column109;

	/**
	 * @Fields  : 应缴年度
	 * @author liujinge
	 */
	@ExcelImportTitle("应缴年度")
	private String column110;

	/**
	 * @Fields  : 首年路桥费
	 * @author liujinge
	 */
	@ExcelImportTitle("首年路桥费")
	private String column111;

	/**
	 * @Fields  : 第2年路桥费
	 * @author liujinge
	 */
	@ExcelImportTitle("第2年路桥费")
	private String column112;

	/**
	 * @Fields  : 第3年路桥费
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年路桥费")
	private String column113;

	/**
	 * @Fields  : 滞纳金
	 * @author liujinge
	 */
	@ExcelImportTitle("滞纳金")
	private String column114;

	/**
	 * @Fields  : GPS厂商
	 * @author liujinge
	 */
	@ExcelImportTitle("GPS厂商")
	private String column115;

	/**
	 * @Fields  : GPS安装时间
	 * @author liujinge
	 */
	@ExcelImportTitle("GPS安装时间")
	private String column116;

	/**
	 * @Fields  : 有线数量
	 * @author liujinge
	 */
	@ExcelImportTitle("有线数量")
	private String column117;

	/**
	 * @Fields  : 无线数量
	 * @author liujinge
	 */
	@ExcelImportTitle("无线数量")
	private String column118;

	/**
	 * @Fields  : 有线型号
	 * @author liujinge
	 */
	@ExcelImportTitle("有线型号")
	private String column119;

	/**
	 * @Fields  : 断油电
	 * @author liujinge
	 */
	@ExcelImportTitle("断油电")
	private String column120;

	/**
	 * @Fields  : GPS费用
	 * @author liujinge
	 */
	@ExcelImportTitle("GPS费用")
	private String column121;

	/**
	 * @Fields  : GPS续费
	 * @author liujinge
	 */
	@ExcelImportTitle("GPS续费")
	private String column122;

	/**
	 * @Fields  : 第1年保险报价
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年保险报价")
	private String column123;

	/**
	 * @Fields  : 第1年保险实付
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年保险实付")
	private String column124;

	/**
	 * @Fields  : 第1年商业险
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年商业险")
	private String column125;

	/**
	 * @Fields  : 第1年交强险
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年交强险")
	private String column126;

	/**
	 * @Fields  : 第1年车船税
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年车船税")
	private String column127;

	/**
	 * @Fields  : 第1年gps盗抢
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年gps盗抢")
	private String column128;

	/**
	 * @Fields  : 1年盗抢赠送
	 * @author liujinge
	 */
	@ExcelImportTitle("1年盗抢赠送")
	private String column129;

	/**
	 * @Fields  : 第1年盗抢公司
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年盗抢公司")
	private String column130;

	/**
	 * @Fields  : 是否购买VPS盗抢险
	 * @author liujinge
	 */
	@ExcelImportTitle("是否购买VPS盗抢险")
	private String column131;

	/**
	 * @Fields  : 第1年车上人员险
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年车上人员险")
	private String column132;

	/**
	 * @Fields  : 第1年福州中宝特惠险
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年福州中宝特惠险")
	private String column133;

	/**
	 * @Fields  : 第1年漳州玻璃
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年漳州玻璃")
	private String column134;

	/**
	 * @Fields  : 第1年返利
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年返利")
	private String column135;

	/**
	 * @Fields  : 第1年客户补缴
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年客户补缴")
	private String column136;

	/**
	 * @Fields  : 第1年保险公司
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年保险公司")
	private String column137;

	/**
	 * @Fields  : 第1年终保日期
	 * @author liujinge
	 */
	@ExcelImportTitle("第1年终保日期")
	private String column138;

	/**
	 * @Fields  : 2年续保日期
	 * @author liujinge
	 */
	@ExcelImportTitle("2年续保日期")
	private String column139;

	/**
	 * @Fields  : 出险次数
	 * @author liujinge
	 */
	@ExcelImportTitle("2年出险次数")
	private String column140;

	/**
	 * @Fields  : 出险金额
	 * @author liujinge
	 */
	@ExcelImportTitle("2年出险金额")
	private String column141;

	/**
	 * @Fields  : 第2年保险公司
	 * @author liujinge
	 */

	@ExcelImportTitle("第2年保险公司")
	private String column142;

	/**
	 * @Fields  : 2年保单是否归档
	 * @author liujinge
	 */
	@ExcelImportTitle("2年保单是否归档")
	private String column143;

	/**
	 * @Fields  : 2年报价
	 * @author liujinge
	 */
	@ExcelImportTitle("2年报价")
	private String column144;

	/**
	 * @Fields  : 2年保费
	 * @author liujinge
	 */
	@ExcelImportTitle("2年保费")
	private String column145;

	/**
	 * @Fields  : 2年商业
	 * @author liujinge
	 */
	@ExcelImportTitle("2年商业")
	private String column146;

	/**
	 * @Fields  : 2年强险
	 * @author liujinge
	 */
	@ExcelImportTitle("2年强险")
	private String column147;

	/**
	 * @Fields  : 2年车船税
	 * @author liujinge
	 */
	@ExcelImportTitle("2年车船税")
	private String column148;

	/**
	 * @Fields  : 2年gps盗抢
	 * @author liujinge
	 */

	@ExcelImportTitle("2年gps盗抢")
	private String column149;

	/**
	 * @Fields  : gps盗抢赠送
	 * @author liujinge
	 */

	@ExcelImportTitle("2年gps盗抢赠送")
	private String column150;

	/**
	 * @Fields  : 2年盗抢公司
	 * @author liujinge
	 */
	@ExcelImportTitle("2年盗抢公司")
	private String column151;

	/**
	 * @Fields  : 2年车上人员
	 * @author liujinge
	 */
	@ExcelImportTitle("2年车上人员")
	private String column152;

	/**
	 * @Fields  : 2年中宝特惠
	 * @author liujinge
	 */
	@ExcelImportTitle("2年中宝特惠")
	private String column153;

	/**
	 * @Fields  : 2年漳州玻璃
	 * @author liujinge
	 */
	@ExcelImportTitle("2年漳州玻璃")
	private String column154;

	/**
	 * @Fields  : 2年返利
	 * @author liujinge
	 */
	@ExcelImportTitle("2年返利")
	private String column155;

	/**
	 * @Fields  : 2年客户补缴
	 * @author liujinge
	 */
	@ExcelImportTitle("2年客户补缴")
	private String column156;

	/**
	 * @Fields  : 是否结算
	 * @author liujinge
	 */
	@ExcelImportTitle("2年是否结算")
	private String column157;

	/**
	 * @Fields  : 返利到账时间
	 * @author liujinge
	 */
	@ExcelImportTitle("2年返利到账时间")
	private String column158;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	@ExcelImportTitle("第2年备注")
	private String column159;

	/**
	 * @Fields  : 第2年终保日期
	 * @author liujinge
	 */
	@ExcelImportTitle("第2年终保日期")
	private String column160;

	/**
	 * @Fields  : 3年续保日期
	 * @author liujinge
	 */
	@ExcelImportTitle("3年续保日期")
	private String column161;

	/**
	 * @Fields  : 出险次数
	 * @author liujinge
	 */
	@ExcelImportTitle("3年出险次数")
	private String column162;

	/**
	 * @Fields  : 出险金额
	 * @author liujinge
	 */
	@ExcelImportTitle("3年出险金额")
	private String column163;

	/**
	 * @Fields  : 第3年保险公司
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年保险公司")
	private String column164;

	/**
	 * @Fields  : 3年保单是否归档
	 * @author liujinge
	 */
	@ExcelImportTitle("3年保单是否归档")
	private String column165;

	/**
	 * @Fields  : 3年报价
	 * @author liujinge
	 */
	@ExcelImportTitle("3年报价")
	private String column166;

	/**
	 * @Fields  : 3年保费
	 * @author liujinge
	 */

	@ExcelImportTitle("3年保费")
	private String column167;

	/**
	 * @Fields  : 3年商业
	 * @author liujinge
	 */
	@ExcelImportTitle("3年商业")
	private String column168;

	/**
	 * @Fields  : 3年交强
	 * @author liujinge
	 */
	@ExcelImportTitle("3年交强")
	private String column169;

	/**
	 * @Fields  : 3年车船
	 * @author liujinge
	 */
	@ExcelImportTitle("3年车船")
	private String column170;

	/**
	 * @Fields  : 第3年gps盗抢
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年gps盗抢")
	private String column171;

	/**
	 * @Fields  : GPS盗抢险公司
	 * @author liujinge
	 */
	@ExcelImportTitle("3年GPS盗抢险公司")
	private String column172;

	/**
	 * @Fields  : 3年盗抢赠送
	 * @author liujinge
	 */
	@ExcelImportTitle("3年盗抢赠送")
	private String column173;

	/**
	 * @Fields  : 第3年车上人员
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年车上人员")
	private String column174;

	/**
	 * @Fields  : 第3年中宝特惠
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年中宝特惠")
	private String column175;

	/**
	 * @Fields  : 第3年漳州玻璃
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年漳州玻璃")
	private String column176;

	/**
	 * @Fields  : 第3年返利
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年返利")
	private String column177;

	/**
	 * @Fields  : 3年客户补缴
	 * @author liujinge
	 */
	@ExcelImportTitle("3年客户补缴")
	private String column178;

	/**
	 * @Fields  : 是否结算
	 * @author liujinge
	 */
	@ExcelImportTitle("3年是否结算")
	private String column179;

	/**
	 * @Fields  : 返利到账时间
	 * @author liujinge
	 */
	@ExcelImportTitle("3年返利到账时间")
	private String column180;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年备注")
	private String column181;

	/**
	 * @Fields  : 保险已退客户
	 * @author liujinge
	 */
	@ExcelImportTitle("保险已退客户")
	private String column182;

	/**
	 * @Fields  : 客户保险补缴合计
	 * @author liujinge
	 */
	@ExcelImportTitle("客户保险补缴合计")
	private String column183;

	/**
	 * @Fields  : 第3年终保日期
	 * @author liujinge
	 */
	@ExcelImportTitle("第3年终保日期")
	private String column184;

	/**
	 * @Fields  : 4年续保日期
	 * @author liujinge
	 */
	@ExcelImportTitle("4年续保日期")
	private String column185;

	/**
	 * @Fields  : 出险次数
	 * @author liujinge
	 */
	@ExcelImportTitle("4年出险次数")
	private String column186;

	/**
	 * @Fields  : 出险金额
	 * @author liujinge
	 */
	@ExcelImportTitle("4年出险金额")
	private String column187;

	/**
	 * @Fields  : 第4年保险公司
	 * @author liujinge
	 */
	@ExcelImportTitle("第4年保险公司")
	private String column188;

	/**
	 * @Fields  : 4年保单是否归档
	 * @author liujinge
	 */
	@ExcelImportTitle("4年保单是否归档")
	private String column189;

	/**
	 * @Fields  : 4年报价
	 * @author liujinge
	 */
	@ExcelImportTitle("4年报价")
	private String column190;

	/**
	 * @Fields  : 4年保费
	 * @author liujinge
	 */
	@ExcelImportTitle("4年保费")
	private String column191;

	/**
	 * @Fields  : 4年商业
	 * @author liujinge
	 */
	@ExcelImportTitle("4年商业")
	private String column192;

	/**
	 * @Fields  : 4年交强
	 * @author liujinge
	 */
	@ExcelImportTitle("4年交强")
	private String column193;

	/**
	 * @Fields  : 4年车船
	 * @author liujinge
	 */
	@ExcelImportTitle("4年车船")
	private String column194;

	/**
	 * @Fields  : 第4年gps盗抢
	 * @author liujinge
	 */
	@ExcelImportTitle("第4年gps盗抢")
	private String column195;

	/**
	 * @Fields  : 4年盗抢赠送
	 * @author liujinge
	 */
	@ExcelImportTitle("4年盗抢赠送")
	private String column196;

	/**
	 * @Fields  : 第4年车上人员
	 * @author liujinge
	 */
	@ExcelImportTitle("第4年车上人员")
	private String column197;

	/**
	 * @Fields  : 第4年中宝特惠
	 * @author liujinge
	 */
	@ExcelImportTitle("第4年中宝特惠")
	private String column198;

	/**
	 * @Fields  : 第4年漳州玻璃
	 * @author liujinge
	 */
	@ExcelImportTitle("第4年漳州玻璃")
	private String column199;

	/**
	 * @Fields  : 第4年返利
	 * @author liujinge
	 */
	@ExcelImportTitle("第4年返利")
	private String column200;

	/**
	 * @Fields  : 4年客户补缴
	 * @author liujinge
	 */
	@ExcelImportTitle("4年客户补缴")
	private String column201;

	/**
	 * @Fields  : 是否结算
	 * @author liujinge
	 */
	@ExcelImportTitle("4年是否结算")
	private String column202;

	/**
	 * @Fields  : 返利到账时间
	 * @author liujinge
	 */
	@ExcelImportTitle("4年返利到账时间")
	private String column203;

	/**
	 * @Fields  : 备注
	 * @author liujinge
	 */
	@ExcelImportTitle("第4年备注")
	private String column204;

	/**
	 * @Fields  : 第4年终保日期
	 * @author liujinge
	 */
	@ExcelImportTitle("第4年终保日期")
	private String column205;


}