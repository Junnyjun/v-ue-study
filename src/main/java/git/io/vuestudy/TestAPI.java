package git.io.vuestudy;

import git.io.vuestudy.model.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static git.io.vuestudy.model.ResponseUtil.failure;
import static git.io.vuestudy.model.ResponseUtil.success;

@RestController
@RequestMapping("/api")
public class TestAPI {

    @GetMapping("/get")
    public ApiModel get(
            String data1,
            Long data2,
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data3
    ){
        System.out.println("data1 = " + data1);
        System.out.println("data2 = " + data2);
        System.out.println("data3 = " + data3);
        return success(Request.get());
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
    static
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

        @Builder
        public Request(String data1, Long data2, String data3) {
            this.data1 = data1;
            this.data2 = data2;
            this.data3 = data3;
        }

        public static List<Request> get(){
            Request data1 = Request.builder()
                    .data1("d1")
                    .data2(1L)
                    .data3("dd1")
                    .build();
            Request data2 = Request.builder()
                    .data1("d2")
                    .data2(2L)
                    .data3("dd2")
                    .build();
            Request data3 = Request.builder()
                    .data1("d3")
                    .data2(3L)
                    .data3("dd3")
                    .build();

            return List.of(data1,data2,data3);
        }
    }
}
