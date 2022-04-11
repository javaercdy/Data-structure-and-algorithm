package Algorithm;

/**
 * @author chenDY
 * @create 2022-04-05-21:26
 */
public class Next {

    public static void main(String[] args) {
        String s1="aabaaf";
        String s2="aabaabsdaaasaabaafsadad";

        int i = kmpSearch(s2, s1);
        System.out.println(i);
    }


    public void getNext(int[] next, String s) {

        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static int[] getNext(String s){
        int[] next = new int[s.length()];
        next[0]=0;

        for (int i=1,j=0;i<s.length();i++){
            while(j>0&&s.charAt(i)!=s.charAt(j)){
                j=next[j-1];
            }

            if (s.charAt(j)==s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }


    public static int kmpSearch(String text,String patten){
        if (patten.length()==0){
            return 0;
        }
        int[] next = getNext(patten);

        for (int i=0,j=0;i<text.length();i++){

            while(j>0&&text.charAt(i)!=patten.charAt(j)){
                j=next[j-1];
            }


            if (text.charAt(i)==patten.charAt(j)){
                j++;
            }

            if (j==patten.length()){
                return i-j+1;
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return (i -j + 1);
            }
        }

        return -1;
    }
}
