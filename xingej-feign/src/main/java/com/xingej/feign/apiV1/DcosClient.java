package com.xingej.feign.apiV1;

import feign.Feign;
import feign.RequestInterceptor;
import feign.Feign.Builder;
import feign.RequestTemplate;
import feign.Response;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xingej.feign.auth.TokenAuthRequestInterceptor;
import com.xingej.feign.utils.ModelUtils;

/**
 * 获得Dcos的实例对象
 * 
 * @author erjun
 * 2018年1月20日 下午4:49:40
 */
public class DcosClient {
    
    private static Logger logger = LoggerFactory.getLogger(DcosClient.class); // 日志记录
    
    //获得Dcos实例对象
    public static Dcos getInstance(String endpoint) {
        return getInstance(endpoint, null);
    }

    public static Dcos getInstance(String endpoint, RequestInterceptor[] interceptors) {
        Feign.Builder b = Feign.builder().encoder(new GsonEncoder(ModelUtils.GSON))
                .decoder(new GsonDecoder(ModelUtils.GSON)).errorDecoder(new ErrorDecoder() {
                    
                    @Override
                    public Exception decode(String status, Response reason) {
                        
                        logger.error("--------->\n错误状态码:{},\n原因:{}", status, reason);
                        
                        return null;
                    }
                });

        if (interceptors != null)
            b.requestInterceptors(Arrays.asList(interceptors));
        
        b.requestInterceptor(new DcosHeadersInterceptor());
     
        return ((Dcos) b.target(Dcos.class, endpoint));
    }

    public static Dcos getInstanceWithBasicAuth(String endpoint, String username, String password) {
        return getInstance(endpoint, new RequestInterceptor[] { new BasicAuthRequestInterceptor(username, password) });
    }

    public static Dcos getInstanceWithTokenAuth(String endpoint, String token) {
        return getInstance(endpoint, new RequestInterceptor[] { new TokenAuthRequestInterceptor(token) });
    }

    static class DcosHeadersInterceptor implements RequestInterceptor {
        public void apply(RequestTemplate template) {
            Map headers = template.headers();
            
            if (null == headers.get("Content-Type")) {
                template.header("Accept", new String[] { "application/json" });
                template.header("Content-Type", new String[] { "application/json" });
            }
        }
    }
}
