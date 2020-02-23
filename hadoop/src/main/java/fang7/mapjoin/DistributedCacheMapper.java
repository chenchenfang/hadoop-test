package fang7.mapjoin;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class DistributedCacheMapper extends Mapper<LongWritable, Text,Text, NullWritable> {
    private HashMap<String, String> map = new HashMap<>();
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {

        URI[] cacheFiles = context.getCacheFiles();
        String s = cacheFiles[0].getPath().toString();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(s), StandardCharsets.UTF_8));
        String line;
        while (StringUtils.isNotEmpty(line=bufferedReader.readLine())){
            String[] split = line.split("\t");
            map.put(split[0],split[1]);
        }
        bufferedReader.close();
    }
    Text text = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split = value.toString().split("\t");
        String s = map.get(split[0]);
        text.set(value.toString()+"\t"+s);
        context.write(text,NullWritable.get());
    }
}
