package hadoop.recordreader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * 读取整个文件的所有内容
 * 不切分的
 *
 */
public class WholeRecordReader extends RecordReader<NullWritable, BytesWritable> {
    private FileSplit fileSplit;
    private Configuration configuration;
    private BytesWritable value=new BytesWritable();

    private boolean processed =false;
    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        fileSplit=(FileSplit) inputSplit;
        configuration = taskAttemptContext.getConfiguration();
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        if(!processed){
            byte[] bytes = new byte[(int)fileSplit.getLength()];

            Path path = fileSplit.getPath();
            FileSystem fileSystem = path.getFileSystem(configuration);

            FSDataInputStream open = fileSystem.open(path);
            IOUtils.readFully(open, bytes, 0, (int)fileSplit.getLength());
            value.set(bytes,0,bytes.length);
            IOUtils.closeStream(open);
            processed =true;

            return true;
        }else{
            return false;
        }


    }

    @Override
    public NullWritable getCurrentKey() throws IOException, InterruptedException {

        return NullWritable.get();
    }

    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {

        return value;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
