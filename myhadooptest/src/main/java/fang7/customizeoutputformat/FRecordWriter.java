package fang7.customizeoutputformat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;


import java.io.IOException;

public class FRecordWriter extends RecordWriter<Text, NullWritable> {
    private FSDataOutputStream oneDataOutputStream;
    private FSDataOutputStream twoDataOutputStream;

    public FRecordWriter(TaskAttemptContext taskAttemptContext) {
        try {
            FileSystem fileSystem = FileSystem.get(taskAttemptContext.getConfiguration());
            Path onePath = new Path("d:/one.txt");
            Path twoPath = new Path("d:/two.txt");
            //获取输出流
            oneDataOutputStream = fileSystem.create(onePath);
            twoDataOutputStream = fileSystem.create(twoPath);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Text text, NullWritable nullWritable) throws IOException, InterruptedException {
        //往外写
        if (text.toString().contains("baidu")) {
            oneDataOutputStream.write(text.toString().getBytes());
        } else {
            twoDataOutputStream.write(text.toString().getBytes());
        }
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        //关闭输出流
        IOUtils.closeStream(oneDataOutputStream);
        IOUtils.closeStream(twoDataOutputStream);
    }
}
