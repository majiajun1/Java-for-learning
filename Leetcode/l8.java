public class l8 {
    public static void main(String[] args) {
        String s="  +  413";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        boolean minus = false;
        int carry = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==' '&&carry!=0)
            {
                break;
            }
            if (c == ' ' && sb.length() == 0) {
                continue;
            }

            if(sb.length()!=0 && c==' ' ) {
                break;
            }



            if (sb.length() == 0 && c == '-') {
                minus = true;
                carry++;
                continue;
            } else if (sb.length() == 0 && c == '+') {
                minus = false;
                carry++;
                continue;
            }

            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                break;
            }

            if (carry > 1) {
                return 0;
            }


        }
        double index=0;
        long ans=0;



        for(int i=0;i<sb.length();i++){
            char c = sb.charAt(i);
            if(c>='3'&&(sb.length()-i)>=10||(sb.length()-i>10&&c!='0')){

                if(minus)
                {
                    return  Integer.MIN_VALUE;
                }else
                {
                    return  Integer.MAX_VALUE;
                }

            }else
            {
                ans=ans+(c-'0')*(long) Math.pow(10,sb.length()-i-1);
            }
        }
        if(ans>Integer.MAX_VALUE)
        {
            if(minus)
            {
                return Integer.MIN_VALUE;
            }else
            {
                return Integer.MAX_VALUE;
            }
        }


        if(minus)
        {
            return (int) -ans;
        }else
        {
            return (int) ans;
        }




    }






}
