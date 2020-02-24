package hadoop.api.compression;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.*;

/**
 * 压缩文件
 *
 * @author fang7
 */
public class FileCompressor {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Configuration entries = new Configuration();
        LocalFileSystem local = FileSystem.getLocal(entries);

        Class<?> codecClass = Class.forName(args[0]);
        CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(codecClass, entries);


        OutputStream outputStream = codec.createOutputStream(new FileOutputStream(new File(args[2])));
        InputStream open = local.open(new Path(args[1]));
        IOUtils.copyBytes(open, outputStream, 4096, true);

    }
}
