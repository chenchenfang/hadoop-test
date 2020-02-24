package hadoop.api.compression;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CodecPool;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.io.compress.Compressor;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;

public class CodecPoolTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String codecClassName = args[0];
        String outputPath = args[1];
        String inputPath = args[2];
        //创建输出路径
        FileSystem fileSystem = FileSystem.getLocal(new Configuration());
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path(outputPath), true);

        //添加压缩
        Class<?> codecClass = Class.forName(codecClassName);
        CompressionCodec compressionCodec = (CompressionCodec) ReflectionUtils.newInstance(codecClass, new Configuration());
        CompressionOutputStream outputStream = null;

        Compressor compressor= CodecPool.getCompressor(compressionCodec);
        try {
            outputStream = compressionCodec.createOutputStream(fsDataOutputStream, compressor);

            IOUtils.copyBytes(fileSystem.open(new Path(inputPath)), outputStream, 4096);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeStream(outputStream);
            CodecPool.returnCompressor(compressor);
        }


    }
}
