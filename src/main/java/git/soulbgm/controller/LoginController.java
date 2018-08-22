package git.soulbgm.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import git.soulbgm.pojo.User;
import git.soulbgm.util.JacksonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 贺瑞杰
 * @version V1.0
 * @date 2018-08-22 16:43
 * @description
 */
@RestController
public class LoginController {

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, @RequestParam String username) {
        request.getSession().removeAttribute("user");
        return "logout success";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        if ("zhangsan".equals(username) && "123".equals(password)) {
            User user = new User(username, password);
            request.getSession().setAttribute("user", user);
            return "login success";
        } else {
            return "login fail";
        }
    }

    @RequestMapping("select")
    public String select(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "请先登录";
        } else {
            return JacksonUtil.toJson(user);
        }
    }

}
