public int addFive(int test)
    {
        String number = Integer.toString(test);
        boolean isNeg = (number.charAt(0)=='-');
                
        StringBuilder strb = new StringBuilder();
        strb.append(number);
        for(int i=0; i < number.length();++i)
        {
            if(!isNeg && Character.getNumericValue(number.charAt(i)) <=5 ||isNeg && Character.getNumericValue(number.charAt(i)) >5 )
            {
                strb.insert(i, 5);
                return Integer.parseInt(strb.toString());
            }
        }
        
        strb.insert(strb.length(), 5);
        return Integer.parseInt(strb.toString());
    }