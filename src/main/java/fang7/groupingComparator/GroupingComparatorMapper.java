package fang7.groupingComparator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class GroupingComparatorMapper extends Mapper<LongWritable, Text,OrderBean, NullWritable> {
    private OrderBean orderBean = new OrderBean();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] s = value.toString().split(" ");
        orderBean.setId(Integer.valueOf(s[0]));
        orderBean.setAmount(Integer.valueOf(s[1]));
        context.write(orderBean,NullWritable.get());
    }
}
