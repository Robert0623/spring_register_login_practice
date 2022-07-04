package com.fastcampus.ch2;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @InitBinder
    public void toDate(WebDataBinder binder) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
        binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));
    }

    //    @RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/add")
    public String register() {
        return "registerForm"; // WEB-INF/views/registerForm.jsp
    }

    //    @RequestMapping("register/save", method= RequestMethod.POST) //아래와 동일.
    @PostMapping("/save") //spring 4.3부터 @PostMapping 사용 가능.
    public String save(User user, BindingResult result, Model m) throws Exception {
        System.out.println("result = " + result);
        System.out.println("user = " + user);
        //1. 유효성 검사
        if(!isValid(user)) {
            //브라우져에서는 자동으로 인코딩을 해주지만,
            //컨트롤러에서는 수동으로 인코딩 해줘야 한다.
            String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//            return "redirect:/register/add?msg="+msg; //URL재작성 //아래 2줄과 같다.
            m.addAttribute("msg", msg); //모델이 msg를 담아서 넘겨준다.
//            return "redirect:/register/add"; //redirect는 모델을 넘겨줄 수 없지만, 위처럼 스프링이 자동으로 URL재작성을 해준다.
            return "forward:/register/add";
        }

        //2. DB에 신규회원 정보를 저장

        return "registerInfo";
    }

    private boolean isValid(User user) {
        return  true;
    }
}
