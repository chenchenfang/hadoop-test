package fang7.reducejoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

public class ReduceJoinMapper extends Mapper<LongWritable, Text,Text,TableBean> {
    /**
     * 获取当前处理文件的切片
     */
    private FileSplit inputSplit;

    private String name;

    private Text text= new Text();;
    private TableBean tableBean= new TableBean();;
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
         inputSplit = (FileSplit)context.getInputSplit();
        //获取文件的名称
         name = inputSplit.getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String row = value.toString();


        String outKey;
        if(name.contains("order")){
            //这个是处理订单
            String[] split = row.split("\t");

            tableBean.setP_id(split[0]);
            outKey=split[0];
            tableBean.setOrder_id(split[1]);
            tableBean.setPname("");
            tableBean.setAmount(Integer.valueOf(split[2]));
            tableBean.setFlag("order");
        }else{
            String[] split = row.split("\t");
            tableBean.setP_id(split[0]);
            tableBean.setOrder_id("");
            outKey=split[0];
            tableBean.setPname(split[1]);
            tableBean.setFlag("pd");
        }
        text.set(outKey);

        context.write(text,tableBean);
    }
}
