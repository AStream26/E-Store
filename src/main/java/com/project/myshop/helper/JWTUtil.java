package com.project.myshop.helper;

import com.nimbusds.jose.*;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public class JWTUtil {
    private static final String SECRET_KEY = "@7383627823nsnshsauavhauv-jkhefb##IAEFWEHF33222222JSJSDJFDUI3RBKJAsjaa";
     
    public static  final String createJWT(String userId,long expirationTime) throws JOSEException{
        
        JWSSigner signer = new MACSigner(SECRET_KEY);
        
        Date now = new Date();
        Date expTime = new Date(now.getTime() + (expirationTime * 1000));
        
        JWTClaimsSet claim = new JWTClaimsSet.Builder().subject(userId).issueTime(now).expirationTime(expTime).build();
        
        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claim);
        
        signedJWT.sign(signer);
        
        return signedJWT.serialize();
        
    }
    
    public static final JWTClaimsSet parseJWT(String token){
        
       
        JWTClaimsSet claims = null;
        SignedJWT signedJWT = null;
        try{
            System.out.println(token);
            signedJWT = SignedJWT.parse(token);

            JWSVerifier verifier = new MACVerifier(SECRET_KEY);

            if(!signedJWT.verify(verifier)){
                return null;
            }   
            claims = signedJWT.getJWTClaimsSet();
        }
        catch(ParseException | JOSEException exp){
            System.out.println(exp.getMessage());   
        }
        return claims;
    }
    
    public static  final boolean isValid(JWTClaimsSet claimSet){
        
        try{    
            Date expTime = claimSet.getExpirationTime();
            
            if(expTime!= null && expTime.before(new Date())){
                // token expired
                return false;
            }
        }
        catch(Exception exp){
            exp.getMessage();
            return false;
        }
        return true;        
    }
}
