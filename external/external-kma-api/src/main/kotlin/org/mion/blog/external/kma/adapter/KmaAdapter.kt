package org.mion.blog.external.kma.adapter

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "kma",
    url = "https://apihub.kma.go.kr"
)
interface KmaAdapter {

    @GetMapping("/api/typ02/openApi/VilageFcstInfoService_2.0/getUltraSrtNcst")
    fun getVilageFcst(
        @RequestParam pageNo: Int = 1,
        @RequestParam numOfRows: Int = 1,
        @RequestParam dataType: String = "JSON",
        @RequestParam(name = "base_date") baseDate: String,
        @RequestParam(name = "base_time") baseTime: String,
        @RequestParam nx: Int,
        @RequestParam ny: Int,
        @RequestParam authKey: String,
    ): Map<String, String>
}