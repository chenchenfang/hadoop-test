package fang7.mypartitioner;

import fang7.mapreduce.FlowSum;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * 定义分区
 * @author fang7
 */
public class MyPartitioner extends Partitioner<Text, FlowSum> {
    @Override
    public int getPartition(Text text, FlowSum flowSum, int i) {
        String textStr="1";
        if(textStr.equals(text.toString())){
            return 0;
        }else{
            return 1;
        }

    }
}
