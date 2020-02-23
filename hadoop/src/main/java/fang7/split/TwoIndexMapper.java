package fang7.split;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import javax.xml.bind.ValidationEvent;
import java.io.IOException;

public class TwoIndexMapper extends Mapper<LongWritable, Text,Text,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //atguigu--a.txt	3
        //atguigu--b.txt	2
        //atguigu--c.txt	2
        Text keyText = new Text();
        Text textValue = new Text();
        String[] split = value.toString().split("--");
        keyText.set(split[0]);
        textValue.set(split[1]);
        context.write(keyText,textValue);
    }
}
