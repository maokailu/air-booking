package com.cumt.utils;

import com.sun.org.apache.bcel.internal.classfile.Constant;
import com.sun.org.apache.bcel.internal.classfile.ConstantClass;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-05-29.
 */
public class JWT {
    /**
     * 创建jwt
     * @param id
     * @param subject
     * @param ttlMillis 过期的时间长度
     * @return
     * @throws Exception
     */
//    public String createJWT(String id, String subject, long ttlMillis) throws Exception {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//        Map<String,Object> claims = new HashMap<String,Object>();
//        claims.put("uid", "DSSFAWDWADAS...");
//        claims.put("user_name", "admin");
//        claims.put("nick_name","DASDA121");
//        SecretKey key = generalKey();
//        JwtBuilder builder = Jwts.builder()
//                .setClaims(claims)
//                .setId(id)
//                .setIssuedAt(now)
//                .setSubject(subject)
//                .signWith(signatureAlgorithm, key);
//        if (ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp);
//        }
//        return builder.compact();
//    }
//    public Claims parseJWT(String jwt) throws Exception {
//        SecretKey key = generalKey();
//        Claims claims = Jwts.parser()
//                .setSigningKey(key)
//                .parseClaimsJws(jwt).getBody();
//        return claims;
//    }
//    public SecretKey generalKey() throws Base64DecodingException {
//        String stringKey = Constant.JWT_SECRET;
//        byte[] encodedKey = Base64.decode(stringKey);
//        System.out.println(encodedKey);//[B@152f6e2
//        System.out.println(Base64.encode(encodedKey));
//        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
//        return key;
//    }
}
