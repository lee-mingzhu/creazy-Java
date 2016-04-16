package com.lee.creazyjava.ch15.nio;

import java.nio.CharBuffer;

/**
 * Created by mingzhu on 2016/4/16.
 */
public class BufferTest {
    public static void main(String[] args) {
        //创建一个CharBuffer对象
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("limit:" + buffer.limit());
        System.out.println("position:" + buffer.position());
        //放入元素
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        System.out.println("加入三个元素后,position=" + buffer.position());
        buffer.flip();
        System.out.println("执行flip()后,limit = " + buffer.limit());
        System.out.println("position = " + buffer.position());
        System.out.println("第一个元素(position=0): " + buffer.get());
        System.out.println("取出一个元素后, position = " + buffer.position());
        buffer.clear();
        System.out.println("执行clear()后,limit = " + buffer.limit());
        System.out.println("执行clear()后,position = " + buffer.position());
        System.out.println("执行clear()后,缓冲区的内容并没有被清除: 第三个元素为:" + buffer.get(2));
        System.out.println("执行绝对读取后,position = " + buffer.position());
    }
}
