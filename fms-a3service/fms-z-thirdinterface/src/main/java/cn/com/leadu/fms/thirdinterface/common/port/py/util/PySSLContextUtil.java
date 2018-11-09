package cn.com.leadu.fms.thirdinterface.common.port.py.util;



import cn.com.leadu.fms.common.constant.PyConfigConstants;

import javax.net.ssl.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

/**
 * 鹏元征信 SSLContext 帮助类
 */
public class PySSLContextUtil {

    /**
     * 使用该SSLContext，证书如下
     * keystore  ： javax.net.ssl.keyStore 指定的证书
     * truststore  ： javax.net.ssl.trustStore 指定的证书
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static SSLContext createDefaultSSLContext() throws NoSuchAlgorithmException {
        return SSLContext.getDefault();
    }

    /**
     * 使用该SSLContext, 证书可自定义
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static SSLContext createCustomerSSLContext() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException, CertificateException, UnrecoverableKeyException {
        SSLContext context = SSLContext.getInstance("TLS");
        KeyStore keyStore = getKeyStore("JKS", new FileInputStream(PyConfigConstants.config.getKeyStoreFile()), PyConfigConstants.config.getKeyStorePassWord());
        KeyManager[] kms = createKeyManager(keyStore, PyConfigConstants.config.getKeyStorePassWord());
        KeyStore trustStore = getKeyStore("JKS", new FileInputStream(PyConfigConstants.config.getTrustStoreFile()), PyConfigConstants.config.getTrustStorePassWord());
        TrustManager[] tms = createTrustManager(trustStore);
		//需要添加信任证书（需要公钥）
        //context.init(kms, tms, null);
		//不要信任证书
		TrustManager tm= new X509TrustManager(){
		@Override
		public void checkClientTrusted(java.security.cert.X509Certificate[] chain,String authType) throws CertificateException
		{
		
		}
		@Override
		public void checkServerTrusted(java.security.cert.X509Certificate[] chain,String authType) throws CertificateException
		{
		}
		@Override
		public java.security.cert.X509Certificate[] getAcceptedIssuers()
		{
		   return null;
		}
		};
		context.init(kms,new TrustManager[]{tm},null);
        return context;
    }

    private static KeyManager[] createKeyManager(KeyStore keyStore, String password) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        KeyManagerFactory factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        factory.init(keyStore, password.toCharArray());
        return factory.getKeyManagers();
    }

    private static TrustManager[] createTrustManager(KeyStore trustStore) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        factory.init(trustStore);
        return factory.getTrustManagers();
    }


    public static KeyStore getKeyStore(String keyStoreType, InputStream stream, String password) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(stream, password.toCharArray());
        return keyStore;
    }
}
