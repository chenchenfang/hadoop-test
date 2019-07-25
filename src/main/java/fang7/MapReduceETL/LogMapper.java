package fang7.MapReduceETL;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    Text text = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s = value.toString();
        boolean result =parseLog(s,context);
        if(!result){
            return ;
        }
        text.set(s);
        context.write(text,NullWritable.get());
    }

    private boolean parseLog(String s, Context context) {
        String[] s1 = s.split(" ");
        if(s1.length>11){
            context.getCounter("map","true").increment(1);
            return true;
        }else {
            context.getCounter("map","false").increment(1);
            return false;
        }
    }
}
