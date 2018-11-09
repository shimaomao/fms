package cn.com.leadu.fms.thirdinterface.common.port.py;

import cn.com.leadu.fms.pojo.thirdinterface.PyCreditCorpDebtInterfaceVo;

import java.util.Random;

/**
 * @author 杨刚
 * @ClassName: CompanyDebt
 * @Description: 鹏远征信 企业债务信息接口
 * @date 2018-06-7
 */
public class PyCreditCorpDebtInterface {

    public static PyCreditCorpDebtInterfaceVo getTestData(){
        String testData [][] = {
                {"测试一"	}
        };

        PyCreditCorpDebtInterfaceVo testVo = new PyCreditCorpDebtInterfaceVo();
        Random rand = new Random();
        int index = 0;
        testVo.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
        testVo.setCorpName(testData[index][0]);//姓名(可以为空)
        return testVo;
    }

//    public static void main(String[] args) {
//        try {
//            PyCreditCorpDebtInterfaceVo cs= new PyCreditCorpDebtInterfaceVo();
//            cs.setRefID("cs001");//业务流水号(自定义CHAR(30)，可以为空)
//            cs.setCorpName("测试一");//公司名称
//            cs.setRegisterNO("");//工商注册号
//            cs.setOrgCode("");//企业机构代码
//            Map<String, String> resultMap = new PyInterface().requestUnzipApi(cs);
//            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
//            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
//            JSONArray cisReport = returnValue.optJSONArray("cisReport");
//
//            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
//                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
//                JSONObject treatResult = new JSONObject(t);          //通过String又得到每个元素的对象
//                JSONObject corpDebtInfo = treatResult.optJSONObject("corpDebtInfo");
//                System.out.print(corpDebtInfo.getString("treatResult"));        //得到对象中的元素
//                JSONObject corpDebtSummaryInfo = corpDebtInfo.optJSONObject("corpDebtSummaryInfo");
//                if (corpDebtSummaryInfo.has("liquidationInfo")) {
//                    System.out.print(corpDebtSummaryInfo.getString("liquidationInfo"));        //得到对象中的元素
//                }
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//	public static void main(String[] args) {
//
//
//		String refID="cs001";//业务流水号(自定义CHAR(30)，可以为空)
//    	try {
//			CompanyDebt.requestUnzipApi(refID);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
//        queryCondition.setQueryType("25123");//查询类型   互联网客户
//        // 查询类型
//        List<QueryCondition.Item> items = new ArrayList<QueryCondition.Item>();
//        // 收费子报告
//        items.add(new QueryCondition.Item("subreportIDs", "22108"));//收费子报告
//        // 查询原因
//        items.add(new QueryCondition.Item("queryReasonID", "101"));//贷款审批查询原因ID
//        items.add(new QueryCondition.Item("refID", refID));
//        // 具体查询条件
//        items.add(new QueryCondition.Item("corpName", "测试二"));//姓名
////        items.add(new QueryCondition.Item("registerNO", ""));//工商注册号
////        items.add(new QueryCondition.Item("orgCode", "13712345678"));//企业机构代码
//        queryCondition.setItems(items);
//        conditions.add(queryCondition);
//        queryConditions.setConditions(conditions);
//        return JSON.toJSONString(queryConditions);
//
//    }
}
//测试数据
//name	，documentNo，	phone （96040）
//测试一
//测试二
//测试三