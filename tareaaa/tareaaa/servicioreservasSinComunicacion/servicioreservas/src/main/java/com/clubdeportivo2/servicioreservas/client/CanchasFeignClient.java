package com.clubdeportivo2.servicioreservas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serviciocanchas", url = "${serviciocanchas.url:http://localhost:8081}", path = "/api/canchas")
public interface CanchasFeignClient {

    @GetMapping
    List<CanchasDto> listCanchas();

    @GetMapping("/{id}")
    CanchasDto getCanchaById(@PathVariable("id") Long id);
}
