package com.softgroup.server.rest.security.filter;

import com.softgroup.token.api.JwtUserIdentifier;
import com.softgroup.token.api.TokenGeneratorService;
import com.softgroup.token.api.TokenType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenGeneratorService jwtTokenUtil;

    private String tokenHeader = "token";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        JwtUserIdentifier userIdentifier = null;
        String authToken = request.getHeader(this.tokenHeader);
        if(authToken == null){
            authToken = request.getParameter(this.tokenHeader);
        }
        if(authToken != null){
            userIdentifier = jwtTokenUtil.getUserIdentifier(authToken, TokenType.SHORT_TERM);
        }


        if (userIdentifier != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userIdentifier, null, null);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }

        chain.doFilter(request, response);
    }
}