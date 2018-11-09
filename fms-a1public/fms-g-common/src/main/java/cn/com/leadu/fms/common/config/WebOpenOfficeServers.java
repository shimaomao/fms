package cn.com.leadu.fms.common.config;

import cn.com.leadu.fms.common.util.ArrayUtils;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: WebOpenOfficeServers
 * @Description:
 * @date 2018/3/30
 */
@ConfigurationProperties(prefix = "fms.openOffice")
@Component
@Data
public class WebOpenOfficeServers {

    private static WebOpenOfficeServers webOpenOfficeServers = null;

    private Map<String,String> servers;

    public WebOpenOfficeServers(){
        WebOpenOfficeServers.webOpenOfficeServers = this;
    }

    public static Map<String,String> getOpenOfficeServers(){
        return webOpenOfficeServers.getServers();
    }

    private static List<OpenOfficeConnection> openOfficeConnections = new ArrayList<>();

    public static void initOpenOfficeConnection(){
        Map<String,String> openOfficeServers =  WebOpenOfficeServers.getOpenOfficeServers();
        if(openOfficeServers != null) {
            List<String> serverHosts = new ArrayList<>(openOfficeServers.keySet());
            if (ArrayUtils.isNotNullAndLengthNotZero(serverHosts)) {
                String host = serverHosts.get(0);
                Integer port = Integer.parseInt(openOfficeServers.get(host));
                OpenOfficeConnection connection = new SocketOpenOfficeConnection(
                        host, port);
                try {
                    connection.connect();
                    openOfficeConnections.add(connection);
                } catch (ConnectException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static OpenOfficeConnection getOpenOfficeConnection(){
        return openOfficeConnections.get(0);
    }

}
