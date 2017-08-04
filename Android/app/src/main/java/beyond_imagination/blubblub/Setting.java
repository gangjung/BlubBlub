package beyond_imagination.blubblub;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cru65 on 2017-08-02.
 */

public class Setting implements Parcelable{
    /*** Variable ***/
    // 자동 반자동
    private boolean auto;
    // 먹이 주기 (1시간 단위)
    private int feed_cycle;
    // 온도 (최대 : 25~30, 최소 : 20~25)
    private int tmp_max;
    private int tmp_min;
    // 조도
    private int lux_max;

    /*** Function ***/
    public Setting()
    {
        auto = false;
        feed_cycle = 1;
        tmp_max = 25;
        tmp_min = 20;
        lux_max = 0;
    }

    protected Setting(Parcel in) {
        auto = (in.readInt() == 1);
        feed_cycle = in.readInt();
        tmp_max = in.readInt();
        tmp_min = in.readInt();
        lux_max = in.readInt();
    }

    // 접근자 잘 해줘야 한다.
    public static final Creator<Setting> CREATOR = new Creator<Setting>(){
        @Override
        public Setting createFromParcel(Parcel source) {
            return new Setting(source);
        }

        @Override
        public Setting[] newArray(int size) {
            return new Setting[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(auto ? 1 : 0);
        dest.writeInt(feed_cycle);
        dest.writeInt(tmp_max);
        dest.writeInt(tmp_min);
        dest.writeInt(lux_max);
    }

    /////
    // Getter and Setter
    ////
    public boolean getAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public int getFeed_cycle() {
        return feed_cycle;
    }

    public void setFeed_cycle(int feed_cycle) {
        this.feed_cycle = feed_cycle;
    }

    public int getTmp_max() {
        return tmp_max;
    }

    public void setTmp_max(int tmp_max) {
        this.tmp_max = tmp_max;
    }

    public int getTmp_min() {
        return tmp_min;
    }

    public void setTmp_min(int tmp_min) {
        this.tmp_min = tmp_min;
    }

    public int getLux_max() {
        return lux_max;
    }

    public void setLux_max(int lux_max) {
        this.lux_max = lux_max;
    }
}
