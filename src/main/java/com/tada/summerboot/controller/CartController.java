package com.tada.summerboot.controller;

import com.tada.summerboot.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class CartController {

    @Autowired
    CartServiceImpl cartServiceImpl;
}
