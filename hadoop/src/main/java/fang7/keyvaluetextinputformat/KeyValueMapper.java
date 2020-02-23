package fang7.keyvaluetextinputformat;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class KeyValueMapper extends Mapper<Text, Text,Text, IntWritable> {
    private IntWritable intWritable = new IntWritable(1);
    @Override
    protected void map(Text key, Text Text, Context context) throws IOException, InterruptedException {
        context.write(key,intWritable);
    }
}
