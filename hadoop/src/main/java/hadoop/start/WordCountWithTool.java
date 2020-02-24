package hadoop.start;

import club.chengouzi.hadoop.mapper.WordCountMapper;
import club.chengouzi.hadoop.reduce.WordCountReduce;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class WordCountWithTool extends Configured implements Tool {

    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = getConf();
        //设置map端的输出
        conf.setBoolean(Job.MAP_OUTPUT_COMPRESS, true);
        conf.setClass(Job.MAP_OUTPUT_COMPRESS_CODEC, GzipCodec.class, CompressionCodec.class);

        Job job = Job.getInstance(conf, "word count");
        job.setJarByClass(StartJob.class);

        job.setMapperClass(WordCountMapper.class);
        job.setCombinerClass(WordCountReduce.class);
        job.setReducerClass(WordCountReduce.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        //设置最终的输出压缩格式
        FileOutputFormat.setCompressOutput(job,true);
        FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);

        return job.waitForCompletion(true)?0:1;
    }

    public static void main(String[] args) throws Exception {
        int run = ToolRunner.run(new WordCountWithTool(), args);
        System.exit(run);
    }
}
