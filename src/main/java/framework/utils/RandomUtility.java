package framework.utils;

public class RandomUtility {
    private final static int POSITION = 97;
    private final static int NUMBER_OF_LETTERS = 26;

    public static String getRandomString(int length){
        String s="";
        for (int i = 0; i < length; i++){
            s += (String.valueOf((char)((int) ( POSITION + Math.random()*NUMBER_OF_LETTERS))));
        }
        return  s;
    }

    public static int getRandomInt(int maxValue){
        return  (int) (Math.random()*maxValue);
    }
}
