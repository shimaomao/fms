package cn.com.leadu.fms.thirdinterface.common.port.tygps;

import cn.com.leadu.fms.common.constant.TyGpsConstants;
import cn.com.leadu.fms.common.util.TyGpsUtils;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

/**
 *微众接口公共发送请求类 
 **/
public class GPSHttpSendReq {

	public static void main(String[] args)throws Exception {
		//get 请求工单设备实时位置信息获取接口
		String applyNo="TY011234112";
		String result=doGet(TyGpsConstants.geturl+applyNo);
		//解析JSON
		JSONObject jsonObject=new JSONObject(result);
		JSONObject data = jsonObject.optJSONObject("data");
        JSONArray jsonArray=data.optJSONArray("terminal");
		for (int i=1;i<jsonArray.length();i++){
			String json=jsonArray.getString(i);
			JSONObject terminal=new JSONObject(json);
			String carNo=terminal.optString("carNo");
			System.out.println(carNo);
		}
		String jsonResult = TyGpsUtils.getResult(jsonObject.getString("result"));
		System.out.println(jsonResult);
		//post 请求派单接口
//		JSONObject jsonParam = new JSONObject();
//		jsonParam.put("applyNo","TY011234117");//申请编号
//		jsonParam.put("contactName","上海石易电子科有限");//现场联系人姓名
//		jsonParam.put("contactPhone","13874143223");//现场联系人手机号
//		jsonParam.put("piccontactName","派工联系人");//派工联系人姓名
//		jsonParam.put("piccontactPhone","15874146559");//派工联系人电手机号
//		jsonParam.put("installtime","2018-6-22 18:40:00");//上门时间(距上门时间超过2小时；早8点-晚7点半)
//		jsonParam.put("carAccount","太二测试");//拉车账号
//		jsonParam.put("addressCode","310113");//上门地址（省市区）
//		jsonParam.put("addressDetail","通河新村地铁站");//详细地址
//		jsonParam.put("remark","测试数据（1）");//备注
//		JSONArray jsonArray = new JSONArray();
//		JSONObject car = new JSONObject();//车辆信息
//		car.put("ownerName","车主姓名");//车主姓名
//		car.put("ownerCard","431224199510067576");//身份证号
//		car.put("carBrand","智力产业园二");//车型
//		car.put("carNo","川ASX554");//车牌
//		car.put("carVin","LSVNN2180D2013488");//车架
//		car.put("wiredPeriod",1);//有线设备年期
//		car.put("wiredNum",1);//有线设备数量
//		car.put("wirelessPeriod",1);//无线设备年期
//		car.put("wirelessNum",1);//无线设备数量
//		jsonArray.put(car);
//		jsonParam.put("car",jsonArray);
//		System.out.println(doPost(TyGpsConstants.posturl,jsonParam.toString()));
	}
	public static String doGet(String url) {
		try {
			HttpClient client = new DefaultHttpClient();
			//发送get请求
			HttpGet request = new HttpGet(url);
			//设置请求超时时间
			RequestConfig config = RequestConfig.custom()
					.setConnectionRequestTimeout(10000).setConnectTimeout(10000)
					.setSocketTimeout(10000).build();
			request.setConfig(config);
			HttpResponse response = client.execute(request);
			/**请求发送成功，并得到响应**/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/**读取服务器返回过来的json字符串数据**/
				String strResult = EntityUtils.toString(response.getEntity());
				System.out.println(strResult);
				return strResult;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	public static String doPost(String url, String params) throws Exception {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);// 创建httpPost
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		String charSet = "UTF-8";
		StringEntity entity = new StringEntity(params, charSet);
		httpPost.setEntity(entity);
		//设置请求超时时间
		RequestConfig config = RequestConfig.custom()
				.setConnectionRequestTimeout(10000).setConnectTimeout(10000)
				.setSocketTimeout(10000).build();
		httpPost.setConfig(config);
		CloseableHttpResponse response = null;
		try {

			response = httpclient.execute(httpPost);
			StatusLine status = response.getStatusLine();
			int state = status.getStatusCode();
			if (state == HttpStatus.SC_OK) {
				HttpEntity responseEntity = response.getEntity();
				String jsonString = EntityUtils.toString(responseEntity);
				System.out.println(jsonString);
				return jsonString;
			}
			else{
				System.out.println("请求返回:\"+state+\"(\"+url+\")");
			}
		}
		finally {
			if (response != null) {
				try {
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				httpclient.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
