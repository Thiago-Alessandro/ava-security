//package br.org.sesisenai.ava.security.filter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
////@Component
//@AllArgsConstructor
//public class AuthFilter extends OncePerRequestFilter {
//
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain) throws ServletException, IOException {
//        System.out.println(request);
//        System.out.println("olha q eu vou printar hein");
//        System.out.println(request.getUserPrincipal());
//    }
//}