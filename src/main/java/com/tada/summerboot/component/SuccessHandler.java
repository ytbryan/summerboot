package com.tada.summerboot.component;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@Component
public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        // if there is referral
        super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);

        // else, redirect to its respective page
        //        UNCOMMENT SNIPPET #2
        //        This snippet of code will allow user to
        //        go to one page and admin to another page.

        boolean isAdmin = false;
        UserDetails user = (UserDetails) authentication.getPrincipal();
        Iterator<GrantedAuthority> grantedAuthorityIterator = (Iterator<GrantedAuthority>) user.getAuthorities().iterator();
        while (grantedAuthorityIterator.hasNext()) {
            if (grantedAuthorityIterator.next().getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
                isAdmin = true;
            }
        }

        if (isAdmin) {
            System.out.println("reached /admin");
            httpServletResponse.sendRedirect("/admin");
        } else {
            System.out.println("reached /");
            httpServletResponse.sendRedirect("/");
        }

    }
}
