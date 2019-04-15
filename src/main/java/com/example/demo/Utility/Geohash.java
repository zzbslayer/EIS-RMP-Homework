package com.example.demo.Utility;

import com.example.demo.Config.CONSTANT;

public class Geohash {


    public static int DEFAULT_LENGTH = 6;
    public static int DEFAULT_MATCH_LENGTH = 4;

    public static String geohash(double longitude, double latitude, int length) {
        assert(longitude >= CONSTANT.MIN_LONGITUDE && longitude <= CONSTANT.MAX_LONGITUDE);
        assert(latitude >= CONSTANT.MIN_LATITUDE && latitude <= CONSTANT.MAX_LATITUDE);
        assert(length % 2 == 0);
        int bit = length * 5;
        long encoded_longitude = encode(longitude, CONSTANT.MAX_LONGITUDE, CONSTANT.MIN_LONGITUDE, bit / 2);
        long encoded_latitude = encode(latitude, CONSTANT.MAX_LATITUDE, CONSTANT.MIN_LATITUDE, bit / 2);
        long merged_val = merge(encoded_longitude, encoded_latitude, bit / 2);
        StringBuilder sb = new StringBuilder();
        while (bit > 0){
            int char_val = (int)((merged_val >> (bit - 5)) & (~((-1) << 5))); // only 5 bit
            char c = base32(char_val);
            sb.append(c);
            bit -= 5;
            //merged_val = merged_val >> 5;
        }
        return sb.toString();
    }

    public static boolean match(String geo1, String geo2, int matchLength){
        char[] ch1 = geo1.toCharArray();
        char[] ch2 = geo2.toCharArray();
        int minLength = Math.min(geo1.length(), geo2.length());
        if (minLength < matchLength)
            return false;

        int cnt = 0;
        while(cnt < matchLength){
            //System.out.println(ch1[cnt]+ "\t" +ch2[cnt]);
            if (ch1[cnt] != ch2[cnt])
                return false;
            cnt++;
        }
        return true;
    }

    private static char base32(int val){
        assert(val >= 0 && val < 32);
        if (val < 26){
            return (char)(val + 'A');
        }
        else{
            return (char)(val - 26 + '2');
        }
    }

    private static long merge(long encoded_longitude, long encoded_latitude, int bit){
        long merged_val = 0;
        while(bit > 0){
            merged_val = merged_val << 1;
            merged_val += (encoded_longitude >> (bit - 1));
            merged_val = merged_val << 1;
            merged_val += (encoded_latitude >> (bit -1));
            bit--;
        }
        return merged_val;
    }

    private static long encode(double value, double max, double min, int bit){
        assert (bit > 0);
        long res = 0;
        while(bit > 0){
            int temp;
            double half = (max + min) / 2 ;
            if (value > half) {
                temp = 1;
                min = half;
            }
            else {
                temp = 0;
                max = half;
            }
            //System.out.println("temp: "+temp);
            //System.out.println("res << 1: "+ (res << 1));
            res = (res << 1) + temp;
            //System.out.println("res: "+Long.toBinaryString(res));

            bit--;
        }
        return res;
    }

    public static void main(String[] args) {
        //long val = encode(39.928167, MAX_LATITUDE, MIN_LATITUDE, DEFAULT_BIT);
        //System.out.println(Long.toBinaryString(val));
        String sjtu = geohash(31.0256330000,121.4370940000, DEFAULT_LENGTH);
        System.out.println("SJTU: "+sjtu);
        String ecnu = geohash(31.0308360000,121.4543590000, DEFAULT_LENGTH);
        System.out.println("ECNU: "+ecnu);
        String fdu = geohash(31.2971820000, 121.5032020000, DEFAULT_LENGTH);
        System.out.println("FDU: "+fdu);
        String jpr = geohash(31.0111510000, 121.4100560000, DEFAULT_LENGTH);
        System.out.println("JP Road: "+jpr);
        String dcr = geohash(31.0183190000, 121.4198680000, DEFAULT_LENGTH);
        System.out.println("DC Road: "+dcr);

        System.out.println(match(sjtu, fdu, DEFAULT_LENGTH-1));
    }
}
