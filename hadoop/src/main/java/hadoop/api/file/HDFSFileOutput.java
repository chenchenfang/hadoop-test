package hadoop.api.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;

/**
 * 输出文件的内容到屏幕
 * @author fnag7
 */
public class HDFSFileOutput {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem = FileSystem.get(new Configuration());
        //获取本地文件系统
        //FileSystem fileSystem = FileSystem.getLocal();
        FSDataInputStream open = null;
        try {
            open = fileSystem.open(new Path(args[0]));
            IOUtils.copyBytes(open, System.out, 1024, false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(open);
        }
    }
}
