package com.softgroup.server.rest.security.filter;

import com.softgroup.common.exceptions.TokenException;
import com.softgroup.token.api.JwtUserIdentifier;
import com.softgroup.token.api.TokenGeneratorService;
import com.softgroup.token.api.TokenType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private Log log = LogFactory.getLog(JwtAuthenticationTokenFilter.class);

    @Autowired
    private TokenGeneratorService tokenService;

    private static final String TOKEN_HEADER = "token";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        JwtUserIdentifier userIdentifier;

        try{
            //get token from header
            String authToken = request.getHeader(TOKEN_HEADER);
            if(authToken == null){
                //get token from request parameter
                authToken = request.getParameter(TOKEN_HEADER);
            }
            if(authToken != null){
                //check token and get user ids
                userIdentifier = tokenService.getUserIdentifier(authToken, TokenType.SHORT_TERM);
                //if no exception - save ids to Security Context Holder
                if ( SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userIdentifier, null, null);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

        }catch (TokenException exception){
            log.error("An error occurred. Token is invalid. ",exception);

        }finally {
            //filter anyway
            chain.doFilter(request, response);
        }
    }
}