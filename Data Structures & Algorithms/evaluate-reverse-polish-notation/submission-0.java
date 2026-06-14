class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> result = new ArrayDeque<>();

        for(int i=0; i < tokens.length; i++){

            String s = tokens[i];

            if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/") ){

                result.push(Integer.parseInt(s));
            }
            else{

                int a = result.pop();

                int b = result.pop();

                if(s.equals("+")){

                    result.push(a + b);
                }
                else if(s.equals("-")){

                    result.push(b - a);
                }
                else if(s.equals("*")){

                    result.push(b*a);
                }
                else if(s.equals("/")){

                    result.push(b/a);
                }
            }
        }

        int ans = result.pop();

        return ans;
    }
}
