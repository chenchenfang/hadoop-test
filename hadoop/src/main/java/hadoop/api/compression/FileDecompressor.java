package hadoop.api.compression;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionInputStream;

import java.io.IOException;

/**
 * 文件的解压
 * @author fang7
 */
public class FileDecompressor {
    public static void main(String[] args) throws IOException {
        Path path = new Path(args[0]);

        Configuration entries = new Configuration();
        LocalFileSystem local = FileSystem.getLocal(entries);

        CompressionCodecFactory compressionCodecFactory = new CompressionCodecFactory(entries);
        CompressionCodec codec = compressionCodecFactory.getCodec(path);
        String outputPath = CompressionCodecFactory.removeSuffix(args[0], codec.getDefaultExtension());

        CompressionInputStream inputStream = codec.createInputStream(local.open(path));
        FSDataOutputStream fsDataOutputStream = local.create(new Path(outputPath));

        IOUtils.copyBytes(inputStream,fsDataOutputStream,4096,true);

    }
}
