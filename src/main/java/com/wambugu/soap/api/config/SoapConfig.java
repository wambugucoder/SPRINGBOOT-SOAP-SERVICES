package com.wambugu.soap.api.config;

import com.wambugu.soap.api.endpoint.LoanEndpoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class SoapConfig {
    private  static final String NAMESPACE= "http://www.wambugu.com/wambugu/soap/api/loaneligibility";
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet>messageDispatcherServletServletRegistrationBean(ApplicationContext applicationContext){
       MessageDispatcherServlet servlet=new MessageDispatcherServlet();
       servlet.setApplicationContext(applicationContext);
       servlet.setTransformWsdlLocations(true);
       return new ServletRegistrationBean<MessageDispatcherServlet>(servlet,"/ws/*");
    }
    @Bean(name = "loanEligibility")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema){
        DefaultWsdl11Definition defaultWsdl11Definition=new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("LoanEligibilityIndicator");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace(NAMESPACE);
        defaultWsdl11Definition.setSchema(xsdSchema);
        return  defaultWsdl11Definition;

    }
    @Bean
    public XsdSchema xsdSchema(){
        return new SimpleXsdSchema(new ClassPathResource("loaneligibility.xsd"));
    }
}

