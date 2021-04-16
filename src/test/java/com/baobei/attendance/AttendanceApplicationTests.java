package com.baobei.attendance;

import com.baobei.attendance.web.entity.WebUserSearch;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AttendanceApplicationTests {

    @Test
    void contextLoads() {
        WebUserSearch search = new WebUserSearch();
        search.setPageNo(2);
        search.setPageSize(5);
        System.out.println(search.getLimit() + "===" + search.getOffset());
        System.out.println(search);
    }

}
