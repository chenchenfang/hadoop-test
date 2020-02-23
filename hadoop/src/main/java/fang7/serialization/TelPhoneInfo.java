package fang7.serialization;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

/**
 * 实现了序列化以及排序方法 可用于key排序
 * @author fang7
 */
public class TelPhoneInfo implements Writable, WritableComparable<TelPhoneInfo> {
    private Integer telNumber;
    private Integer flow;

    public TelPhoneInfo() {
        super();
    }

    public TelPhoneInfo(Integer telNumber, Integer flow) {
        this.telNumber = telNumber;
        this.flow = flow;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(telNumber);
        dataOutput.writeInt(flow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        telNumber=dataInput.readInt();
        flow=dataInput.readInt();
    }

    @Override
    public int compareTo(TelPhoneInfo o) {
        if(this.flow>o.flow){
            return -1;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return "TelPhoneInfo{" +
                "telNumber=" + telNumber +
                ", flow=" + flow +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelPhoneInfo that = (TelPhoneInfo) o;
        return Objects.equals(telNumber, that.telNumber) &&
                Objects.equals(flow, that.flow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telNumber, flow);
    }

    public Integer getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Integer telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getFlow() {
        return flow;
    }

    public void setFlow(Integer flow) {
        this.flow = flow;
    }
}
