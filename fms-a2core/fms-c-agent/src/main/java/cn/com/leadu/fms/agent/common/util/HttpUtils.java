package cn.com.leadu.fms.agent.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiaohao on 2017/10/27.
 */
@Slf4j
public class HttpUtils {


    public static String httpUserInfo(String userInfoUrl,String userId){
        try{
            HttpPost httpPost = new HttpPost(userInfoUrl);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(20000)
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(20000).build();
            httpPost.setConfig(requestConfig);
            // 获取当前客户端对象
            HttpClient httpClient = HttpClients.createDefault();
            List<NameValuePair> formParams = new ArrayList<>();
            formParams.add(new BasicNameValuePair("userId", userId));
            HttpEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httpPost.setEntity(entity);
            // 通过请求对象获取响应对象
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                return EntityUtils.toString(response.getEntity());
            }else{
                System.out.println("http状态异常：" + response.getStatusLine().getStatusCode());
                return null;
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

}
