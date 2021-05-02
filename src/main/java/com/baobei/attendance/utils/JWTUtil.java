package com.baobei.attendance.utils;


import io.jsonwebtoken.*;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class JWTUtil {
    /**
     * 创建秘钥
     */
    private static final String SECRET = "zzdaisuki";

    /**
     * 过期时间5分钟
     */
    private static final long EXPIRE_TIME = 1000 * 60 * 5;

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    /**
     * 生成Token
     *
     * @param claims
     * @return
     */
    public static String generateToken(Map<String, Object> claims) {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Date exp = new Date(nowMillis + EXPIRE_TIME);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SIGNATURE_ALGORITHM, SECRET);
        return builder.compact();
    }

    /**
     * 解析token
     * 过期会抛异常
     *
     * @param token
     * @return
     */
    public static Claims parseToken(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}
