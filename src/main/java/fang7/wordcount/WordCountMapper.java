package fang7.wordcount;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text,Text, IntWritable> {

    Text text = new Text();
    IntWritable intWritable = new IntWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        intWritable.set(1);
        String s = value.toString();
        String[] split = s.split(" ");
        for (String sp:
             split) {
            text.set(sp);
            context.write(text,intWritable);
        }

    }
}
