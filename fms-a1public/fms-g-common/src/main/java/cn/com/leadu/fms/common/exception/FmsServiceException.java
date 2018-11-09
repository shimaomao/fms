
package cn.com.leadu.fms.common.exception;

/**
 * @author qiaomengnan
 * @ClassName: FmsServiceException
 * @Description: 逻辑层异常
 * @date 2018/1/7
 */
public class FmsServiceException extends FmsRuntimeException {

    private static final long serialVersionUID = 5439915454935047937L;

    public FmsServiceException(String msg){
        super(msg);
    }

    public FmsServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
