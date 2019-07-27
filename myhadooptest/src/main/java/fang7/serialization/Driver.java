package fang7.serialization;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration entries = new Configuration();
        Job job = Job.getInstance(entries);
        job.setMapperClass(TelMapper.class);
        job.setReducerClass(TelReducer.class);
        job.setJarByClass(Driver.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapOutputKeyClass(TelPhoneInfo.class);
        job.setMapOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job,new Path("D:\\hadoopTest\\telPhone\\input"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\hadoopTest\\telPhone\\output"));

        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);
    }
}
