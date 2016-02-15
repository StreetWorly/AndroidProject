package jp.ac.hal.customimageviewsample001;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomImageView extends ImageView {

	private int imageResource;
	
	public CustomImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
	}
	
	
	@Override
	public void setImageResource(int resId) {
		// TODO Auto-generated method stub
		super.setImageResource(resId);
		//描画したリソースIDをフィールドにセット
		imageResource = resId;  
		
	}

	public int getimageResource(){
		//描画されているリソースidの返却
		return imageResource;
	}

}
