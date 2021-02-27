package com.tada.summerboot.component;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//    public SuccessHandler() {
//        super();
//        setUseReferer(true);
//    }

//    @Bean
//    public AuthenticationSuccessHandler successHandler() {
//        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
//        handler.setUseReferer(true);
//        return handler;
//    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
<<<<<<< Updated upstream
        // After login, go to homepage
        httpServletResponse.sendRedirect("/");
=======

        super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);

//        UNCOMMENT SNIPPET #2

//        This snippet of code will allow user to
//        go to one page and admin to another page.
//
//

        boolean isAdmin = false;
        UserDetails user = (UserDetails) authentication.getPrincipal();
        Iterator<org.springframework.security.core.GrantedAuthority> grantedAuthorityIterator = (Iterator<GrantedAuthority>) user.getAuthorities().iterator();
        while (grantedAuthorityIterator.hasNext()) {
            if (grantedAuthorityIterator.next().getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
                isAdmin = true;
            }
        }

        if (isAdmin) { // if isAdmin is true == true.
            System.out.println("reached /admin");
            httpServletResponse.sendRedirect("/admin");
        } else { // if it is false.
            System.out.println("reached /");
            httpServletResponse.sendRedirect("/");
        }

//        httpServletResponse.sendRedirect("/");

>>>>>>> Stashed changes
    }
}
