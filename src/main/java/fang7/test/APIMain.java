package fang7.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.yarn.nodelabels.FileSystemNodeLabelsStore;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 各种api操作
 */
public class APIMain {
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

    /**
     * 获取文件的信息
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testListFiles() throws URISyntaxException, IOException, InterruptedException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path("/"), true);
        while (listFiles.hasNext()){
            LocatedFileStatus fileStatus = listFiles.next();
            //文件名
            System.out.println(fileStatus.getPath().getName());
            //文件权限
            System.out.println(fileStatus.getPermission());
            //文件长度
            System.out.println(fileStatus.getLen());
            //文件块所在的机器host名字
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            for (BlockLocation blockLocation:
                 blockLocations) {
                String[] hosts = blockLocation.getHosts();
                for (String host:
                     hosts) {
                    System.out.println(host);
                }
            }
            System.out.println("-----------------------------");
        }
    }

    /**
     * 获取当前目录下的目录或者文件并进行分析
     * 可以判断是不是文件或者文件夹
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testListStatus() throws URISyntaxException, IOException, InterruptedException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop100:9000"), new Configuration(), "hadoop");
        FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/"));
        for (FileStatus fileStatus:
             fileStatuses) {
            if(fileStatus.isFile()){
                System.out.println("f:"+fileStatus.getPath().getName());
            }else {
                System.out.println("d:"+fileStatus.getPath().getName());
            }
        }
    }

}
