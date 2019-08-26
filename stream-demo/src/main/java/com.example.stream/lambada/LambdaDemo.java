package com.example.stream.lambada;

import com.example.stream.api.ItemArgs;
import com.example.stream.api.OnClickListener;
import com.example.stream.api.OnItemClickListener;

/**
 * 参考链接:https://blog.csdn.net/IO_Field/article/details/54380200
 */
public class LambdaDemo {
    public static void main(String[] args) {
        /**
         * 不包含参数且主体为表达式
         * Lambda表达式不包含参数，使用空括号 ()表示没有参数。
         */
        OnClickListener mListener = () -> System.out.println("do on Click");
        mListener.doOnclick();

        /**
         *不包含参数且主体为表达式
         * 该Lambda表达式实现了OnClickListener接口，其主体为一段代码段，在其内用返回或抛出异常来退出。
         * 只有一行代码的Lambda表达式也可使用大括号， 用以明确Lambda表达式从何处开始、到哪里结束。
         */
        OnClickListener m = () -> {
            System.out.println("1，2，3，4");
            System.out.println("4,3,2,1");
        };
        m.doOnclick();

        /**
         * 包含一个参数且主体为表达式
         * Lambda表达式可以包含一个参数，将参数写在()内，如果只有一个参数可以将()省略。
         */
        OnItemClickListener itemClickListener = position -> {
            System.out.println("position="+position);
        };
        itemClickListener.doItemClick(7);


        /**
         * 包含多个参数且主体为表达式
         * Lambda表达式可以包含多个参数，将参数写在()内，此时()不可以省略。
         */
        int apple  = 0;
        ItemArgs itemArgs = (x, y) -> apple + y;
        /**
         * 在Lambda表达式中，也是同样的问题，对于其方法体内引用的外部变量，
         * 在Lambda表达式所在方法内对变量再次赋值时，编译器会报同样的错误。
         * 也就是意味着，换句话说，Lambda表达式引用的是值，而不是变量。
         */
        //apple++;

        itemArgs.clickItems(1,2);

        ItemArgs item = (x, y) -> {
            if (x > y) {
                return x;
            }
            else {
                return y;
            }
        };
        item.clickItems(9,7);
    }
}
