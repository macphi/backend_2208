package t3h.vn.backend_2208.controller;

import org.springframework.web.bind.annotation.*;
import t3h.vn.backend_2208.db.DbUtils;
import t3h.vn.backend_2208.dto.Book;

import java.sql.SQLException;

@RestController // Giao thức http, resp api

// Định nghĩa là 1 controller

public class HelloController {
    // Mapping đường dẫn controller
//    @RequestMapping(method = RequestMethod.GET, value = "get")
    @GetMapping("get")
    public String get() {
        return "get";
    }

    @GetMapping("get/{id}")
    public Book getId(@PathVariable Long id,
                      @RequestParam(required = false) String name) throws SQLException {
        return DbUtils.getAllById(id);
    }

    @PostMapping("post") // Sử dụng trong tạo mới dữ liệu
    public String post(@RequestBody Book body) throws SQLException {
        DbUtils.insertBook(body);
        return "Thêm mới thành công";
    }

    @PutMapping("put") // Sử dụng trong phần sửa dữ liệu
    public String put() {
        return "put";
    }

    @DeleteMapping("delete") //Xóa dữ liệu
    public String delete() {
        return "delete";
    }
}
