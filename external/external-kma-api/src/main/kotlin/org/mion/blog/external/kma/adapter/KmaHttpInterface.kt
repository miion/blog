package org.mion.blog.external.kma.adapter

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange

@HttpExchange("https://apihub.kma.go.kr")
interface KmaHttpInterface {

    @GetExchange("/api/typ02/openApi/VilageFcstInfoService_2.0/getUltraSrtNcst")
    fun getVilageFcst(
        @RequestParam pageNo: Int = 1,
        @RequestParam numOfRows: Int = 10,
        @RequestParam dataType: String = "JSON",
        @RequestParam(name = "base_date") baseDate: String,
        @RequestParam(name = "base_time") baseTime: String,
        @RequestParam nx: Int,
        @RequestParam ny: Int,
        @RequestParam authKey: String,
    ): Map<String, Any>
    
}