package com.mytest.microservices.service;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.Valve;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jinwen on 2017/6/30.
 */
@Configuration
public class TomcatConfig {

  @Bean
  public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
    tomcat.addEngineValves(new Valve() {
      @Override
      public Valve getNext() {
        return null;
      }

      @Override
      public void setNext(Valve valve) {

      }

      @Override
      public void backgroundProcess() {

      }

      @Override
      public void invoke(Request request, Response response) throws IOException, ServletException {

      }

      @Override
      public boolean isAsyncSupported() {
        return false;
      }
    });
    tomcat.addAdditionalTomcatConnectors(createSslConnector());
    return tomcat;
  }

  private Connector createSslConnector() {
    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
    try {
//      File keystore = new ClassPathResource("keystore").getFile();
//      File truststore = new ClassPathResource("keystore").getFile();
      connector.setScheme("HTTP/1.1");
      connector.setSecure(true);
      connector.setPort(9999);

      protocol.setSSLEnabled(false);
//      protocol.setKeystoreFile(keystore.getAbsolutePath());
//      protocol.setKeystorePass("changeit");
//      protocol.setTruststoreFile(truststore.getAbsolutePath());
//      protocol.setTruststorePass("changeit");
//      protocol.setKeyAlias("apitester");
      return connector;
    }
    catch (Exception ex) {
      throw new IllegalStateException("can't access keystore: [" + "keystore"
          + "] or truststore: [" + "keystore" + "]", ex);
    }
  }

}
