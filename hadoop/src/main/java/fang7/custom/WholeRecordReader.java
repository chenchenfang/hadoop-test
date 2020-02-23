package fang7.custom;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * @author fang7
 */
public class WholeRecordReader extends RecordReader<Text, BytesWritable> {
    private FileSplit fileSplit;
    private Configuration configuration;
    private Text text = new Text();
    private BytesWritable bytesWritable = new BytesWritable();
    private Boolean isProgress=true;
    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        fileSplit=(FileSplit)inputSplit;
        configuration= taskAttemptContext.getConfiguration();
    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        if (isProgress) {
            byte[] bytes = new byte[(int)fileSplit.getLength()];
            FileSystem fileSystem=null;
            FSDataInputStream open=null;
            try {
                Path path = fileSplit.getPath();
                fileSystem = path.getFileSystem(configuration);
                open = fileSystem.open(path);
                IOUtils.readFully(open, bytes, 0, bytes.length);
                bytesWritable.set(bytes, 0,bytes.length);
                String name = path.getName();
                text.set(name);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeStream(open);
            }
            isProgress=false;
            return true;
        }else{
            return false;
        }


    }

    @Override
    public Text getCurrentKey() throws IOException, InterruptedException {

        return text;
    }

    @Override
    public BytesWritable getCurrentValue() throws IOException, InterruptedException {

        return bytesWritable;
    }

    @Override
    public float getProgress() throws IOException, InterruptedException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
