package fang7.allComparable;




import fang7.mypartitioner.MyPartitioner;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "comparable");
        job.setMapperClass(SumMapper.class);
        job.setReducerClass(SumReduce.class);
        job.setJarByClass(Main.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        //添加分区
        job.setPartitionerClass(FlowPartitioner.class);
        job.setNumReduceTasks(2);

        FileInputFormat.setInputPaths(job,new Path("D:\\hadoopInput"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\hadoopOutput"));

        //开始运行
        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);
    }
}
