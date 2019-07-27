package fang7.allComparable;

import fang7.mapreduce.FlowSum;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SumMapper extends Mapper<LongWritable, Text,FlowBean ,Text > {
    private Text outkey=new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String string = value.toString();
        String[] split = string.split("\t");
        outkey.set(split[1]);
        context.write(new FlowBean(Integer.parseInt(split[2]),Integer.parseInt(split[3])), outkey);
    }
}
