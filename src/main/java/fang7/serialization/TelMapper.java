package fang7.serialization;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 拆分并排序
 */
public class TelMapper extends Mapper<LongWritable, Text,TelPhoneInfo, IntWritable> {
    private  TelPhoneInfo telPhoneInfo = new TelPhoneInfo();
    private IntWritable intWritable = new IntWritable();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] split = value.toString().split("\t");
        telPhoneInfo.setTelNumber(Integer.valueOf(split[0]));
        telPhoneInfo.setFlow(Integer.valueOf(split[1]));
        context.write(telPhoneInfo,intWritable);
    }
}
