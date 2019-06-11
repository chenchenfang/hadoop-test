package fang7.nlineinputformat;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class NLineReducer extends Reducer<Text, IntWritable,Text, IntWritable> {
    IntWritable outKey = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int sum=0;
        for (IntWritable intWritable :
                values) {
            sum+=intWritable.get();
        }
        outKey.set(sum);
        context.write(key,outKey);
    }
}
