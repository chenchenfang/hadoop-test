package hadoop.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<Object, Text, Text, IntWritable> {

    private static final IntWritable outValue=new IntWritable(1);
    private Text text=new Text();
    @Override
    public void map(Object key, Text value, Context context
    ) throws IOException, InterruptedException {
        String[] strArray = value.toString().split(" ");
        for (String str :
             strArray) {
            if(str.equals("111")){
                context.setStatus("出现了111");
            }
            text.set(str);
            context.write(text,outValue);
        }
    }
}
