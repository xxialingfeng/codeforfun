package clab8;

public class RabinKarpAlgorithm {
    public static int rabinKarp(String input, String pattern){
        if(input.length() < pattern.length()){
            return -1;
        }
        String patternLengthInput = input.substring(0,pattern.length());
        RollingString inputRolling = new RollingString(patternLengthInput,pattern.length());
        RollingString patternRolling = new RollingString(pattern, pattern.length());
        int ideal = patternRolling.hashCode();
        for(int i = pattern.length(); i <= input.length(); i++){
            if(inputRolling.hashCode() == ideal){
                return 1;
            }else{
                if(i != input.length()){
                    inputRolling.addChar(input.charAt(i));
                }
            }
        }
        return -1;
    }
}
