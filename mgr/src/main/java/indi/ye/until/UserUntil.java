package indi.ye.until;

import indi.ye.pojo.UserPojo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: UserUntil
 * @Description: 用户工具类
 * @Author: Lucius Pan
 * @Date: 2023/6/7 14:06
 */
public class UserUntil {
    public static String getToken(UserPojo userPojo){
        JwtBuilder builder = Jwts.builder();
//            builder.signWith(SignatureAlgorithm.HS256,"lucius");
        builder.setId( userPojo.getUser_name());
        builder.setSubject(userPojo.getUser_pwd());
        builder.setExpiration(new Date(new Date().getTime()+60*1000));
        builder.setIssuedAt(new Date());
        builder.claim("role","user");
        String token = builder.compact();
        return token;
    }

    public static Claims decryptToken(String token){
        Claims body = Jwts.parser().parseClaimsJwt(token).getBody();
        return body;
    }

    public static String getDateString(Long dateStamp){
        return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateStamp);
    }

    public static Boolean checkExpired(Date date){
        Date now = new Date();
        if (now.getTime() > date.getTime()){
            return false;
        }else {
            return true;
        }

    }


}
