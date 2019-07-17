package fang7.customizeoutputformat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FilterDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        args=new String[] {"D:\\hadoopInput\\filteroutput","D:\\hadoopOutput\\filteroutput"};
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "filter");

        job.setMapperClass(FilterMapper.class);
        job.setReducerClass(FilterReducer.class);
        job.setJarByClass(FilterDriver.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);


        job.setOutputFormatClass(FOutputFormat.class);

        FileInputFormat.setInputPaths(job,args[0]);
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);

    }
}
