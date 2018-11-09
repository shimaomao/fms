package cn.com.leadu.fms.common.constant.enums.system;

/**
 * Created by 89354 on 2018/3/29.
 * 组织类别
 */
public enum SysGroupEnums {
        ADMINISTRATIVE_TYPE("1","行政组织");

        private String type;

        private String desc;

        SysGroupEnums(String type, String desc){
            this.type = type;
            this.desc = desc;
        }

        public String getType() {
            return type;
        }

        public String getDesc() {
            return desc;
        }

}
