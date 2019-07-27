package fang7.serialization;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TelReducer extends Reducer<TelPhoneInfo, IntWritable, Text,IntWritable> {
    private Text text = new Text();
    private IntWritable intWritable = new IntWritable();
    @Override
    protected void reduce(TelPhoneInfo key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        text.set(key.getTelNumber()+"");
        intWritable.set(key.getFlow());
        context.write(text,intWritable);
    }
}
