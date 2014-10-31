
package com.android.volley;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version 1.0
 */


public class MD5Util 
{ 
    /** 
     * 16锟斤拷锟斤拷锟街凤拷 
     */ 
    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'}; 
 
    /** 
     * 指锟斤拷锟姐法为MD5锟斤拷MessageDigest 
     */ 
    private static MessageDigest messageDigest = null; 
 
    /** 
     * 锟斤拷始锟斤拷messageDigest锟侥硷拷锟斤拷锟姐法为MD5 
     */ 
    static 
    { 
        try 
        { 
            messageDigest = MessageDigest.getInstance("MD5"); 
        } 
        catch(NoSuchAlgorithmException e) 
        { 
            e.printStackTrace(); 
        } 
    } 
 
    
    /** 
     * MD5锟斤拷锟斤拷锟街凤拷 
     * @param str 目锟斤拷锟街凤拷 
     * @return MD5锟斤拷锟杰猴拷锟斤拷�?���?
     */ 
    public static String getMD5String(String str) 
    { 
        return getMD5String(str.getBytes()); 
    } 
 
    /** 
     * MD5锟斤拷锟斤拷锟斤拷byte锟斤拷锟斤拷锟绞撅拷锟斤拷址锟�
     * @param bytes 目锟斤拷byte锟斤拷锟斤拷 
     * @return MD5锟斤拷锟杰猴拷锟斤拷�?���?
     */ 
    public static String getMD5String(byte[] bytes) 
    { 
        messageDigest.update(bytes); 
        return bytesToHex(messageDigest.digest()); 
    } 
     
   
  
 
    /** 
     * 锟斤拷锟街斤拷锟斤拷锟斤拷转锟斤拷锟斤拷16锟斤拷锟斤拷锟街凤拷 
     * @param bytes 目锟斤拷锟街斤拷锟斤拷锟斤拷 
     * @return 转锟斤拷锟斤拷锟�?
     */ 
    public static String bytesToHex(byte bytes[]) 
    { 
        return bytesToHex(bytes, 0, bytes.length); 
    } 
 
    /** 
     * 锟斤拷锟街斤拷锟斤拷锟斤拷锟斤拷指锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷转锟斤拷锟斤拷16锟斤拷锟斤拷锟街凤拷 
     * @param bytes 目锟斤拷锟街斤拷锟斤拷锟斤拷 
     * @param start 锟斤拷始位锟矫ｏ拷锟斤拷锟斤拷锟斤拷位锟矫ｏ�?
     * @param end 锟斤拷锟斤拷位锟矫ｏ拷锟斤拷锟斤拷锟斤拷锟斤拷位锟矫ｏ拷 
     * @return 转锟斤拷锟斤拷锟�?
     */ 
    public static String bytesToHex(byte bytes[], int start, int end) 
    { 
        StringBuilder sb = new StringBuilder(); 
 
        for(int i = start; i < start + end; i++) 
        { 
            sb.append(byteToHex(bytes[i])); 
        } 
 
        return sb.toString(); 
    } 
 
    /** 
     * 锟斤拷锟斤拷锟斤拷锟街斤拷锟斤拷转锟斤拷锟斤�?6锟斤拷锟斤拷锟街凤拷 
     * @param bt 目锟斤拷锟街斤拷 
     * @return 转锟斤拷锟斤拷锟�?
     */ 
    public static String byteToHex(byte bt) 
    { 
        return HEX_DIGITS[(bt & 0xf0) >> 4] + "" + HEX_DIGITS[bt & 0xf]; 
    } 
 
  
}  
