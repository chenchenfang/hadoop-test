package fang7.nlineinputformat;

import fang7.keyvaluetextinputformat.Main;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class NLineDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();

        Job job = Job.getInstance(configuration, "keyValue");

        job.setMapperClass(NLineMapper.class);
        job.setReducerClass(NLineReducer.class);
        job.setJarByClass(Main.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //一个切片处理多少个数据
        NLineInputFormat.setNumLinesPerSplit(job,3);
        //设置为按行分切片
        job.setInputFormatClass(NLineInputFormat.class);
        FileInputFormat.setInputPaths(job,new Path("D:\\hadoopInput"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\hadoopOutput"));

        //开始运行
        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);
    }
}
