public class Part3 {
    boolean twoOccurrences(String stringa, String stringb)
    {
        int value = stringb.indexOf(stringa);
        if(value != -1)
        {
            int anotherValue = stringb.indexOf(stringa, value + 1);
            if( anotherValue != -1)
            {
                return true;
            }
        }
        else {
            return false;
        }
        return false;
    }

    String lastPart(String stringa, String stringb)
    {
        if(stringb.indexOf(stringa) != -1)
        {
            int index = stringb.indexOf(stringa);
            return stringb.substring(index+stringa.length(), stringb.length());
        }
        else
            return stringb;
    }

    void testing()
    {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "bag"));
        System.out.println("The last part of the string is "+lastPart("an", "banana"));
        System.out.println("The last part of the string is "+lastPart("zoo", "forest"));
    }

    public static void main(String[] args) {
        Part3 p = new Part3();
        p.testing();
    }
}
