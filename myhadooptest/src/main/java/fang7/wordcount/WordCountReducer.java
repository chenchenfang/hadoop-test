package fang7.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Counter;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, IntWritable,Text, IntWritable> {

    IntWritable value = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {


        int i=0;
        for (IntWritable intWritable:
             values) {
            i=i+intWritable.get();
        }
        value.set(i);
        context.write(key,value);
    }
}
