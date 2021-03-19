package com.agit.listener;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.agit.controller.administration.model.AdpMenuModel;
import com.agit.entity.security.JdcAdpMstUser;
import com.agit.services.AdpAdminService;
import com.agit.services.AdpGenericService;

/**
*
* @author Ridwan
*/
@SuppressWarnings("unused")
@Component("authenticationSuccessHandler")
public class AuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private AdpAdminService adminService;

	@Autowired
	private AdpGenericService genericService;
	
    /**
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws javax.servlet.ServletException
     */
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		JdcAdpMstUser secUser 	= adminService.getSecUser(((JdcAdpMstUser) authentication.getPrincipal()).getUsrLogin());
		HttpSession session = request.getSession();
		session.setAttribute("loginSecUser", secUser);
		if(secUser.getUsrType().equalsIgnoreCase(JdcAdpMstUser.SUPER_ADMIN)){
			session.setAttribute("menuList", adminService.getAllMenuModelByUser(secUser));
		}else{
			session.setAttribute("menuList", adminService.getAllMenuModel(secUser));
		}
		
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	
}
