package fang7.mapreduce;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author fang7
 */
public class FlowSum implements Writable {
     int upFlow;
     int downFlow;
     int sumFlow;

    public FlowSum() {
    }

    public FlowSum(int upFlow, int downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow+downFlow;
    }

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(upFlow);
        dataOutput.writeInt(downFlow);
        dataOutput.writeInt(sumFlow);
    }

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
}
