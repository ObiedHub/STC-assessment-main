public class Main {
    public static void main(String[] args) {
        System.out.println("*** Start Main Running *** ");
        resversStr(null);
        resversStr("");
        resversStr("abd(jnb)asdf");
        resversStr("abdjnbasdf");
        resversStr("dd(df)a(ghhh)");
        resversStr("dd(df))a(ghhh)");
        resversStr("dd(df)a(ghhh()");
        System.out.println("*** End Main Running *** ");
    }

    public static void resversStr(String strv) {

        // validations
        if (strv == null || strv.isEmpty()) {
            System.out.println("Plese Note The String Should Not Be Null Or Empty");
            return;
        }

        if (strv.length() > 200) {
            System.out.println("Plese Note The  String Length Should Be Less Than Or Equal 200");
            return;
        }

        if (!strv.toLowerCase().equals(strv)) {
            System.out.println("Plese Note The String Should Contains Lower Chars");
            return;
        }


        StringBuilder StrBuilder = new StringBuilder();
        int startChr = -1;
        for (int i = 0; i < strv.length(); i++) {

            if ((strv.charAt(i) + "").equals(")") && startChr == -1) {
                System.out.println(strv + " Is Not Correct");
                return;
            }

            else if ((strv.charAt(i) + "").equals("(") && startChr != -1) {
                System.out.println(strv + " Is Not Correct");

                return;
            } else if ((strv.charAt(i) + "").equals("(")) {
                int endChar = strv.indexOf(')', i);

                // if left parenthesis does not followed by right one
                if (endChar == -1) {
                    System.out.println(strv + " Is Not Correct");
                    return;
                }

                startChr = i + 1;
                i = endChar;

                String strReverse = strv.substring(startChr, endChar);

                if (strReverse.contains("(")) {
                    System.out.println(strv + " Is Not Correct");
                    return;
                }

                String reversedStr = reverseStringFun(strReverse);
                StrBuilder.append("(" + reversedStr + ")");
                startChr = -1;
            } else {
                StrBuilder.append(strv.charAt(i));
            }
        }
        System.out.println("Old String =  " + strv);
        System.out.println("New String =  " + StrBuilder.toString());

    }

    public static String reverseStringFun(String stringToBeRevesed) {
        StringBuilder StrBuilder = new StringBuilder();
        for (int i = stringToBeRevesed.length() - 1; i >= 0; i--) {
            StrBuilder.append(stringToBeRevesed.charAt(i));
        }
        return StrBuilder.toString();
    }
}
