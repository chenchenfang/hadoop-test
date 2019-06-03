package fang7.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author fang7
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "count");
        job.setMapperClass(SumMapper.class);
        job.setReducerClass(SumReduce.class);
        job.setJarByClass(Main.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowSum.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowSum.class);

        FileInputFormat.setInputPaths(job,new Path("D:\\hadoopInput"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\hadoopOutput"));

        //开始运行
        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);

    }
}
