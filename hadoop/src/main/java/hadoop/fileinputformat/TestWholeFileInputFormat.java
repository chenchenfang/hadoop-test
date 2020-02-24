package hadoop.fileinputformat;

import club.chengouzi.hadoop.recordreader.WholeRecordReader;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;

/**
 * 整个文件不切片
 */
public class TestWholeFileInputFormat  extends FileInputFormat<NullWritable, BytesWritable> {
    /**
     * 是否切片
     * @param context
     * @param filename
     * @return
     */
    @Override
    protected boolean isSplitable(JobContext context, Path filename) {
        return false;
    }

    @Override
    public RecordReader<NullWritable, BytesWritable> createRecordReader(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        WholeRecordReader wholeRecordReader = new WholeRecordReader();
        wholeRecordReader.initialize(inputSplit, taskAttemptContext);
        return wholeRecordReader;
    }
}
