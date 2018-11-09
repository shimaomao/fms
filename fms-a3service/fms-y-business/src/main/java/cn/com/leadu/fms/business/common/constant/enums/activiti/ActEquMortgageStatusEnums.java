package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActEquMortgageStatusEnums
 * @Description: 资方抵押流程(先抵押后放款) 审核状态
 * @date 2018/6/7
 */
public enum  ActEquMortgageStatusEnums {

    AGREE(0,"同意"),
    RETURN_SUPERIOR(1,"退回上一级"),
    CANCEL(2,"取消");

    private Integer status;

    private String desc;

    ActEquMortgageStatusEnums(Integer status, String desc){
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus(){
        return this.status;
    }

    public String getDesc(){
        return this.desc;
    }

}
