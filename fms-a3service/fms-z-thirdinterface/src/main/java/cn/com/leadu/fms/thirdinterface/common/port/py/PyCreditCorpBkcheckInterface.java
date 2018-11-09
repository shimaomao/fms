package cn.com.leadu.fms.thirdinterface.common.port.py;

//import org.json.JSONArray;
//import org.json.JSONObject;


import cn.com.leadu.fms.pojo.thirdinterface.PyCreditCorpBkcheckInterfaceVo;

import java.util.Random;

/**
 * @author 杨刚
 * @ClassName: BankCheck
 * @Description: 鹏远征信 银行三要素核查
 * @date 2018-06-6
 */
public class PyCreditCorpBkcheckInterface {
    public static PyCreditCorpBkcheckInterfaceVo getTestData(){
        String testData [][] = {
                {"测试一"	,"6226620403042404" ,     	"303584000004"}
        };

        PyCreditCorpBkcheckInterfaceVo testVo = new PyCreditCorpBkcheckInterfaceVo();
        Random rand = new Random();
        int index = 0;
        testVo.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
        testVo.setCorpName(testData[index][0]);//姓名(可以为空)
        testVo.setAccountNo(testData[index][1]);//证件号码(可以为空)
        testVo.setOpenBankNo(testData[index][2]);//手机
        return testVo;
    }
//    public static void main(String[] args) {
//        try {
//            PyCreditCorpBkcheckInterfaceVo cs= new PyCreditCorpBkcheckInterfaceVo();
//            cs.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
//            cs.setCorpName("测试一");//公司名称
//            cs.setAccountNo("6226620403042404");//银行账号
//            cs.setOpenBankNo("303584000004");//开户行行号
//            Map<String, String> resultMap = new PyInterface().requestUnzipApi(cs);
//            //            treatResult的值代表1：查得，2：未查得，3：其它原因未查得
//            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
//            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
//            JSONArray cisReport = returnValue.optJSONArray("cisReport");
//            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
//                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
//                JSONObject treatResult = new JSONObject(t);          //通过String又得到每个元素的对象
//                JSONObject corpBankCheckInfo = treatResult.optJSONObject("corpBankCheckInfo");
//                if (corpBankCheckInfo.has("treatResult")) {
//                    System.out.print(corpBankCheckInfo.getString("treatResult"));        //得到对象中的元素
//                    JSONObject item = corpBankCheckInfo.optJSONObject("item");
//                    System.out.print(item.getString("status"));        //得到对象中的元素
//                }
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//	public static void main(String[] args) {
//
////		String apply_type="1";//个人
//		String apply_type="2";//企业
//		String refID="cs001";//业务流水号(自定义CHAR(30)，可以为空)
//    	try {
//			BankCheck.requestUnzipApi(apply_type,refID);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//    public static void requestUnzipApi(String apply_type,String refID) throws Exception {
//        String result = requestApi(PyConfig.HOST, PyConfig.PATH_UNZIP, apply_type, refID);
//        System.out.println(result);
////      解析json  treatResult的值代表1：查得，2：未查得，3：其它原因未查得
//        JSONObject jsonObject = new JSONObject(result);
//        JSONObject returnValue = jsonObject.optJSONObject("returnValue");
//        JSONArray cisReport = returnValue.optJSONArray("cisReport");
//        for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
//            String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
//            JSONObject treatResult = new JSONObject(t);          //通过String又得到每个元素的对象
//            if (treatResult.has("treatResult")) {
//                System.out.print(treatResult.getString("treatResult"));        //得到对象中的元素
//            }
//        }
//    }
//
////    public void requestZipApi() throws Exception {
////        String result = requestApi(PyConfig.HOST, PyConfig.PATH_ZIP);
////        System.out.println(result);
////
////        // 对压缩文本做进一步处理
////        Map<String, Object> resultMap = JSON.parseObject(result);
////        String status = (String) resultMap.get("status");
////        if ("1".equals(status)) {
////            String returnValue = (String) resultMap.get("returnValue");
////            returnValue = PyUtils.decodeAndDecompress(returnValue, "UTF-8");
////            System.out.println("returnValue:" + returnValue);
////        }
////    }
//    public static String requestApi(String host, String path,String apply_type,String refID) throws Exception {
//
//        // https双向认证使用,配合PySSLContextUtil中的DefaultSSLContext
////        System.setProperty("javax.net.debug", "all");
////        System.setProperty("javax.net.ssl.keyStore", PyConfig.KEYSTORE_FILE);
////        System.setProperty("javax.net.ssl.keyStorePassword", PyConfig.KEYSTORE_PASSWORD);
////        System.setProperty("javax.net.ssl.trustStore", PyConfig.TRUSTSTORE_FILE);
////        System.setProperty("javax.net.ssl.trustStorePassword", PyConfig.TRUSTSTORE_PASSWORD);
//
//        Map<String, String> headers = new HashMap<String, String>();
//        Map<String, String> querys = null;
//        Map<String, String> bodys = new HashMap<String, String>();
//        bodys.put("userID", PyConfig.USERID);
//        bodys.put("password", PyConfig.PASSWORD);
//        bodys.put("queryCondition", getQueryCondition(apply_type,refID));
//        HttpResponse response = HttpUtils.doPost(host, path, "POST", headers, querys, bodys);
//        String result = EntityUtils.toString(response.getEntity());
//
//        return result;
//    }
//
//    private static String getQueryCondition(String apply_type,String refID) throws Exception {
//        QueryConditions queryConditions = new QueryConditions();
//        List<QueryCondition> conditions = new ArrayList<QueryCondition>();
//        QueryCondition queryCondition = new QueryCondition();
//        if("1".equals(apply_type)){
//        	queryCondition.setQueryType("25173");//个人
//        }else{
//        	queryCondition.setQueryType("25174");//企业
//        }
//        // 查询类型
//        List<QueryCondition.Item> items = new ArrayList<QueryCondition.Item>();
//        // 收费子报告
//        if("1".equals(apply_type)){
//        	items.add(new QueryCondition.Item("subreportIDs", "14509"));//个人
//        }else{
//        	items.add(new QueryCondition.Item("subreportIDs", "22600"));//企业
//        }
//        // 查询原因
//        items.add(new QueryCondition.Item("queryReasonID", "101"));//贷款审批查询原因ID
////        items.add(new QueryCondition.Item("queryReasonID", "102"));//贷款贷后管理查询原因ID
////        items.add(new QueryCondition.Item("queryReasonID", "103"));//贷款催收查询原因ID
//        // 业务流水号(自定义CHAR(30)，可以为空)
//        items.add(new QueryCondition.Item("refID", refID));
//        // 具体查询条件
//        if("1".equals(apply_type)){
//        	//个人
//            items.add(new QueryCondition.Item("name", "测试一"));//姓名
//            items.add(new QueryCondition.Item("documentNo", "110000199001011112"));//证件号码
//            items.add(new QueryCondition.Item("accountNo", "6225768610373340"));//银行账号
//            items.add(new QueryCondition.Item("openBankNo", ""));//开户行行号(可以为空)
//
////            items.add(new QueryCondition.Item("name", "测试二"));
////            items.add(new QueryCondition.Item("documentNo", "110000199001021118"));
////            items.add(new QueryCondition.Item("accountNo", "6222088751234567"));
////            items.add(new QueryCondition.Item("openBankNo", ""));//开户行行号(可以为空)
////
////            items.add(new QueryCondition.Item("name", "测试三"));
////            items.add(new QueryCondition.Item("documentNo", "110000199001031113"));
////            items.add(new QueryCondition.Item("accountNo", "6222088750761201"));
////            items.add(new QueryCondition.Item("openBankNo", ""));//开户行行号(可以为空)
//        }else{
//        	//企业
//            items.add(new QueryCondition.Item("corpName", "测试一"));//姓名
//            items.add(new QueryCondition.Item("accountNo", "6226620403042404"));//银行账号
//            items.add(new QueryCondition.Item("openBankNo", "303584000004"));//开户行行号
//
////            items.add(new QueryCondition.Item("corpName", "测试二"));//姓名
////            items.add(new QueryCondition.Item("accountNo", "6226620403042405"));//银行账号
////            items.add(new QueryCondition.Item("openBankNo", "303584000004"));//开户行行号
////
////            items.add(new QueryCondition.Item("corpName", "测试四"));//姓名
////            items.add(new QueryCondition.Item("accountNo", "6226620403042407"));//银行账号
////            items.add(new QueryCondition.Item("openBankNo", "303584000004"));//开户行行号
//
//        }
//        queryCondition.setItems(items);
//        conditions.add(queryCondition);
//        queryConditions.setConditions(conditions);
//        return JSON.toJSONString(queryConditions);
//
//    }
}
//个人
//            items.add(new QueryCondition.Item("name", "测试一"));//姓名
//            items.add(new QueryCondition.Item("documentNo", "110000199001011112"));//证件号码
//            items.add(new QueryCondition.Item("accountNo", "6225768610373340"));//银行账号
//            items.add(new QueryCondition.Item("openBankNo", ""));//开户行行号(可以为空)

