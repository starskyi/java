package com.star;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

//    @Test
//    public void testGen(){
//        Map<String, Object> claims = new HashMap<String, Object>();
//        claims.put("id", 1);
//        claims.put("username", "zhangsan");
//        String token = JWT.create()
//                .withClaim("user", claims)
//                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*60*60*12))
//                .sign(Algorithm.HMAC256("star"));
//
//        System.out.println(token);
//    }
//
//    @Test
//    public void testParse(){
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
//                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6InpoYW5nc2FuIn0sImV4cCI6MTczMjMxODYyM30" +
//                ".9QgWUnJakLEymIxdM3v0XSYfN5tVEiEgxu8uToiyxQM";
//
//        JWTVerifier jwtVerifier =  JWT.require(Algorithm.HMAC256("star")).build();
//        DecodedJWT decodedJWT = jwtVerifier.verify(token);//解析JWT对象
//
//        Map<String, Claim> claims = decodedJWT.getClaims();
//        System.out.println(claims.get("user"));
//    }
}
