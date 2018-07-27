package cn.vgbhfive.vid.vid_intf.bean;

/*
 * @time:
 * @author: Vgbh
 */

public class Id {

    //机器ID，占位10位
    private long machine ;

    //序列号，占位20位
    private long seq ;

    //秒级时间，占位30位
    private long time ;

//    //序列号，占位10位
//    private long seialNumber ;
//
//    //毫秒级时间，占位40位
//    private long mill Time ;

    //生成方式，占位2位
    private long genMethod ;

    //类型，占位1位
    private long type ;

    //版本，占位1位
    private long version ;

    public Id() {
    }

    public Id(long machine, long seq, long time, long genMethod,
              long type, long version) {
        this.machine = machine;
        this.seq = seq;
        this.time = time;
        this.genMethod = genMethod;
        this.type = type;
        this.version = version;
    }

    public long getMachine() {
        return machine;
    }

    public void setMachine(long machine) {
        this.machine = machine;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getGenMethod() {
        return genMethod;
    }

    public void setGenMethod(long genMethod) {
        this.genMethod = genMethod;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Id{" +
                "machine='" + machine + '\'' +
                ", seq='" + seq + '\'' +
                ", time='" + time + '\'' +
                ", genMethod='" + genMethod + '\'' +
                ", type='" + type + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
