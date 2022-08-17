package com.medical.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.medical.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * token有效时间
     */
    private static final Long EXPIRE_TIME = 60 * 60 * 1000L;

    /**
     * 密钥
     */
    private static final String SECRET = "SHI XUN";

    /**
     * 根据用户信息生成token
     *
     * @param user 用户实体
     * @return 根据用户生成的token
     */
    public static String generateToken(User user) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<String, Object>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userinfo", JSONObject.toJSONString(user))
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            logger.error("generate token occur error, error is:{0}", e);
            return null;
        }
    }

    /**
     *  根据token获取用户信息
     *
     * @param token 系统生成的token
     * @return 用户实体类
     */
    public static User getUserInfoByToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJwt = verifier.verify(token);
            String userinfo = decodedJwt.getClaim("userinfo").asString();
            return JSON.parseObject(userinfo, User.class);
        } catch (Exception e) {
            logger.error("getUserInfoByToken error! {0}", e);
            return null;
        }
    }

    /**
     * 判断token是否过期
     * @param token 传入token
     * @return token是否过期
     */
    public static boolean isExpire(String token) {
        DecodedJWT decodedJwt = JWT.decode(token);
        return decodedJwt.getExpiresAt().getTime() < System.currentTimeMillis();
    }
}
