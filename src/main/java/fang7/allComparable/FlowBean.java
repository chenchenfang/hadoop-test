package fang7.allComparable;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 继承了writableComparable  从而可以用于排序
 * @author fang7
 */
public class FlowBean implements WritableComparable<FlowBean> {
    private int upFlow;
    private int downFlow;
    private int sumFlow;

    public FlowBean() {
    }

    public FlowBean(int upFlow, int downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow+downFlow;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(upFlow);
        dataOutput.writeInt(downFlow);
        dataOutput.writeInt(sumFlow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        upFlow= dataInput.readInt();
        downFlow=dataInput.readInt();
        sumFlow=dataInput.readInt();
    }

    @Override
    public String toString() {
        return
                upFlow +
                        "\t" + downFlow +
                        "\t" + sumFlow ;
    }
    @Override
    public int compareTo(FlowBean o) {
        if(this.sumFlow>o.getSumFlow()){
            return -1;
        }else{
            return 1;
        }
    }

    public int getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(int upFlow) {
        this.upFlow = upFlow;
    }

    public int getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(int downFlow) {
        this.downFlow = downFlow;
    }

    public int getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(int sumFlow) {
        this.sumFlow = sumFlow;
    }
}
