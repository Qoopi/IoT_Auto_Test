package mechanics.system.http;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.params.HttpParams;
import mechanics.system.constant.URLs;

import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;

public class GatewaySslSocketFactory extends SSLSocketFactory {
    private static final String host = URLs.ApiGateway.getValue();
    private static final String protocol = "TLSv1.2";

    public GatewaySslSocketFactory(SSLContext sslContext, X509HostnameVerifier hostnameVerifier) {
        super(sslContext, hostnameVerifier);
    }

    @Override
    public Socket createSocket(HttpParams params) throws IOException {
        SSLSocket sslSocket = (SSLSocket) super.createSocket(params);

        // Set the encryption protocol
        sslSocket.setEnabledProtocols(new String[]{protocol});

        // Configure SNI
        SNIHostName serverName = new SNIHostName(host);
        SSLParameters sslParams = sslSocket.getSSLParameters();
        sslParams.setServerNames(Collections.singletonList(serverName));
        sslSocket.setSSLParameters(sslParams);

        return sslSocket;
    }
}