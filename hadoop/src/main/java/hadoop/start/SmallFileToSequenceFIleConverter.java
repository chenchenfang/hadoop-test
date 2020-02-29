package hadoop.start;

import hadoop.fileinputformat.TestWholeFileInputFormat;
import hadoop.mapper.WholeFileMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * 将多个小文件合并成顺序文件
 */
public class SmallFileToSequenceFIleConverter extends Configured implements Tool {

    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = getConf();
        Job job = Job.getInstance(conf, "SmallFileToSequenceFIle");
        job.setJarByClass(SmallFileToSequenceFIleConverter.class);

        //输入输出格式
        job.setInputFormatClass(TestWholeFileInputFormat.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);

        //输入输出路径
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(WholeFileMapper.class);

        //设置最终输出的key value
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(BytesWritable.class);



        return job.waitForCompletion(true)?0:1;
    }

    public static void main(String[] args) throws Exception {
        int run = ToolRunner.run(new SmallFileToSequenceFIleConverter(), args);
        System.exit(run);
    }
}
