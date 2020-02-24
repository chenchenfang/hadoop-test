package hadoop.mapper;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * 读取整个文件的mapper
 * 并且获取到文件路径
 */
public class WholeFileMapper extends Mapper<NullWritable, BytesWritable, Text, BytesWritable> {
    private FileSplit fileSplit;
    private Text text=new Text();
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        fileSplit = (FileSplit)context.getInputSplit();

    }

    @Override
    protected void map(NullWritable key, BytesWritable value, Context context) throws IOException, InterruptedException {
        text.set(fileSplit.getPath().getName());
        context.write(text, value);
    }
}
