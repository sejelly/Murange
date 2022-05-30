package teamMurange.Murange.controller;
import teamMurange.Murange.config.auth.LoginUser;
import teamMurange.Murange.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    //private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
//        // userName을 사용할 수 있게 model에 저장
//        // SessionUser user = (SessionUser) httpSession.getAttribute("user"); @LoginUser로 개선
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
        return "login";
    }
    @GetMapping("/google2")
    public String google2(Model model, @LoginUser SessionUser user)
    {
//        // userName을 사용할 수 있게 model에 저장
//        // SessionUser user = (SessionUser) httpSession.getAttribute("user"); @LoginUser로 개선
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
        return "google2";
    }


}
