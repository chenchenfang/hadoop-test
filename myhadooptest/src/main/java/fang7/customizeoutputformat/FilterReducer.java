package fang7.customizeoutputformat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FilterReducer extends Reducer<Text, NullWritable,Text, NullWritable> {
    private Text text = new Text();
    @Override
    protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {

        text.set(key.toString()+"\r\n");
        context.write(text,NullWritable.get());
    }
}
