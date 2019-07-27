package compression;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.*;
import org.apache.hadoop.util.ReflectionUtils;


import java.io.*;

/**
 * 简单的解压缩
 * @author fang7
 */
public class CompressionTest {
    public static void main(String[] args) throws IOException {
        //compress("D:\\hadoopInput\\compress\\121.txt", BZip2Codec.class);
        decompress("D:\\hadoopInput\\compress\\121.txt.gz");
    }
    public static void compress(String filePath,Class codec) throws IOException {
        //获取输入流
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        //
        CompressionCodec compressionCodec = (CompressionCodec)ReflectionUtils.newInstance(codec, new Configuration());
        //输出路径
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath + compressionCodec.getDefaultExtension()));
        CompressionOutputStream outputStream = compressionCodec.createOutputStream(fileOutputStream);
        IOUtils.copyBytes(fileInputStream, outputStream, 1024*1024, false);

        IOUtils.closeStream(outputStream);
        IOUtils.closeStream(fileOutputStream);
        IOUtils.closeStream(fileInputStream);
    }

    public static  void decompress(String filePath) throws IOException {
        CompressionCodecFactory compressionCodecFactory = new CompressionCodecFactory(new Configuration());
        CompressionCodec codec = compressionCodecFactory.getCodec(new Path(filePath));
        if (codec==null){
            System.out.println("抱歉不能解压");
            return ;
        }

        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        CompressionInputStream inputStream = codec.createInputStream(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath.replace(codec.getDefaultExtension(), "")));

        IOUtils.copyBytes(inputStream, fileOutputStream, 1024*1024);

        fileOutputStream.close();
        inputStream.close();
        fileInputStream.close();

    }
}
