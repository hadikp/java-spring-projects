package marketplace.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.comment.Comment;
import marketplace.comment.CommentDto;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String productName;
    private String description;
    private Type productType;
    private Category category;
    private Boolean active;
    private String imagePath;
    private int price;
    private List<CommentDto> commentDtoList = new ArrayList<>();
}
