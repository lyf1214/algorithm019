class Solution {
    //1¡¢ASCCIIÂë
    //A-Z 65-90
    //a-z 97-122
    // public String toLowerCase(String str) {
    //     char[] charArray = str.toCharArray();
    //     for(int i = 0; i < charArray.length; i++) {
    //         int index = charArray[i] - 'A';
               //char c = charArray[i];
    //         if(index >= 0 && index < 26) {
    //             charArray[i] += 32;
    //         }
    //         //System.out.println("indx==" + index +", before=="+ c + ", after=="+charArray[i]);
    //     }
    //     return String.valueOf(charArray);
    // }

    public String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] >= 65 && charArray[i] <= 90) {
                charArray[i] += 32;
            }
        }
        return String.valueOf(charArray);
    }

    //2¡¢Î»ÔËËã
    // public String toLowerCase(String str) {
    //     char[] ch = str.toCharArray();
    //     for (int i = 0; i < str.length(); i++) {
    //         ch[i] |= 32;
    //     }
    //     return String.valueOf(ch);
    // }
}