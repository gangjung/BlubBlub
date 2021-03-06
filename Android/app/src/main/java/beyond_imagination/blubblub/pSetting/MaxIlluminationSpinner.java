package beyond_imagination.blubblub.pSetting;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by cru65 on 2017-08-04.
 */

/**
 * @file MaxIlluminationSpinner.java
 * @breif
 * Class custom view about Spinner
 * @author Yehun Park
 */
public class MaxIlluminationSpinner extends android.support.v7.widget.AppCompatSpinner {
    /****************/
    /*** Variable ***/
    /****************/
    SettingActivity settingActivity;
    private ArrayAdapter<Integer> adapter;
    private Integer[] items;

    /****************/
    /*** Function ***/
    /****************/
    public MaxIlluminationSpinner(Context context) {
        super(context);
        settingActivity = (SettingActivity)context;
        init();
    }

    public MaxIlluminationSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        settingActivity = (SettingActivity)context;
        init();
    }

    private void init(){
        items = new Integer[10];

        for(int i = 0; i<10; i++) {
            items[i] = (i+1)*10;
        }

        adapter = new ArrayAdapter<Integer>(settingActivity, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        setAdapter(adapter);
        setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                settingActivity.getSetting().setIllum_max(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Log.d("MaxIlluminationSpinner", "init()-success");
    }

    void setLux(int lux) {
        setSelection((lux - 10) / 10);
    }
}
