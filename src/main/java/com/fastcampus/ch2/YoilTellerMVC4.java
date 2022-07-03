package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTellerMVC4 {
    @ExceptionHandler
    public String catcher(Exception ex) {
        ex.printStackTrace();
        return "yoilError";
    }
    @RequestMapping("/getYoilMVC4")
    //반환타입이 void면 view의 이름은 맵핑된 URL의 끝단어와 같다.
    //반환타입을 ModelAndView로 할 수도 있다.
    public String main(MyDate date, Model model) throws IOException {

        //1. 유효성 검사
        if(!isValid(date))
            return "yoilError";

        //2. 요일 계산
        char yoil = getYoil(date);

        //3. 계산된 결과를 Model에 저장
        model.addAttribute("myDate", date);
        model.addAttribute("yoil", yoil);

        return "yoil";
    }

    private boolean isValid(MyDate date) {
        return isValid(date.getYear(), date.getMonth(), date.getDay());
    }

    private char getYoil(MyDate date) {
        return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }

    private boolean isValid(int year, int month, int day) {
        return true;
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
}