package fang7.allComparable;

import fang7.mapreduce.FlowSum;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

public class SumMapper extends Mapper<LongWritable, Text,FlowBean ,Text > {

    // 定义一个TreeMap作为存储数据的容器（天然按key排序）
    private TreeMap<FlowBean, Text> flowMap = new TreeMap<FlowBean, Text>();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        Text outkey=new Text();
        FlowBean kBean = new FlowBean();


        String string = value.toString();
        // 2 切割
        String[] fields = string.split("\t");

        // 3 封装数据
        String phoneNum = fields[0];

        int upFlow = Integer.parseInt(fields[1]);
        int downFlow = Integer.parseInt(fields[2]);
        int sumFlow = Integer.parseInt(fields[3]);

        kBean.setDownFlow(downFlow);
        kBean.setUpFlow(upFlow);
        kBean.setSumFlow(sumFlow);

        outkey.set(phoneNum);

        // 4 向TreeMap中添加数据
        flowMap.put(kBean, outkey);

        // 5 限制TreeMap的数据量，超过10条就删除掉流量最小的一条数据
        if (flowMap.size() > 10) {
//		flowMap.remove(flowMap.firstKey());
            flowMap.remove(flowMap.lastKey());
        }

    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {

        // 6 遍历treeMap集合，输出数据
        Iterator<FlowBean> bean = flowMap.keySet().iterator();

        while (bean.hasNext()) {

            FlowBean k = bean.next();

            context.write(k, flowMap.get(k));
        }
    }

}
