package fang7.allComparable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 用于分区
 */
public class FlowPartitioner extends Partitioner<FlowBean , Text> {
    @Override
    public int getPartition(FlowBean flowBean, Text text, int i) {
        if("1".equals(text.toString())){
            return 0;
        }else{
            return 1;
        }
    }
}
