package hadoop.api.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 在HDFS上创建文件
 * @author fang7
 */
public class HDFSCreateFile {
    public static void main(String[] args) throws IOException {
        String localPath = args[0];
        String HDFSPath = args[1];
        InputStream inputStream = new BufferedInputStream(new FileInputStream(localPath));

        FileSystem fileSystem = FileSystem.get(new Configuration());
        FSDataOutputStream outputStream = fileSystem.create(new Path(HDFSPath), true);

        IOUtils.copyBytes(inputStream,outputStream,4096,false);
        //以下都可以对新的read可见
        //hsync可以直接写入磁盘 (但是开销大 )
        outputStream.hsync();
        //close 可以保存数据到内存
        outputStream.close();

        inputStream.close();
    }
}
