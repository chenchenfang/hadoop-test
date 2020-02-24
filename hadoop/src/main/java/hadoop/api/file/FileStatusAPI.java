package hadoop.api.file;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * FileStatus
 * 目录和文件的api
 */
public class FileStatusAPI {
    public static void main(String[] args) throws IOException {
        FileSystem fileSystem= FileSystem.get(new Configuration());
        fileStatusForFile(fileSystem);
        fileStatusForDirectory(fileSystem);
    }

    public static void fileStatusForFile(FileSystem fileSystem) throws IOException {
        FileStatus fileStatus = fileSystem.getFileStatus(new Path("/user/hadoop/input"));
        System.out.println("目录:"+fileStatus.getPath().toString());
        System.out.println("块大小:"+fileStatus.getBlockSize());
        System.out.println("属于谁:"+fileStatus.getOwner());
        System.out.println("组:"+fileStatus.getGroup());
        System.out.println("是不是文件夹:"+fileStatus.isDirectory());
        System.out.println("文件大小:"+fileStatus.getLen());
    }

    public static void fileStatusForDirectory(FileSystem fileSystem) throws IOException {
        FileStatus fileStatus = fileSystem.getFileStatus(new Path("/user/hadoop"));
        if(fileStatus.isDirectory()){
            FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/user/hadoop"));
            for (FileStatus status : fileStatuses) {
                System.out.println(status.getPath().toString());
            }

        }
    }
}
