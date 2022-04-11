package Algorithm;

/**
 * @author chenDY
 * @create 2022-04-05-19:32
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String str1="早知惊鸿一场,何必情深以往.";
        String str2="情深以往";

        System.out.println("index="+match(str1, str2));

        String str3="早知惊鸿一场,何必情深以往.";
        String str4="以往~";

        System.out.println("index="+match(str3, str4));
    }

    private static int match(String str1, String str2) {

        char[] c1=str1.toCharArray();
        char[] c2=str2.toCharArray();

        int len1 = str1.length();
        int len2 = str2.length();

        int i=0;
        int j=0;

        while (i<len1&&j<len2){
            if (c1[i]==c2[j]){
                i++;
                j++;
            }else{
                i=i-(j-1);
                j=0;
            }
        }

        if (j==len2){
            return i-j;
        }else{
            return  -1;
        }

    }
}
