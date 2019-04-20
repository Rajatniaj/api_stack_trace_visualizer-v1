package com.tgt.api.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by z001t7s on 1/30/18.
 */
@Controller
class IndexController {

    @RequestMapping("/home")
    String index() {

        return "index"
    }
}
