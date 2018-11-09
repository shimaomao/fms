package cn.com.leadu.fms.thirdinterface.common.port.py.bean;

import java.util.List;

/**
 * 查询条件JavaBean
 */
public class QueryConditions {

    private List<QueryCondition> conditions;

    public List<QueryCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<QueryCondition> conditions) {
        this.conditions = conditions;
    }
}
