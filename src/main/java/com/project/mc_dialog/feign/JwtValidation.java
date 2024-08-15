package com.project.mc_dialog.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "JwtValidation", url = "http://localhost:8086/api/v1/auth")
public interface JwtValidation {

    @GetMapping("/check-validation")
    Boolean validateToken(@RequestParam("token") String token);
}