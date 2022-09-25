package cn.xjqcljsy.poolsizeproject;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class PoolSizeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoolSizeProjectApplication.class, args);
    }

    @Bean
    @Order(Integer.MAX_VALUE - 1)
    public FilterRegistrationBean monitoringFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MonitoringFilter());
        registration.addUrlPatterns("/*");
        registration.setName("monitoring");
        return registration;
    }

    /**
     * 配置javamelody监听器sessionListener
     */
    @Bean
    public ServletListenerRegistrationBean<SessionListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SessionListener> slrBean = new ServletListenerRegistrationBean<SessionListener>();
        slrBean.setListener(new SessionListener());
        return slrBean;
    }
}
