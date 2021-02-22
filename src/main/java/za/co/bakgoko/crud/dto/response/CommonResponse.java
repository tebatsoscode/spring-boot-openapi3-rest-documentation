package za.co.bakgoko.crud.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResponse {
    private Boolean success;
    private String message;
    private int code;
    private HttpStatus httpStatus;
    private String type;
}
