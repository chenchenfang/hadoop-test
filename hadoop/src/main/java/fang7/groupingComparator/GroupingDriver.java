package fang7.groupingComparator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class GroupingDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration entries = new Configuration();
        Job job = Job.getInstance(entries);
        job.setMapperClass(GroupingComparatorMapper.class);
        job.setReducerClass(GroupingComparatorReducer.class);

        job.setJarByClass(GroupingDriver.class);

        job.setOutputKeyClass(OrderBean.class);
        job.setOutputValueClass(NullWritable.class);

       job.setGroupingComparatorClass(OrderSortGroupingComparator.class);

        FileInputFormat.setInputPaths(job,new Path("D:\\hadoopInput\\grouping"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\hadoopInput\\groupingOutput"));

        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);
    }
}
