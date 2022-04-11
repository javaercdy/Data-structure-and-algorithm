package link;

import java.util.LinkedList;

/**
 * @author chenDY
 * @create 2022-03-29-14:54
 */
public class LinkReverse {


    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>();

        linkList.add("陈公子");
        linkList.add("然矣");
        linkList.add("书稿先生");
        linkList.add("程序员");

        for (String s : linkList) {
            System.out.println(s);
        }
        System.out.println("****************************");

        linkList.reserve();
        for (String s : linkList) {
            System.out.println(s);
        }
        System.out.println("****************************");

    }


}
