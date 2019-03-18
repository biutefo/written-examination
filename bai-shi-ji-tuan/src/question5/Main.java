package question5;

import java.util.Random;

/**
 * 寻找10的长度为100的字符串的最长公共字符串
 *
 * @author xin
 * @create 2019-03-13 9:18 AM
 **/
public class Main {
    //10的话公共子字符串的长度过短测试方法可以减少数组个数或者增加字符串长度
    public static final int arrayNumber = 4;

    public static void main(String[] args) {
        String[] strings = new String[arrayNumber];
        for (int i = 0; i < arrayNumber; i++) {
            strings[i] = generateString(100);
            System.out.println("第" + (i + 1) + "个随机生产的字符串为" + strings[i]);
        }
        String maxCommonChildString = getMaxCommonChildString(strings);
        System.out.println("公共子字符串:" + maxCommonChildString);
        if (maxCommonChildString != null) {
            for (int i = 0; i < arrayNumber; i++) {
                int index = strings[i].indexOf(maxCommonChildString);
                System.out.println("第" + (i + 1) + "个随机生产的字符串的子字符串" + maxCommonChildString + "的起始下标为" + index);
            }
        } else {
            System.out.println("无公共子字符串！");
        }

    }

    static String getMaxCommonChildString(String[] strings) {
        int length = strings.length;
        StringBuffer[] sbArr = new StringBuffer[length];
        for (int i = 0; i < length; i++) {
            sbArr[i] = new StringBuffer(strings[i]);
        }
        //最长可能为100，若100长度的找到了返回这个100长度的，否则判断所以99长度
        //的所有字符串是否是10个字符串的子字符串，若都不是，则判断98长度以此类推
        for (int i = 100; i > 0; i--) {
            //100长度的只需要从0遍历到0，99需要从0遍历到1，98从0遍历到2...
            //以此类推n长度的字符串(0<1<=100)需要从0遍历到100-n
            //所以判断条件应该是j<100-i+1=101-i或者j<=100-i
            for (int j = 0; j < 101 - i; j++) {
                String test = sbArr[0].substring(j, j + i);
                for (int k = 1; k < arrayNumber; k++) {
                    if (sbArr[k].indexOf(test) == -1) {
                        break;
                    }
                    //到这布判断说明直到第k+1个字符串还没有找到不包含
                    //假定的公共子字符串test的
                    //而如果当前判断的字符串就是最后一个的话说明判断完毕了
                    //test就是其中一个最长的(如果要找所有最长的需要把test
                    //定义为一个List，判断List非空的话就返回这个String数组)
                    if (k == arrayNumber - 1) {
                        return test;
                    }
                }
            }
        }
        return null;
    }

    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        String charStr = "012345";//6789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(charStr.charAt(random.nextInt(charStr.length())));
        }
        return sb.toString();
    }

}
