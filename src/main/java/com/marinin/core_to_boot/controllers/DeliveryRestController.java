package com.marinin.core_to_boot.controllers;

import com.marinin.core_to_boot.service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryRestController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryRestController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/drest/delivery/test_get")
    public ResponseEntity<String> getTest() {
        deliveryService.getMathApi();
        return new ResponseEntity<>("Get test is OK", HttpStatus.OK);
    }

    @PostMapping("/drest/delivery/test_post")
    public ResponseEntity<String> postTest(@RequestBody String str) {
        if (str.length() > 2) {
            deliveryService.getMathApi(Long.valueOf(str.substring(1, str.length() - 1)));
        }

        return new ResponseEntity<>("Post test is OK", HttpStatus.OK);
    }

    @GetMapping("/drest/delivery/test_get_dost")
    public ResponseEntity<String> getDostTest() {
        deliveryService.dost1();
        return new ResponseEntity<>("Get DOST test is OK", HttpStatus.OK);
    }

    @PostMapping("/drest/delivery/test_post_dost")
    public ResponseEntity<String> getDostTest(@RequestBody String str) {
        if (str.length() > 2) {
            deliveryService.doDost(Long.valueOf(str.substring(1, str.length() - 1)));
        }
        return new ResponseEntity<>("Get DOST test is OK", HttpStatus.OK);
    }

}
