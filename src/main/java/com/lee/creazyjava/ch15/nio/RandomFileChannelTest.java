package com.lee.creazyjava.ch15.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mingzhu on 2016/4/16.
 */
public class RandomFileChannelTest {
    public static void main(String[] args) {
        File file = new File("copy.txt");
        try {
            RandomAccessFile rf = new RandomAccessFile(file, "rw");
            FileChannel channel = rf.getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            channel.position(file.length());
            channel.write(buffer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
