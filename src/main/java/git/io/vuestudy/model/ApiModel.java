package git.io.vuestudy.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ApiModel<T extends Object> implements Serializable {
    private LocalDateTime timestamp;
    private String message;
    private boolean isSuccess;
    private int errorId;
    private int statusCode;
    private T body;

    @Builder
    public ApiModel(String message, boolean isSuccess, int errorId, int statusCode, T body) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.isSuccess = isSuccess;
        this.errorId = errorId;
        this.statusCode = statusCode;
        this.body = body;
    }
}
