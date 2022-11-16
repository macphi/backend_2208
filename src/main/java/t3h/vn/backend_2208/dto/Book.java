package t3h.vn.backend_2208.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // Tự động gen rahafafm getter setter
@AllArgsConstructor // Khởi tạo constructor
@NoArgsConstructor  // Constructor không tham số
@ToString //
public class Book {
    Long id;
    String name;
    String author;
}
