package fang7.test;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * IO流实现文件的各种操作
 */
public class IOMain {
    /**
     * IO流上传本地数据
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void putFileToHDFS() throws URISyntaxException, IOException, InterruptedException {
        //1获取对象
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        //2获取输入流
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\hive项目操作.xmind"));
        //3获取输出流
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path("/hive项目操作.xmind"));


        IOUtils.copyBytes(fileInputStream, fsDataOutputStream, 2048);

        IOUtils.closeStream(fsDataOutputStream);
        IOUtils.closeStream(fileInputStream);
        fileSystem.close();

    }

    /**
     * 从HDFS上下载文件
     * @throws IOException
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void getFileFromHDFS() throws IOException, URISyntaxException, InterruptedException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        //获取文件的输入流
        FSDataInputStream inputStream = fileSystem.open(new Path("/hive项目操作.xmind"));
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\hdfs\\hive项目操作.xmind"));
        IOUtils.copyBytes(inputStream, outputStream, 2048);
        IOUtils.closeStream(outputStream);
        IOUtils.closeStream(inputStream);
        fileSystem.close();
    }
}
