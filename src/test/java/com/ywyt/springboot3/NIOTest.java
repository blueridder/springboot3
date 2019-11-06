package com.ywyt.springboot3;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author xiejin
 * @date 2019/9/29 14:05
 */
@RunWith(JUnit4ClassRunner.class)
//@SpringBootTest
public class NIOTest {

    /**
     * Java.nio.channels
     * AsyncharonousSoketChannel
     * AsyncharonousServerSocketChannel
     * AsyncharonousFileChannel
     * AsyncharonousDatagramChannel
     * @throws IOException
     */

    @Test
    public void testCreateSelector() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        //使用selector时候不能配合使用FileChannel
        //因为FilChannel不能切换到非阻塞模式
        Selector selector = Selector.open();
        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println(key);
    }

    @Test
    public void testcp() {
        try {
            copyFileUseNIO("E:/test.txt","D:/1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMove() {
        System.out.println("1<<0="+(1<<0));
        System.out.println("1<<2="+(1<<2));
        System.out.println("1<<3="+(1<<3));
        System.out.println("1<<4="+(1<<4));
    }

    public void copyFileUseNIO(String src , String dest) throws IOException {
        //文件所处位置
        FileInputStream fi = new FileInputStream(new File(src));
        //要将文件拷贝到哪里（目标位置）
        FileOutputStream fo = new FileOutputStream(new File(dest));

        FileChannel inChannel = fi.getChannel();
        FileChannel outChannel = fo.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //判断文件是否读完
            int eof = inChannel.read(buffer);
            if (eof == -1) {
                break;
            }
            //重设buffer的position=0,limit = position
            buffer.flip();

            //开始写
            outChannel.write(buffer);
            //写完重置buffer，position=0，limit=capacity
            buffer.clear();

        }

        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();


    }



}
