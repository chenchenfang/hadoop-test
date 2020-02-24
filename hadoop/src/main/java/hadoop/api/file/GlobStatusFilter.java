package hadoop.api.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 过滤文件
 * @author fang7
 */
public class GlobStatusFilter {
    public static void main(String[] args) throws URISyntaxException, IOException {
        FileSystem fs = FileSystem.get(new URI("/user/hadoop"), new Configuration());
        //第一个是通配符
        FileStatus[] inputs = fs.globStatus(new Path("/*/*/*"), new PathFilter() {
            @Override
            public boolean accept(Path path) {
                if (path.toString().contains("input")) {
                    return false;
                } else {
                    return true;
                }

            }
        });


    }
}
