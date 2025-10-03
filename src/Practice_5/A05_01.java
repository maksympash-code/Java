package Practice_5;

public class A05_01 {
    public static void main(String[] args){
        String s = "\"philosophy 12+3 is ph phantastic   text\"\n";
        System.out.println(dou(s));
        System.out.println(fp(s));
        System.out.println(r(s));
    }

    static public String dou(String s){
        char[] result = new char[s.length() * 2];
        int j = 0;
        for (int i = 0; i < s.length(); i++){
            result[j++] = s.charAt(i);
            if (Character.isDigit(s.charAt(i))){
                result[j++] = s.charAt(i);
            }
        }
        return new String(result, 0, j);
    }

    public static String fp(String s){
        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        while (true){
            i = sb.indexOf("+", i);

            if (i == -1 || i + 1 == sb.length())
                break;
            if (Character.isDigit(sb.charAt(i + 1))){
                sb.deleteCharAt(i);
                if (i > 0)
                    i--;
            }
            else
                i++;
        }
        return sb.toString();
    }

    public static String r (String s){
        return s.replaceAll("ph", "f");
    }

    public static String s(String s){
        return s.replaceAll("\\s", " ");
    }
}
