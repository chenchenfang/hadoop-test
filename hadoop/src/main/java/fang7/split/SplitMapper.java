package fang7.split;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class SplitMapper extends Mapper<LongWritable, Text,Text,LongWritable> {
    String name;
    Text text = new Text();
    LongWritable longWritable = new LongWritable();
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        FileSplit inputSplit = (FileSplit) context.getInputSplit();
        name = inputSplit.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] s = value.toString().split(" ");
        for (int i = 0; i < s.length; i++) {
            text.set(s[i]+"--"+name);
            longWritable.set(1);
            context.write(text,longWritable);
        }
    }
}
