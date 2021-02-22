package com.tada.summerboot.component;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

//        UNCOMMENT SNIPPET #2

//        This snippet of code will allow user to
//        go to one page and admin to another page.
//
//

//        boolean isAdmin = false;
//        UserDetails user = (UserDetails) authentication.getPrincipal();
//        Iterator<org.springframework.security.core.GrantedAuthority> grantedAuthorityIterator = (Iterator<GrantedAuthority>) user.getAuthorities().iterator();
//        while (grantedAuthorityIterator.hasNext()) {
//            if (grantedAuthorityIterator.next().getAuthority().equalsIgnoreCase("ADMIN")) {
//                isAdmin = true;
//            }
//        }
//
//        if (isAdmin) { // if isAdmin is true == true.
//            System.out.println("reached /admin");
//            httpServletResponse.sendRedirect("/admin");
//        } else { // if it is false.
//            System.out.println("reached /");
//            httpServletResponse.sendRedirect("/");
//        }


        httpServletResponse.sendRedirect("/");

    }
}
