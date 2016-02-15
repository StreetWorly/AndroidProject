package jp.ac.hal.customimageviewsample001;

import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter.LengthFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	
	private CustomImageView[][] customImageViews;
	private boolean flg =false;
	private boolean winflg =false;

	private TextView resultText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        //オーバーライトサンプル
        CustomImageView civ = (CustomImageView)findViewById(R.id.customImageView1);
        //○描画
        //civ.setImageResource(R.drawable.maru);
        //空白描画
        civ.setImageResource(R.drawable.blank);
        //リソースIDを取得
        int resId = civ.getimageResource();
        //トーストで表示
        Toast.makeText(this,String.valueOf(resId),Toast.LENGTH_LONG).show();
        */
        
        resultText = (TextView)findViewById(R.id.resulttext);
        
        //CoustomImageViews配列を作成し、blankを入れる。
        //あらかじめフィールドとして3×3の配列を宣言
        customImageViews = new CustomImageView[3][3];
        //画像IDの割り当て(さぼれない)
        customImageViews[0][0] = (CustomImageView)findViewById(R.id.gameR0C0);
        customImageViews[0][1] = (CustomImageView)findViewById(R.id.gameR0C1);
        customImageViews[0][2] = (CustomImageView)findViewById(R.id.gameR0C2);
        
        customImageViews[1][0] = (CustomImageView)findViewById(R.id.gameR1C0);
        customImageViews[1][1] = (CustomImageView)findViewById(R.id.gameR1C1);
        customImageViews[1][2] = (CustomImageView)findViewById(R.id.gameR1C2);
        
        customImageViews[2][0] = (CustomImageView)findViewById(R.id.gameR2C0);
        customImageViews[2][1] = (CustomImageView)findViewById(R.id.gameR2C1);
        customImageViews[2][2] = (CustomImageView)findViewById(R.id.gameR2C2);
        
        //リセットボタンIDの割り当て
        Button resetbutton = (Button)findViewById(R.id.resetbutton);
        
        //結果textviewIDの割り当て
//        final TextView resultText = (TextView)findViewById(R.id.resulttext);
        
        
        //初期画像(blank)の描画
        init();
        
        
        //custonImageViews配列が押されたれ○×描画
        for(int i =0; i<customImageViews.length;i++){
        	for(int j=0;j<customImageViews[i].length;j++){
        		 customImageViews[i][j].setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//クリック時の処理を記述
						if(!winflg){
							imageBtnCliked(v);
							judge();
						}
					}
				});
        	}
        }
        //リセットボタンの処理
        resetbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				init();
				resultText.setText("result");
				winflg = false;
			}
		});
      
    }
    
    private void imageBtnCliked(View v){
    	//CustomImageViewクラスにキャストする
    	CustomImageView civ = (CustomImageView)v;
    	
    	//空白だったら○又は×を描画
    	//現在の状態を取得して、描画可能かを知る
    	int rsid = civ.getimageResource();
    	//空白じゃなかったら
    	if(rsid == R.drawable.blank){
    		if(!flg){
    			civ.setImageResource(R.drawable.maru);
    		}else{
    			civ.setImageResource(R.drawable.batu);
    		}
    	 flg = !flg; 	
    	}
    }
    
    
    private void init(){
    	//画面初期化
    	for(int i =0; i<customImageViews.length;i++){
        	for(int j=0;j<customImageViews[i].length;j++){
        		customImageViews[i][j].setImageResource(R.drawable.blank);
        	}
        }
        //フラグ初期化
    	flg = false;
    }
    
    private void judge(){
//    	横にそろっているか    	
    	for(int i=0; i<customImageViews.length; i++){
    		 if(customImageViews[i][0].getimageResource() != R.drawable.blank){
   			 if(customImageViews[i][0].getimageResource() == customImageViews[i][1].getimageResource() && customImageViews[i][0].getimageResource() == customImageViews[i][2].getimageResource()){
   				 winflg = true;
					if(!flg){
						resultText.setText("batsu");
					}else{
						resultText.setText("maru");
						}
	   			 	}  	    	   	    	
	   			 }
    		}
    	    	for(int i=0; i<customImageViews.length; i++){
    	    		 if(customImageViews[0][i].getimageResource() != R.drawable.blank){
    	   			 if(customImageViews[0][i].getimageResource() == customImageViews[1][i].getimageResource() && customImageViews[0][i].getimageResource() == customImageViews[2][i].getimageResource()){
    	   				 winflg = true;
								if(!flg){
									resultText.setText("batsu");
								}else{
									resultText.setText("maru");
								}
    	   			 		}  	    	   	    	
    	   			 	}	 
    	    		}  
    	    	if(customImageViews[0][0].getimageResource() != R.drawable.blank){
    	    		if(customImageViews[0][0].getimageResource() == customImageViews[1][1].getimageResource() && customImageViews[0][0].getimageResource() == customImageViews[2][2].getimageResource()){
    	    			winflg = true;
						if(!flg){
							resultText.setText("batsu");
						}else{
							resultText.setText("maru");
						}
    	    		}
    	    	}
    	    	
    	    	if(customImageViews[0][2].getimageResource() != R.drawable.blank){
    	    		if(customImageViews[0][2].getimageResource() == customImageViews[1][1].getimageResource() && customImageViews[0][2].getimageResource() == customImageViews[2][0].getimageResource()){
    	    			winflg = true;
						if(!flg){
							resultText.setText("batsu");
						}else{
							resultText.setText("maru");
						}
    	    		}
    	    	}

    	}
    
    
//    	if(customImageViews[0][0] == customImageViews[0][1] || customImageViews[0][1] == customImageViews[0][2]){
//    		
//    	}else{
//    		if(customImageViews[1][0] == customImageViews[1][1] || customImageViews[1][1] == customImageViews[1][2]){
//    			
//    		}else{
//    			if(customImageViews[2][0] == customImageViews[2][1] || customImageViews[2][1] == customImageViews[2][2]){
//    			}
//    		}
//    	}
	
   
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
