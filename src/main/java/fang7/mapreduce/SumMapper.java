package fang7.mapreduce;



import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SumMapper extends Mapper<LongWritable, Text, Text,FlowSum> {
    private Text outkey=new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String string = value.toString();
        String[] split = string.split("\t");
        outkey.set(split[1]);
        context.write(outkey, new FlowSum(Integer.valueOf(split[2]),Integer.valueOf(split[3])));
    }
}
