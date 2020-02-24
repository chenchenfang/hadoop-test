package hadoop.api.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * 删除path(目录或者文件)
 * @author fang7
 */
public class DeletePath {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem= FileSystem.get(new Configuration());
        //第二个参数是是否删除目录 (包括目录本身)
        fileSystem.delete(new Path("/user/hadoop/output"),true);
    }
}
