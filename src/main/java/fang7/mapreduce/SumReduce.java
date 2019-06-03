package fang7.mapreduce;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author fang7
 */
public class SumReduce extends Reducer< Text,FlowSum, Text,FlowSum> {
    @Override
    protected void reduce(Text key, Iterable<FlowSum> values, Context context) throws IOException, InterruptedException {
        Iterator<FlowSum> iterator = values.iterator();
        int up=0;
        int down=0;
        while(iterator.hasNext()){
            FlowSum next = iterator.next();
            up+=next.upFlow;
            down+=next.downFlow;
        }
        context.write(key,new FlowSum(up,down));
    }
}
