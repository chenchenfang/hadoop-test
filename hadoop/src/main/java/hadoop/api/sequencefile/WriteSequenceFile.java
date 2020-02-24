package hadoop.api.sequencefile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * 写入顺序文件
 * @author fang7
 */
public class WriteSequenceFile {
    public static void main(String[] args) throws IOException {
        IntWritable key = new IntWritable();
        Text value = new Text();

        Configuration entries = new Configuration();
        SequenceFile.Writer.Option file = SequenceFile.Writer.file(new Path(args[0]));
        SequenceFile.Writer.Option keyClass = SequenceFile.Writer.keyClass(IntWritable.class);
        SequenceFile.Writer.Option textClass = SequenceFile.Writer.valueClass(Text.class);
        SequenceFile.Writer writer = SequenceFile.createWriter(entries, file, keyClass, textClass, SequenceFile.Writer.compression(SequenceFile.CompressionType.RECORD));
        for (int i = 0; i < 10; i++) {
            key.set(10);
            value.set("wjfow");
            writer.append(key,value);
        }
        IOUtils.closeStream(writer);
    }
}
