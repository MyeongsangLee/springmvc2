package hello.typeconverter.controller;


import hello.typeconverter.converter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); //문자 타입 조회
        Integer intValue = Integer.valueOf(data); //숫자 타입으로 변경
        System.out.println("intValue = " + intValue);
        return "ok";
    }


    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        log.info("ipPort IP={}", ipPort.getIp());
        log.info("ipPort Port={}", ipPort.getPort());
        return "ok";
    }

    @GetMapping("/ip-port1")
    public String ipPort1(@ModelAttribute IpPort ipPort) {
        log.info("ipPort IP={}", ipPort.getIp());
        log.info("ipPort Port={}", ipPort.getPort());
        return "ok";
    }
}
