package fang7.split;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SplitReducer extends Reducer<Text, LongWritable,Text, LongWritable> {
    LongWritable longWritable = new LongWritable();
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        long val=0;
        for (LongWritable longWritable:
             values) {
            val+=longWritable.get();
        }
        longWritable.set(val);
        context.write(key,longWritable);
    }
}
