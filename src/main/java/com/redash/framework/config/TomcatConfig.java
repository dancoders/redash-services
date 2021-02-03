package com.redash.framework.config;


import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Tomcat相关配置</p>
 * @author dancoder
 */
@Configuration
public class TomcatConfig {
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(
                connector -> {
                    Http11NioProtocol protocol =
                            (Http11NioProtocol) connector.getProtocolHandler();
                    protocol.setDisableUploadTimeout(false);
                }
        );
        return factory;
    }
}
