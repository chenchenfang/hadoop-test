package fang7.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        fileSystem.mkdirs(new Path("/user/hadoop"));
        fileSystem.close();
        System.out.println("执行完成");
    }
    @Test
    public void testCopyFileToHDFS() throws URISyntaxException, IOException, InterruptedException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        fileSystem.copyFromLocalFile(new Path("D:\\chenchen.txt"),new Path("/user/hadoop/"));
        fileSystem.close();
        System.out.println("执行成功");
    }
    @Test
    public void testCopyFileToLocal() throws IOException, URISyntaxException, InterruptedException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        fileSystem.copyToLocalFile(false,new Path("/user/hadoop/chenchen.txt"),new Path("D:\\xiaohua.txt"),true);
        fileSystem.close();
        System.out.println("执行成功");
    }
    @Test
    public void testDelFile() throws URISyntaxException, IOException, InterruptedException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        boolean delete = fileSystem.delete(new Path("/user/hadoop/chenchen.txt"), true);
        System.out.println("执行成功");
    }
    @Test
    public void testRename() throws URISyntaxException, IOException, InterruptedException{
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        fileSystem.rename(new Path("/user/hadoop/chenchen.txt"),new Path("/user/hadoop/xiaohua.txt"));
        System.out.println("执行成功");
    }
}
