package fang7.groupingComparator;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class OrderSortGroupingComparator extends WritableComparator {
    public OrderSortGroupingComparator() {
        super(OrderBean.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        OrderBean aBean = (OrderBean) a;
        OrderBean bBean = (OrderBean) b;
        if(aBean.getId()>bBean.getId()){
            return 1;
        }else if(aBean.getId()<bBean.getId()){
            return -1;
        }else{
            return 0;
        }
    }

}
