package cn.com.leadu.fms.thirdinterface.common.port.py;

import cn.com.leadu.fms.pojo.thirdinterface.PyCreditAntiInterfaceVo;

import java.util.Random;

/**
 * @author 杨刚
 * @ClassName: FraudAnalyze
 * @Description: 鹏远征信 反欺诈分析
 * @date 2018-06-7
 */
public class PyCreditAntiInterface {
    public static PyCreditAntiInterfaceVo getTestData(){
        String testData [][] = {
                {"测试一"	,"110000199001011112",	"13712345670"},
                {"测试一"	,"110000199001011112",	"13712345678"},
                {"测试二"	,"110000199001021118",	"13712345671"},
                {"测试二"	,"110000199001021118",	"13712345672"},
                {"测试三"	,"110000199001031113",	"13711111222"},
                {"测试四"	,"110000199001041119",	"13712345676"},
                {"测试四"	,"110000199001041119",	"13712345677"},
                {"测试五"	,"110000199001051114",	"13722345670"},
                {"测试六"	,"110000199001061128",	"13722345671"},
                {"测试七"	,"110000199001071115",	"13722345672"},
                {"测试八"	,"110000199001081129",	"13722345673"},
                {"测试九"	,"110000199001091116",	"13722345674"},
                {"测试十"	,"11000019900114111X",	"13722345675"}
        };
        PyCreditAntiInterfaceVo testVo = new PyCreditAntiInterfaceVo();
        Random rand = new Random();
        int index = rand.nextInt(9);
        testVo.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
        testVo.setName(testData[index][0]);//姓名(可以为空)
        testVo.setDocumentNo(testData[index][1]);//证件号码(可以为空)
        testVo.setPhone(testData[index][2]);//手机
        return testVo;
    }
//	public static void main(String[] args) {
//        try {
//            PyCreditAntiInterfaceVo cs= new PyCreditAntiInterfaceVo();
//            cs.setRefID("cs002");//业务流水号(自定义CHAR(30)，可以为空)
//            cs.setName("测试一");//姓名
//            cs.setDocumentNo("110000199001011112");//证件号码
//            cs.setPhone("13712345670");//手机
//            Map<String, String> resultMap = new PyInterface().requestUnzipApi(cs);
//            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
//            if(jsonObject.has("status")&&jsonObject.get("status").toString().equals("2")){
//                System.out.println(jsonObject.get("errorMessage"));
//            }
//
//            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
//            JSONArray cisReport = returnValue.optJSONArray("cisReport");
//            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
//                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
//                JSONObject treatResult = new JSONObject(t);          //通过String又得到每个元素的对象
//                JSONObject resultidcard= treatResult.optJSONObject("policeCheckInfo");
//                JSONObject result_item= resultidcard.optJSONObject("item");
//                if (result_item.has("result")) {
//                    System.out.print(result_item.getString("result"));        //得到对象中的元素  身份认证结果
//                }
//                JSONObject mobileCheckInfo= treatResult.optJSONObject("mobileCheckInfo");
//                if (resultidcard.has("treatResult")) {
//                    System.out.print(resultidcard.getString("treatResult"));        //姓名核查结果
//                }
//                JSONObject mobileCheckInfo_item= mobileCheckInfo.optJSONObject("item");
//                if (mobileCheckInfo_item.has("nameCheckResult")) {
//                    System.out.print(mobileCheckInfo_item.getString("nameCheckResult"));        //姓名核查结果
//                }
//                if (mobileCheckInfo_item.has("documentNoCheckResult")) {
//                    System.out.print(mobileCheckInfo_item.getString("documentNoCheckResult"));        //证件号码核查结果
//                }
//                if (mobileCheckInfo_item.has("phoneCheckResult")) {
//                    System.out.print(mobileCheckInfo_item.getString("phoneCheckResult"));        //手机号码核查结果
//                }
//                if (mobileCheckInfo_item.has("areaInfo")) {
//                    System.out.print(mobileCheckInfo_item.getString("areaInfo"));        //手机号码归属地
//                }
//                if (mobileCheckInfo_item.has("operator")) {
//                    System.out.print(mobileCheckInfo_item.getString("operator"));        //运营商
//                }
//
//                JSONObject personAntiSpoofingInfo= treatResult.optJSONObject("personAntiSpoofingInfo");
//                if (personAntiSpoofingInfo.has("riskScore")) {
//                    System.out.print(personAntiSpoofingInfo.getString("riskScore"));        //风险评分
//                }
//                JSONObject mobileStatusInfo= treatResult.optJSONObject("mobileStatusInfo");
//                JSONObject mobileStatusInfo_item= mobileStatusInfo.optJSONObject("item");
//                if (mobileStatusInfo_item.has("phoneStatus")) {
//                    System.out.print(mobileStatusInfo_item.getString("phoneStatus"));        //姓名核查结果
//                }
//                if (mobileStatusInfo_item.has("timeLength")) {
//                    System.out.print(mobileStatusInfo_item.getString("timeLength"));        //手机号码在网时长
//                }
//                if (mobileStatusInfo_item.has("phoneStatus")) {
//                    System.out.print(mobileStatusInfo_item.getString("phoneStatus"));        //手机状态
//                }
//                JSONObject personAntiSpoofingDescInfo= treatResult.optJSONObject("personAntiSpoofingDescInfo");
//                if (personAntiSpoofingDescInfo.has("personAntiSpoofingDesc")) {
//                    System.out.print(personAntiSpoofingDescInfo.getString("personAntiSpoofingDesc"));        //姓名核查结果
//                }
//
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//	}
//    public static void requestUnzipApi(String refID) throws Exception {
//        String result = requestApi(PyConfig.HOST, PyConfig.PATH_UNZIP, refID);
//        System.out.println(result);
//    }
//
//    public static String requestApi(String host, String path,String refID) throws Exception {
//        Map<String, String> headers = new HashMap<String, String>();
//        Map<String, String> querys = null;
//        Map<String, String> bodys = new HashMap<String, String>();
//        bodys.put("userID", PyConfig.USERID);
//        bodys.put("password", PyConfig.PASSWORD);
//        bodys.put("queryCondition", getQueryCondition(refID));
//        HttpResponse response = HttpUtils.doPost(host, path, "POST", headers, querys, bodys);
//        String result = EntityUtils.toString(response.getEntity());
//
//        return result;
//    }
//
//    private static String getQueryCondition(String refID) throws Exception {
//        QueryConditions queryConditions = new QueryConditions();
//        List<QueryCondition> conditions = new ArrayList<QueryCondition>();
//        QueryCondition queryCondition = new QueryCondition();
//        queryCondition.setQueryType("25212");//查询类型   互联网客户
//        // 查询类型
//        List<QueryCondition.Item> items = new ArrayList<QueryCondition.Item>();
//        // 收费子报告
//        items.add(new QueryCondition.Item("subreportIDs", "96040"));//收费子报告
//        // 查询原因
//        items.add(new QueryCondition.Item("queryReasonID", "101"));//贷款审批查询原因ID
//        items.add(new QueryCondition.Item("refID", refID));
//        // 具体查询条件
//        items.add(new QueryCondition.Item("name", "测试一"));//姓名
//        items.add(new QueryCondition.Item("documentNo", "110000199001011112"));//证件号码
//        items.add(new QueryCondition.Item("phone", "13712345670"));//手机
//        queryCondition.setItems(items);
//        conditions.add(queryCondition);
//        queryConditions.setConditions(conditions);
//        return JSON.toJSONString(queryConditions);
//
//    }
}
//测试数据
//name	，documentNo，	phone （96040）
//        测试一	，110000199001011112，	13712345670
//        测试一	，110000199001011112，	13712345678
//        测试二	，110000199001021118，	13712345671
//        测试二	，110000199001021118，	13712345672
//        测试三	，110000199001031113，	13711111222
//        测试四	，110000199001041119，	13712345676
//        测试四	，110000199001041119，	13712345677
//        测试五	，110000199001051114，	13722345670
//        测试六	，110000199001061128，	13722345671
//        测试七	，110000199001071115，	13722345672
//        测试八	，110000199001081129，	13722345673
//        测试九	，110000199001091116，	13722345674
//        测试十	，11000019900114111X，	13722345675