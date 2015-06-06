package com.tenchael.android.template.commons;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.http.conn.ssl.SSLSocketFactory;

public class HttpsUtils {
	
	private HttpsUtils(){
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	private static SSLSocketFactory sslSocketFactory = null;
	static {
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore
					.getDefaultType());
			trustStore.load(null, null);
			sslSocketFactory = new MySSLSocketFactory(trustStore);
			sslSocketFactory
					.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		}

	}

	public static SSLSocketFactory getSSLSocketFactory() {
		return sslSocketFactory;
	}

}
