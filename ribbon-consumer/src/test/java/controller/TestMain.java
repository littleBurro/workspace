package controller;

public class TestMain {

    public static void main(String[] args){
//        AbstractTest abstractTest1 = new TestA();
//        System.out.println(abstractTest1.test1());
//        AbstractTest abstractTest2 = new TestB();
//        System.out.println(abstractTest2.test1());

        spilt("68747470733A2F2F6D2E75637765622E636F6D2F313032342F696E6465782E68746D6C");
//        System.out.println(sc(1));
    }

    public static void spilt(String str){
        if (str == null || str.length() < 2){
            return ;
        }
        System.out.println((char) Integer.parseInt(str.substring(0, 2)));
        spilt(str.substring(2, str.length()));
    }

    public static int sc(int first){
        if (first > 10){
            return first;
        }
        return sc(first + 1) + first;
    }

    public static int digui(int i, int j){
        if (j == 0 || i == j){
            return 1;
        }else {
            return digui(i - 1, j) + digui(i - 1, j - 1);
        }
    }
}
