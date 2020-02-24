package hadoop.api.sequencefile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class ReadSequenceFile {
    public static void main(String[] args) throws IOException {
        IntWritable key = new IntWritable();
        Text value = new Text();

        SequenceFile.Reader.Option file = SequenceFile.Reader.file(new Path(args[0]));
        SequenceFile.Reader reader = new SequenceFile.Reader(new Configuration(), file);
        while (reader.next(key,value)){
            System.out.println(String.format("%s --- %s",key,value));
        }
        IOUtils.closeStream(reader);
    }
}
