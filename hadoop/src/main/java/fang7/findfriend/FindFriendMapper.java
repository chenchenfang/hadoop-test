package fang7.findfriend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class FindFriendMapper extends Mapper<LongWritable, Text,Text,Text> {

    HashMap<String, HashSet<String>> stringHashSetHashMap = new HashMap<>();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if(value.toString()!=null&&!"".equals(value.toString())){
            String s = value.toString();
            String[] split = s.split(":");



            String[] myFriends = split[1].split(",");

            for (String friend:
                    myFriends) {
                if(stringHashSetHashMap.get(friend)==null){
                    stringHashSetHashMap.put(friend, new HashSet<>());
                }
                HashSet<String> sets = stringHashSetHashMap.get(friend);
                sets.add(split[0]);
            }
        }

    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        Text textKey = new Text();
        Text textValue = new Text();
        for (String key:
                stringHashSetHashMap.keySet()) {
            textKey.set(key);
            HashSet<String> strings = stringHashSetHashMap.get(key);
            StringBuffer stringBuffer = new StringBuffer();
            for (String friend:
                 strings) {
                stringBuffer.append(friend+",");
            }
            stringBuffer.substring(0, stringBuffer.length()-1);
            textValue.set(stringBuffer.toString());

            context.write(textKey, textValue);
        }
    }
}
