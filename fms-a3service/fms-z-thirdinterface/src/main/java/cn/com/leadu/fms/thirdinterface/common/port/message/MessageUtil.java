package cn.com.leadu.fms.thirdinterface.common.port.message;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author 杨刚
 * @ClassName: PyApiDemo
 * @Description: 鹏远征信
 * @date 2018-06-6
 */
public class MessageUtil {

	 public static String HTTP_POST(String URL, String Data) throws Exception { 
	        BufferedReader In = null;
	        PrintWriter Out = null;   
	        HttpURLConnection HttpConn = null;
	        try {
		        URL url=new URL(URL);
		        HttpConn=(HttpURLConnection)url.openConnection();
		        HttpConn.setRequestMethod("POST");
		        HttpConn.setDoInput(true);
		        HttpConn.setDoOutput(true);
		     
		        Out=new PrintWriter(HttpConn.getOutputStream());
		        Out.println(Data);
		        Out.flush();
		        
		        if(HttpConn.getResponseCode() == HttpURLConnection.HTTP_OK){
			        StringBuffer content = new StringBuffer();
			        String tempStr = "";
			        In = new BufferedReader(new InputStreamReader(HttpConn.getInputStream()));
			        while((tempStr = In.readLine()) != null){
			        	content.append(tempStr);
			        }
			        In.close();
			        return content.toString();
		        }
		        else
		        {
		        	throw new Exception("HTTP_POST_ERROR_RETURN_STATUS：" + HttpConn.getResponseCode());
		        }
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }finally{
		        Out.close();
		        HttpConn.disconnect();
	        }
	        return null;
	}

	/**
	 * @Title:
	 * @Description:  发送短信
	 * @param to  接收人
	 * @param content 内容
	 * @param url 发送url
	 * @param id 账号
	 * @param pwd 密码
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/07/24 05:00:48
	 */
	public static String messageSend(String to,String content,String url,String id,String pwd) throws Exception {
		String HTTP_BACK_MESSAGE = "";
		try {
			//短息发送url
			//String url= WebMessageProperties.url;
			//还款短信对应账号密码
			//String id=messageEnums.getType();
			//String pwd=messageEnums.getDesc();
			HTTP_BACK_MESSAGE = HTTP_POST(url,"id="+id+"&pwd="+pwd+"&to="+to+"&content=" + URLEncoder.encode(content, "gb2312") + "&time=");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HTTP_BACK_MESSAGE;
	}
//	public static void main(String[] args) throws Exception{
//		String to="15605538283";//手机号
//		String content="尊敬的客户，您本期租金付款日为6月5日，请准时安排款项！如遇节假日请提前安排支付。如已付款，请无需理会。祝您生活愉快！【万量融资租赁】";//短信内容
////		*String content="尊敬的客户！您的爱车闽H203219于2018年车险已续保，强制保险标志于今日顺丰寄出，单号顺丰233123131233，注意查收！【万量融资租赁】";//短信内容
////		*String content="尊敬的客户！您的爱车闽H203219车险于2018年6月5日到期，实际续保费1000元，续保当年保险融资额1000元，不足部分1000元请于即日起3日内支付到万量公账，请知悉！【万量融资租赁】";//短信内容
////		*String content="尊敬的客户！您的爱车闽H203219车险于2018年6月5日到期，请于到期日前3日及时续保并依约将保单交由我司归档（联系电话0592-3100179），出单要求投保人及被保险人应为万量公司，请知悉！【万量融资租赁】";//短信内容
////		String content="尊敬的客户！您的爱车闽H203219车险于2018年6月5日到期，按合同约定，贵方应于到期前3日依约续保并将保单交由我司归档，截至目前，我司未收到贵方保单，我司有权依约先行续保，续保费**元，贵方应于即日起7日内将续保费足额支付到我司公账，否则，我司有权追究贵方违约责任，请知悉！【万量融资租赁】";//短信内容
////		*String content="尊敬的客户！您的爱车闽H203219车险于2018年6月5日到期，合同租赁期届满，在租赁车辆未完成过户前，贵方应依约办理车险续保并将保单交由我司保管，请知悉！【万量融资租赁】";//短信内容
//
//		try {
//			messageSend(to,content, MessageEnums.REFUND);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
