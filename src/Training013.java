import sun.font.ScriptRun;

class Training013{
    public static void main(String[] args) {
        String src="We are happy!";
        StringSolution ss=new StringSolution();
        System.out.println("Hello World");
        System.out.println(ss.ReplaceBlank(src));
    }
}

class StringSolution{
    // 空格替换成%20
    String ReplaceBlank(String src){
        if(src==null||src.length()<=0){
            return null;
        }
        int blankNumber=0;
        for (int i = 0; i < src.length(); i++) {
            if(src.charAt(i)==' '){
                blankNumber++;
            }
        }
        int newLength=src.length()+blankNumber*2;
        StringBuilder sb=new StringBuilder(src);
        sb.append("    ");
        int indexOrigin=src.length()-1;
        int indexNew=newLength-1;
        while(indexOrigin>=0&&indexNew>indexOrigin){
            if(src.charAt(indexOrigin)==' '){
                sb.setCharAt(indexNew--, '0');
                sb.setCharAt(indexNew--, '2');
                sb.setCharAt(indexNew--, '%');
            }else{
                char tmp=src.charAt(indexOrigin);
                sb.setCharAt(indexNew--, tmp);
            }
            --indexOrigin;
        }
        src=sb.toString();
        return src;
    }
}