package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/list")
    public String list(HttpServletRequest request) {
        if(!loginCheck(request))
            return "redirect:/login/login?toURL="+request.getRequestURL();
        return "boardList";
    }

    private boolean loginCheck(HttpServletRequest request) {
        //1. 세션을 얻어서
        HttpSession session = request.getSession();
        //2. 세션에 id가 있는지 확인. 있으면 true 반환.
//        if(session.getAttribute("id")!=null)
//            return true;
//        else
//            return false;
        return session.getAttribute("id")!=null; //위 4줄과 같다.
    }
}

