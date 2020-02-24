package hadoop.api.serialization;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparator;

public class RawComparatorTest {
    public static void main(String[] args) {
        //通过WritableComparator获得对比大小的类
        WritableComparator writableComparator = WritableComparator.get(IntWritable.class);
        IntWritable i1 = new IntWritable(2);
        IntWritable i2 = new IntWritable(3);
        int compare = writableComparator.compare(i1, i2);
        System.out.println(compare);

    }
}
