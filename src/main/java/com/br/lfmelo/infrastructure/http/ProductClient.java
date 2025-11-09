package com.br.lfmelo.infrastructure.http;

import com.br.lfmelo.adapters.dtos.product.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-core", path = "${url.api.core}")
public interface ProductClient {

    @GetMapping("/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);
}
