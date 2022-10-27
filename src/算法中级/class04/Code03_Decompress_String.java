package 算法中级.class04;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/25 14:55
 */
public class Code03_Decompress_String {

    public static String decompress(String decompressStr) {
        char[] chs = decompressStr.toCharArray();
        return process(chs, 0).str;
    }

    public static class ReturnData {
        public String str;
        public int end;

        public ReturnData(String str, int end) {
            this.str = str;
            this.end = end;
        }
    }

    //str[index....结尾或者遇到右括号]这一段，字符串、以及处理到的位置返回
    public static ReturnData process(char[] str, int index) {

        StringBuilder res = new StringBuilder();
        int times = 0;
        while (index < str.length && str[index] != '}') {
            if (str[index] == '{') {
                ReturnData returnData = process(str, index + 1);
                res.append(getTimesString(times, returnData.str));
                times = 0;
                index = returnData.end + 1;
            } else {
                if (str[index] >= '0' && str[index] <= '9') {
                    times = times * 10 + str[index] - '0';
                }
                if (str[index] >= 'a' && str[index] <= 'z') {
                    res.append(str[index]);
                }
                index++;
            }
        }
        return new ReturnData(res.toString(), index);
    }

    public static String getTimesString(int times, String base) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(base);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(decompress("3{2{abc}}"));
        Integer a = -1;
        System.out.println();
    }
}
