package com.agit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agit.entity.security.JdcAdpMstUser;

/**
 *
 * @author Ridwan
 */
@Controller
public class IndexController extends BaseController {

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        JdcAdpMstUser user = this.getLoginSecUser(session);
        
        if(user.getUsrType().equalsIgnoreCase("ADMIN")){
        	return "redirect:/administration/user/";
        }else{
        	return "01.misc/blank";
        }
        
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "01.misc/login";
    }

    /**
     *
     * @param request
     * @return
     */
    @SuppressWarnings("unused")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {

        String activity = "LOGOUT";
        long moduleId = 2002;

        return "redirect:j_spring_security_logout";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String _404() {
        return "01.misc/404";
    }
}