//            items.add(new QueryCondition.Item("name", "测试二"));
//            items.add(new QueryCondition.Item("documentNo", "110000199001021118"));
//            items.add(new QueryCondition.Item("accountNo", "6222088751234567"));
//            items.add(new QueryCondition.Item("openBankNo", ""));//开户行行号(可以为空)
//
//            items.add(new QueryCondition.Item("name", "测试三"));
//            items.add(new QueryCondition.Item("documentNo", "110000199001031113"));
//            items.add(new QueryCondition.Item("accountNo", "6222088750761201"));
//            items.add(new QueryCondition.Item("openBankNo", ""));//开户行行号(可以为空)
//企业
//            items.add(new QueryCondition.Item("corpName", "测试一"));//姓名
//                    items.add(new QueryCondition.Item("accountNo", "6226620403042404"));//银行账号
//                    items.add(new QueryCondition.Item("openBankNo", "303584000004"));//开户行行号(可以为空)

//            items.add(new QueryCondition.Item("corpName", "测试二"));//姓名
//            items.add(new QueryCondition.Item("accountNo", "6226620403042405"));//银行账号
//            items.add(new QueryCondition.Item("openBankNo", "303584000004"));//开户行行号(可以为空)
//
//            items.add(new QueryCondition.Item("corpName", "测试四"));//姓名
//            items.add(new QueryCondition.Item("accountNo", "6226620403042407"));//银行账号
//            items.add(new QueryCondition.Item("openBankNo", "303584000004"));//开户行行号(可以为空)