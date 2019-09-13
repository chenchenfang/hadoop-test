package fang7.findfriend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FriendDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        // 1 获取job对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);

        // 2 指定jar包运行的路径
        job.setJarByClass(FriendDriver.class);

        // 3 指定map/reduce使用的类
        job.setMapperClass(FindFriendMapper.class);




        // 5 指定最终输出的数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(0);

        // 6 指定job的输入原始所在目录
        FileInputFormat.setInputPaths(job, new Path("D:\\hadoopInput\\friends"));
        FileOutputFormat.setOutputPath(job, new Path("D:\\hadoopInput\\friendsOutput"));

        // 7 提交
        boolean result = job.waitForCompletion(true);

        System.exit(result?0:1);

    }
}
