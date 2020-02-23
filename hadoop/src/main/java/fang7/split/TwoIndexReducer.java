package fang7.split;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class TwoIndexReducer extends Reducer<Text,Text,Text,Text> {
    Text text = new Text();
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //atguigu c.txt	2
        StringBuffer stringBuffer = new StringBuffer();
        for (Text text :
             values) {
            String replace = text.toString().replace("\t", "-->");
            stringBuffer.append(replace);
        }
        text.set(stringBuffer.toString());
        context.write(key,text);
    }
}
