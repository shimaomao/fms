package cn.com.leadu.fms.common.util;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;


/**
 * 日常 公共方法的公共类
 * 
 * @author Administrator
 * 
 */
public class CommonUtils {
	
	private static DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		CommonUtils.dataSource = dataSource;
	}
	

	private CommonUtils() {
	}

	private final static DecimalFormat formator = new DecimalFormat("##,###,###.00"); // 格式化输出
	private final static DecimalFormat formator1 = new DecimalFormat("########.00"); // 格式化输出

	/**
	 * 数字格式化输出
	 * 
	 * @param obj
	 * @return
	 */
	public static String numberToformat(Object obj) {
		return formator.format(obj);
	}

	public static String numberTostring(Object obj) {
		return formator1.format(obj);
	}

	/**
	 * 取消科学计数法
	 * 
	 * @param je
	 * @return
	 */
	public static String d2String(double je) {
		DecimalFormat df = new DecimalFormat("##0");
		return df.format(je).toString();
	}

	// 字符串和字符数组比较
	public static boolean isHave(String[] strs, String s) {
		/*
		 * 此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
		 */
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].indexOf(s) != -1) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
				return true;// 查找到了就返回真，不在继续查询
			}
		}
		return false;// 没找到返回false
	}

	// 字符串和字符串比较 大的字符串要有","
	public static boolean isHave(String arrs, String s) {
		/*
		 * 此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
		 */
		String[] strs = arrs.split(",");
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].indexOf(s) != -1) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
				return true;// 查找到了就返回真，不在继续查询
			}
		}
		return false;// 没找到返回false
	}
	/**
	 * 判断是否数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		  str=str.replace(" ","");
		  for (int i = 0; i < str.length(); i++){
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
	}
	/**
	 * 首字母转大写
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String capitalize(String str) {
		if (str == null || str.equals("")) {
			return "";
		}
		// str = str.toLowerCase();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		return str;
	}

	/**
	 * 得到Property文件对应的value
	 * 
	 * @param str
	 * @return
	 */
	public static String getPropertyValue(String str, String str1) {
		String value = "";
		Properties prop = new Properties();
		String configFile = str;
		try {
			// Config File must be in classpath
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			InputStream in = cl.getResourceAsStream(configFile);
			prop.load(in);
			value = prop.getProperty(str1);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * double 向上 取整
	 * 
	 * @param v
	 * @return
	 */
	public static double round0(double v) {

		return (new BigDecimal(v).setScale(0, BigDecimal.ROUND_UP)).doubleValue();
	}

	/**
	 * double 四舍五入 取整
	 * 
	 * @param v
	 * @return
	 */
	public static double round2(double v) {
		return (new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_UP)).doubleValue();
	}

	public static double round4(double v) {

		return (new BigDecimal(v).setScale(4, BigDecimal.ROUND_HALF_UP)).doubleValue();
	}
	public static String changeMoney(BigDecimal amount){
		if(amount == null){
			return "";
		}
		return change(amount.toString());
	}

	// 将小写金额转化成大写金额
	public static String change(String d) {
		if (d == null || "".equals(d)) {
			return "";
		}
//		double dd = Double.parseDouble(d);
		BigDecimal dd=new BigDecimal(d).setScale(0, BigDecimal.ROUND_DOWN);
		BigDecimal ff=new BigDecimal("100");
		String[] hanArr = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String[] unitArr = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿" };
		String ss = "";
		long zheng = (long) CommonUtils.round0((dd.multiply(ff).doubleValue()));
		if(zheng < 0){
			ss = "负";
			zheng = Math.abs(zheng);
		}
		String str = String.valueOf(zheng);
		char[] chr = str.toCharArray();

		for (int i = 0; i < chr.length; i++) {
			int x = (int) chr[i] - 48;
			int y = chr.length - i - 1;
			ss += hanArr[x] + unitArr[y];
		}
		String rs = ss.replaceAll("零[拾佰仟]", "零").replaceAll("零+万", "万").replaceAll("零+元", "元")
				.replaceAll("零+角", "")
				.replaceAll("零+分", "").replaceAll("零+", "零").replace("元", "");
		return rs.equals("") ? "零" : rs;

	}

	// 取小数位点后两位
	public static String checkNum(double b) {
		DecimalFormat df = new DecimalFormat(".##");
		String st = df.format(b);
		return st;
	}

	/**
	 * 获取一个四位随机数，并且四位数不重复
	 * 
	 * @return Set<Integer>
	 */
	public static String GetRandomNumber() {
		// 使用SET以此保证写入的数据不重复
		Set<Integer> set = new HashSet<Integer>();
		// 随机数
		Random random = new Random();

		while (set.size() < 4) {
			// nextInt返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）
			// 和指定值（不包括）之间均匀分布的 int 值。
			set.add(random.nextInt(10));
		}
		Iterator<Integer> iterator = set.iterator();
		// 临时记录数据
		String temp = "";
		while (iterator.hasNext()) {
			temp += iterator.next();
			// System.out.print(iterator.next());
		}
		// System.out.println(temp);
		return temp;
	}

	public static String getEnvVars(String env) {
		try {
			Process p = null;
			Properties envVars = new Properties();
			Runtime r = Runtime.getRuntime();
			String OS = System.getProperty("os.name").toLowerCase();
			// System.out.println(OS);
			if (OS.indexOf("windows 9") > -1) {
				p = r.exec("command.com /c set");
			} else if ((OS.indexOf("nt") > -1) || (OS.indexOf("windows ") > -1)) {
				// thanks to JuanFran for the xp fix!
				p = r.exec("cmd.exe /c set");
			} else {
				// our last hope, we assume Unix (thanks to H. Ware for the fix)
				p = r.exec("env");
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				int idx = line.indexOf('=');
				String key = line.substring(0, idx);
				String value = line.substring(idx + 1);
				envVars.setProperty(key, value);
				// System.out.println( key + " = " + value );
			}
			return envVars.getProperty(env);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    
    /*根据流水号+年限得到申请编号
     * @param num 合同号码的流水号
     */
	public static Integer makeHthm(Integer num){
		//得到年月
		Calendar c = Calendar.getInstance();
		String year = c.get(Calendar.YEAR)+"";
		int b=(int)(Math.random()*10);//产生0-10的双精度随机数 
		String hthm =year.substring(2, year.length())+num+b;//合同号码规则  年后两位 +SEQ+0-10的随机数
		return Integer.parseInt(hthm);
	}
	
	public static void main(String [] args){

		System.out.println(CommonUtils.change(120000.98+""));
	}

 	//日期相减的到天数
 	/**
 	 *	两个日期相减得到天数   yyyy-MM-dd
 	 * @param date1 减数
 	 * @param date2 被减数
 	 */
 	public static int getdays(Date date1,Date date2) {
		Integer days=0;
		long l = date1.getTime() - date2.getTime() > 0 ? date1.getTime()
				- date2.getTime() :

		date2.getTime() - date1.getTime();

		// 日期相减得到相差的日期

		long day = (date1.getTime() - date2.getTime())
				/ (24 * 60 * 60 * 1000) > 0 ? (date1.getTime() - date2
				.getTime()) / (24 * 60 * 60 * 1000) :

		(date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000);
		days=(int) day;
		return days;
	}

	/**
	 *	根据属性名称，获取对象的属性值
	 * @param propertyName 属性名
	 * @param object 对象
	 */
	public static Object getPropertyValueByObject(String propertyName, Object object) {
		try {
			String property = capitalize(propertyName);
			if (!"".equals(property)) {
				property = "get" + property;
				Method method = object.getClass().getMethod(property, new Class[0]);
				Object result = method.invoke(object, new Object[0]);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * BigDecimal类型数据Format
	 * @param bigDecimal
	 * @return
	 */
	public static BigDecimal TrimBigDecimal(BigDecimal bigDecimal){
		if (bigDecimal == null){
			return BigDecimal.ZERO;
		}
		return bigDecimal;
	}

	/**
	 * BigDecimal类型数据向上取整
	 * @param bigDecimal
	 * @return
	 */
	public static BigDecimal roundUpBigDecimal(BigDecimal bigDecimal){
		return bigDecimal.setScale( 0, BigDecimal.ROUND_UP);
	}

	/*
	 * 根据表达式取得key-value map
	 * @param expr (key:value,key;value)
	 * @return
	 */
	public static Map<String, String> getExprMap(String expr){
		//分号分割多个条件 and 的关系
		String [] values = expr.split(StringUtils.SEMICOLON);
		Map<String, String> exprMap = new HashMap<>();
		if(ArrayUtils.isNullOrLengthZero(values) ){
			return exprMap;
		}
		for(String value :values){
			//冒号分割key和value
			String [] keyValue = value.split(StringUtils.COLON);
			if(ArrayUtils.isNullOrLengthZero(keyValue) || keyValue.length != 2){
				continue;
			}
			exprMap.put(keyValue[0], keyValue[1]);
		}
		return exprMap;
	}

	/*
	 * 将格式（201809）转化为（2018年09月）格式
	 * @param string
	 * @return string
	 */
	public  static String yearMonthFmt(String param){
		if(StringUtils.isNotTrimBlank(param) && param.length() == 6){
			return new StringBuffer(param).insert(4,"年").insert(7,"月").toString();
		}
		return null;
	}

}
