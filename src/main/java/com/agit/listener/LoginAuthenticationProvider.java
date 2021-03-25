package com.agit.listener;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.agit.entity.security.JdcAdpMstUser;
import com.agit.util.PluginOpenFire;
import com.agit.services.AdpAdminService;
import com.agit.services.AdpGenericService;

/**
 *
 * @author Ridwan
 */
@Component("authenticationProvider")
public class LoginAuthenticationProvider implements AuthenticationProvider {

    /**
     *
     */
    @Autowired
	protected AdpAdminService adminService;

    /**
     *
     */
    @Autowired
	protected AdpGenericService genericService;

	PluginOpenFire openFire;

    /**
     *
     * @param authentication
     * @return
     * @throws org.springframework.security.core.AuthenticationException
     */
    @Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		JdcAdpMstUser user = adminService.getSecUser(username);
                String passwordEncode = adminService.encodePassword(password);
                if (StringUtils.equals(passwordEncode, user.getUsrPassword())) {
				adminService.resetFailAttempts(username);
				Collection<? extends GrantedAuthority> authorities = getGrantedAuthority(user);
				return new UsernamePasswordAuthenticationToken(user, password, authorities);
			} else {
				throw new BadCredentialsException("Please input correct username and password");
			}

//before
//		if (user == null) {
//			throw new BadCredentialsException("Please input correct username and password");
//		} else if (!user.getEnabled().equalsIgnoreCase("Active")) {
//			throw new BadCredentialsException("User is not active. Please contact your administrator.");
//		} else {
//			String passwordEncode = adminService.encodePassword(password);
//			if (StringUtils.equals(passwordEncode, user.getUsrPassword())) {
//				adminService.resetFailAttempts(username);
//				Collection<? extends GrantedAuthority> authorities = getGrantedAuthority(user);
//				return new UsernamePasswordAuthenticationToken(user, password, authorities);
//			} else {
//				throw new BadCredentialsException("Please input correct username and password");
//			}
//		}
	}

    /**
     *
     * @param authentication
     * @return
     */
    @Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	private Collection<GrantedAuthority> getGrantedAuthority(JdcAdpMstUser user) {

		Collection<String> rights = null;

		if (user.getUsrType().equalsIgnoreCase(JdcAdpMstUser.SUPER_ADMIN)) {
			rights = adminService.getAllRights();
		} else {
			rights = adminService.getRightsByUser(user);
		}

		ArrayList<GrantedAuthority> rechteGrantedAuthorities = new ArrayList<GrantedAuthority>(rights.size());

		for (String right : rights) {
			rechteGrantedAuthorities.add(new GrantedAuthorityImpl(right));
		}

		return rechteGrantedAuthorities;
	}

	class GrantedAuthorityImpl implements GrantedAuthority {

		private static final long serialVersionUID = 1L;

		private String role;

		public GrantedAuthorityImpl(String role) {
			this.role = role;
		}

		public String getAuthority() {
			return role;
		}
	}
}
