package com.lex418.springsecurity.security.filters;

import com.lex418.springsecurity.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFilter implements Filter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var httpResponse= (HttpServletResponse) response;
        String authorization =httpRequest.getHeader("Authorization");
        var a = new CustomAuthentication(authorization,null);

        try{
            Authentication result = authenticationManager.authenticate(a);
            if(result.isAuthenticated()){
                SecurityContextHolder.getContext().setAuthentication(result);
                filterChain.doFilter(request,response);
            } else{
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        }catch (AuthenticationException e){
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }

    @Override
    public void destroy() {

    }
}
