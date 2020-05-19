package com.hy.learn.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Created by hy
 * @date on 2020/5/18 16:57
 */
public class NIOSocketService {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocket serverSocket = socketChannel.socket();
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8888);
        serverSocket.bind(socketAddress);

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    // 服务器会为每个新连接创建一个 SocketChannel
                    SocketChannel sChannel = serverSocketChannel.accept();
                    sChannel.configureBlocking(false);
                    // 这个新连接主要用于从客户端读取数据
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    SocketChannel ssChannel = (SocketChannel) selectionKey.channel();
                    System.out.println(readDataFromSocketChannel(ssChannel));
                    ssChannel.close();
                }
                keyIterator.remove();
            }
        }
    }

    private static String readDataFromSocketChannel(SocketChannel ssChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuffer data = new StringBuffer();
        while (ssChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            int limit = byteBuffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) byteBuffer.get(i);
            }
            data.append(dst);
            byteBuffer.clear();
        }
        return data.toString();
    }

}
