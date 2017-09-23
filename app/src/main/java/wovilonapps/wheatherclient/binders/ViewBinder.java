package wovilonapps.wheatherclient.binders;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import wovilonapps.wheatherclient.R;

//class to operate with bitmaps in SimpleAdapter
public class ViewBinder implements SimpleAdapter.ViewBinder {
    @Override
    public boolean setViewValue(View view, Object data,
                                String textRepresentation) {
        if ((view instanceof ImageView) & (data instanceof Bitmap)) {
            ImageView iv = (ImageView) view;
            Bitmap bm = (Bitmap) data;
            iv.setImageBitmap(bm);
            return true;
        }else if (view.getId()== R.id.windDirection){
            ImageView iv = (ImageView) view;
            iv.setRotation(Float.parseFloat(data+""));
        }
        return false;
    }
}
