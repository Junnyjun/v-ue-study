package git.io.vuestudy;

import git.io.vuestudy.model.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static git.io.vuestudy.model.ResponseUtil.failure;
import static git.io.vuestudy.model.ResponseUtil.success;

@RestController
@RequestMapping("/api")
public class TestAPI {

    @GetMapping("/get")
    public ApiModel get(
            @RequestParam String data1,
            @RequestParam Long data2,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data3
    ){

        return success("GET");
    }
    @PostMapping("/post")
    public ApiModel post(@RequestBody Request request){
        System.out.println("request = " + request.toString());
        return success("POST");
    }
    @GetMapping("/error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiModel error(){

        return failure(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    @NoArgsConstructor
    class Request{
        private String data1;
        private Long data2;
        private String data3;

        @Override
        public String toString() {
            return "Request{" +
                    "data1='" + data1 + '\'' +
                    ", data2=" + data2 +
                    ", data3='" + data3 + '\'' +
                    '}';
        }
    }
}
