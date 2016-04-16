package com.lee.creazyjava.ch15.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by mingzhu on 2016/4/16.
 */
public class FileChannelTest {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/lee/creazyjava/ch15/nio/FileChannelTest.java");
        try {
            //使用传统的字节流来获取对应的channel流
            FileChannel inChannel = new FileInputStream(file).getChannel();
            FileChannel outChannel = new FileOutputStream("copy.txt").getChannel();
            //使用channel的map方法将FileChannel中的内容映射为buffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            //将buffer中的内容写入对应的文件
            outChannel.write(buffer);
            buffer.clear();
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            //将字节buffer转换为字符buffer
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
