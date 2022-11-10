package com.example.fibabootcamp1.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferResource {

    @GetMapping("/transfer/header")
    public ResponseEntity<?> getHeader(@RequestHeader(value = "input", defaultValue = "Boş") String input)
    {
        String output = "Giren: " + input;
        System.out.println("Çıktı: " + output);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/transfer/setheader")
    public ResponseEntity<?> setHeader()
    {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("İnput", "Godoro");
//        return ResponseEntity
//                .ok()
//                .headers(httpHeaders)
//                .body("Başlık gönderildi.");
        return ResponseEntity
                .ok()
                .header("İnput", "Godoro")
                .body("Başlık gönderildi.");
    }
}
