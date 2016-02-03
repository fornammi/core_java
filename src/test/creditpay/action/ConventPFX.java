package test.creditpay.action;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Enumeration;

/**
 * pfx证书转换为jks证书
 * @author daniel.fang
 *
 */
public class ConventPFX {
	public static final String PKCS12 = "PKCS12";
    public static final String JKS = "JKS";
    //public static final String KEYSTORE_PASSWORD = "vpos123";//证书密码
    //public static final String PFX_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\信用支付\\81231005311149690\\81231005311149690.pfx";//pfx 证书路径
    //public static final String JKS_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\信用支付\\81231005311149690\\81231005311149690.jks"; //jks证书路径
    public static final String KEYSTORE_PASSWORD = "123456";//证书密码
    //public static final String PFX_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\creditPay\\SKST2商户证书\\org.0.0000145026.pfx";	//pfx证书路径
    //public static final String JKS_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\creditPay\\SKST2商户证书\\org.0.0000145026.jks";	//jks证书路径
    //public static final String PFX_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\creditPay\\SKST2网关接口\\99900004511001191.pfx";	//pfx证书路径
    //public static final String JKS_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\creditPay\\SKST2网关接口\\99900004511001191.jks";	//jks证书路径
    /*public static final String PFX_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\creditPay\\ST2SK终端\\201512041.pfx";	//pfx证书路径
    public static final String JKS_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\creditPay\\ST2SK终端\\201512041.jks";*/	//jks证书路径
    public static final String PFX_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\test\\99900004511001091.pfx";	//pfx证书路径
    public static final String JKS_KEYSTORE_FILE = "d:\\daniel.fang\\桌面\\test\\99900004511001091.jks";	//jks证书路径
    
    

    public static void coverTokeyStore() {
        try {
            KeyStore inputKeyStore = KeyStore.getInstance("PKCS12");
            FileInputStream fis = new FileInputStream(PFX_KEYSTORE_FILE);
            char[] nPassword = null;
            
            if ((KEYSTORE_PASSWORD == null) || KEYSTORE_PASSWORD.trim().equals("")) {
                nPassword = null;
            } else {
                nPassword = KEYSTORE_PASSWORD.toCharArray();
            }

            inputKeyStore.load(fis, nPassword);
            fis.close();
            KeyStore outputKeyStore = KeyStore.getInstance("JKS");
            outputKeyStore.load(null, KEYSTORE_PASSWORD.toCharArray());
            Enumeration enums = inputKeyStore.aliases();
            
            while (enums.hasMoreElements()) {
                String keyAlias = (String) enums.nextElement();
                System.out.println("alias=[" + keyAlias + "]");
                if (inputKeyStore.isKeyEntry(keyAlias)) {
                    Key key = inputKeyStore.getKey(keyAlias, nPassword);
                    Certificate[] certChain = inputKeyStore.getCertificateChain(keyAlias);

                    outputKeyStore.setKeyEntry(keyAlias, key, KEYSTORE_PASSWORD.toCharArray(), certChain);
                }   
            }   

            FileOutputStream out = new FileOutputStream(JKS_KEYSTORE_FILE);
            outputKeyStore.store(out, nPassword);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        coverTokeyStore();
    }

}
