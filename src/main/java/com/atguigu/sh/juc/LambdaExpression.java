package com.atguigu.sh.juc;

/**
 * @program: juc
 * @description
 * @author: xiangyuyi
 * @create: 2021-04-13 16:37
 **/
public class LambdaExpression {

    public static void main(String[] args) {
//        foo foo = new foo() {
//            @Override
//            public String sysHello() {
//                return null;
//            }
//        };
//        foo.sysHello();

        Foo foo = (x,y) ->{
            return  x + y;
        };
        System.out.println(foo.sysHello(4,5));

        System.out.println(Foo.div2(4,5));


    }
}

@FunctionalInterface
interface Foo{
    int sysHello(int x, int y);

    default int  div(int x, int y){
        return x/y;
    }

    public static int  div2(int x, int y){
        return x/y;
    }
}
