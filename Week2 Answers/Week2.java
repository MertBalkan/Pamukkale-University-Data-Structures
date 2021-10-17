import java.util.*;

/**
 * Islemler sınıfı içindeki 4 metodun yazılması istenmektedir
 */
public class Islemler {
    /**
     * Yığıtın elemnlarının sırasını tersine çevirir
     * @param s Tersine çevrilecek yığıt
     * @return Tersine çevirlmiş yığıtı döndürür
     */
    public static <T> Stack<T> tersCevir(Stack<T> s){
        Stack tempStack = new Stack<>();
        Stack<T> stack = (Stack<T>) s.clone();
        
        
        while(!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        return tempStack;
    
        
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
    {
        Stack cloneStack1 = (Stack<T>) s1.clone();
        Stack cloneStack2 = (Stack<T>) s2.clone();
        
        if(cloneStack1.size() != cloneStack2.size())
            return false;
        
        while(!cloneStack1.isEmpty() && !cloneStack2.isEmpty())
        {
            if(cloneStack1.pop() == cloneStack2.pop()){
                return true;
            }
            else return false;
        }
        
        return false;
    }

    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
        Stack<Integer> stack = new Stack<>();
        String[] s = splitToTokens(girdi);
        String l = "";
        
        int d1, d2;
        
        for(String deger : s){
            if(deger.equals("+")){
                
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(d2+d1);
                
            }else if(deger.equals("-")){
                
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(d2-d1);
                
            }else if(deger.equals("*")){
                
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(d2*d1);
                
            }else if(deger.equals("/")){
                
                d1 = stack.pop();
                d2 = stack.pop();
                stack.push(d2/d1);
                
            }else{
                stack.push(Integer.parseInt(deger));
            }
        }
        return stack.pop();
        
    }

    public static int prec(char c) {
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }            

    /**
     * Infix ifadeyi postfix'e dönüştürür.
     * @param girdi Infix girdi metni
     * @return Dönüştürülmüş postfix ifade
     */
    public static String infixToPostfix(String girdi){
        
        //Uzerine Tekrar Gelecegim Kodlar
        /*String[] degerler = splitToTokens(girdi);
        Stack<String> stack = new Stack<>();
        String sonuc = "";
        char[] c = new char[100];
        String yeniSonuc = "";
        int mirror = -1;
        
       for(String okunan : degerler){
            if(okunan.equals("+") || okunan.equals("-")|| okunan.equals("/")|| okunan.equals("*")){
                sonuc+=okunan;
            }
            else if(okunan.equals("(")){
                stack.push(okunan);
            }
            else if(okunan.equals(")")){
                while(!okunan.equals("(")){
                        sonuc+=stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && prec(stack.peek()) > prec(okunan)){
                    sonuc+=stack.pop();
                }
                stack.push(okunan);
            }           
       
        }
        while(!stack.isEmpty()){
            sonuc += " ";
            sonuc+=stack.pop();
            
        }
        
        for(int i = sonuc.length() - 1; i >= 0 ; i--){
            c[i] = sonuc.charAt(i);
            yeniSonuc+=c[i];
            
        }
        
         return yeniSonuc;*/
         
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <girdi.length() ; i++) {
            char c = girdi.charAt(i);

            //check if char is operator
            if(prec(c)>0){
                while(stack.isEmpty()==false && prec(stack.peek())>=prec(c)){
                    result += stack.pop();
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result += x;
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor ( 
                result += c;
            }
        }
        for (int i = 0; i <=stack.size() ; i++) {
            result += " ";
            result += stack.pop();
        }
        return result;
    }

    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }
}
