package cn.com.leadu.fms.thirdinterface.common.port.py;

import cn.com.leadu.fms.pojo.thirdinterface.PyAddrInterfaceVo;

import java.util.Random;

/**
 * @author 杨刚
 * @ClassName: AddresCheck
 * @Description: 鹏远征信 地址核查
 * @date 2018-06-7
 */
public class PyAddrInterface {
    public static PyAddrInterfaceVo getTestData(){
        String testData [][] = {
                {"测试一"	,"110000199001011112" ,     	"13300000001",	"广东省深圳市福田区地址1"},
                {"测试二"	,"110000199001021118" ,     	"13300000002" ,	"广东省深圳市福田区地址2" } ,
                {"测试三"	,"110000199001031113",       	"13300000003",	"广东省深圳市福田区地址3" } ,
                {"测试四"	,"110000199001041119",       	"13300000004",	"广东省深圳市福田区地址4" } ,
                {"测试五"	,"110000199001051114",       	"13300000005",	"广东省深圳市福田区地址5" } ,
                {"测试六"	,"110000199001061128" ,     	"13300000006", 	"广东省深圳市福田区地址6" } ,
                {"测试七"	,"110000199001071115" ,    	    "13300000007", 	"广东省深圳市福田区地址7" } ,
                {"测试八"	,"110000199001081129",      	"13300000008", 	"广东省深圳市福田区地址8" } ,
                {"测试九"	,"110000199001091116",      	"13300000009", 	"广东省深圳市福田区地址9" } ,
                {"测试十"	,"11000019900114111X" ,     	"13300000010",	"广东省深圳市福田区地址十"}
        };
        //测试数据
//        测试一	，110000199001011112  ，     	13300000001，	广东省深圳市福田区地址1
//        测试二	，110000199001021118 ，     	13300000002 ，	广东省深圳市福田区地址2
//        测试三	，110000199001031113，       	13300000003，	广东省深圳市福田区地址3
//        测试四	，110000199001041119，       	13300000004，	广东省深圳市福田区地址4
//        测试五	，110000199001051114，       	13300000005，	广东省深圳市福田区地址5
//        测试六	，110000199001061128 ，     	13300000006， 	广东省深圳市福田区地址6
//        测试七	，110000199001071115 ，    	    13300000007， 	广东省深圳市福田区地址7
//        测试八	，110000199001081129，      	13300000008， 	广东省深圳市福田区地址8
//        测试九	，110000199001091116，      	13300000009， 	广东省深圳市福田区地址9
//        测试十	，11000019900114111X ，     	13300000010，	广东省深圳市福田区地址十
        PyAddrInterfaceVo testVo = new PyAddrInterfaceVo();
        Random rand = new Random();
        int index = rand.nextInt(9);
        testVo.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
        testVo.setName(testData[index][0]);//姓名(可以为空)
        testVo.setDocumentNo(testData[index][1]);//证件号码(可以为空)
        testVo.setMobile(testData[index][2]);//手机
        testVo.setAddress(testData[index][3]);//地址
        return testVo;
    }


//	public static void main(String[] args) {
//    	try {
//            PyAddrInterfaceVo cs= new PyAddrInterfaceVo();
//            cs.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
//            cs.setName("测试一");//姓名(可以为空)
//            cs.setDocumentNo("110000199001011112");//证件号码(可以为空)
//            cs.setMobile("13300000001");//手机
//            cs.setAddress("广东省深圳市福田区地址1");//地址
//            Map<String, String> resultMap = new PyInterface().requestUnzipApi(cs);
//            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
//            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
//            JSONArray cisReport = returnValue.optJSONArray("cisReport");
//            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
//                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
//                JSONObject treatResult = new JSONObject(t);          //通过String又得到每个元素的对象
//                treatResult= treatResult.optJSONObject("addressCheckInfo");
//                if (treatResult.has("treatResult")) {
//                    System.out.print(treatResult.getString("treatResult"));        //姓名核查结果
//                }
//                if (treatResult.has("provinceCheckResult")) {
//                    System.out.print(treatResult.getString("provinceCheckResult"));        //得到对象中的元素
//                }
//                if (treatResult.has("cityCheckResult")) {
//                    System.out.print(treatResult.getString("cityCheckResult"));        //得到对象中的元素
//                }
//                if (treatResult.has("countyCheckResult")) {
//                    System.out.print(treatResult.getString("countyCheckResult"));        //得到对象中的元素
//                }
//                if (treatResult.has("detailAddressCheckResult")) {
//                    System.out.print(treatResult.getString("detailAddressCheckResult"));        //得到对象中的元素
//                }
//
//            }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
//测试数据
//        测试一	，110000199001011112  ，     	13300000001，	广东省深圳市福田区地址1
//        测试二	，110000199001021118 ，     	13300000002 ，	广东省深圳市福田区地址2
//        测试三	，110000199001031113，       	13300000003，	广东省深圳市福田区地址3
//        测试四	，110000199001041119，       	13300000004，	广东省深圳市福田区地址4
//        测试五	，110000199001051114，       	13300000005，	广东省深圳市福田区地址5
//        测试六	，110000199001061128 ，     	13300000006， 	广东省深圳市福田区地址6
//        测试七	，110000199001071115 ，    	13300000007， 	广东省深圳市福田区地址7
//        测试八	，110000199001081129，      	13300000008， 	广东省深圳市福田区地址8
//        测试九	，110000199001091116，      	13300000009， 	广东省深圳市福田区地址9
//        测试十	，11000019900114111X ，     	13300000010，	广东省深圳市福田区地址十