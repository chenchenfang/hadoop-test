package fang7.reducejoin;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ReduceJoinReducer extends Reducer<Text,TableBean,TableBean, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<TableBean> values, Context context) throws IOException, InterruptedException {
        ArrayList<TableBean> tableBeans = new ArrayList<>();

        TableBean pdBean = new TableBean();

        for (TableBean tableBean:
             values) {
            String flag = tableBean.getFlag();
            if(flag.equalsIgnoreCase("order")){
                TableBean newBean = new TableBean();
                try {
                    BeanUtils.copyProperties(tableBean,newBean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                tableBeans.add(newBean);
            }else if(flag.equalsIgnoreCase("pd")){
                try {
                    BeanUtils.copyProperties(tableBean,pdBean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        //往外输出日志
        for (TableBean tableBean:
             tableBeans) {
            tableBean.setPname(pdBean.getPname());
            context.write(tableBean, NullWritable.get());
        }
    }
}
