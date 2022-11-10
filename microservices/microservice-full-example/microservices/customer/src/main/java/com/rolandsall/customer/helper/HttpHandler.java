package com.rolandsall.customer.helper;

import com.rolandsall.customer.services.IHttpHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpHandler<E> implements IHttpHandler<E> {

    private final RestTemplate restTemplate;

    @Autowired
    public HttpHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public <T> T getForObject(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);
    }
}
