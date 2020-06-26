package com.pokedex.web.util;

import org.springframework.http.HttpMethod;

public interface InvokeRestService {
    <T, R> R invokeRestService(final String endpoint, HttpMethod method, T request, Class<R> expectedResponse);
}
