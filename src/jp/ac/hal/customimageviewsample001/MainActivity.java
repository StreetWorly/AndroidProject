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
        //�I�[�o�[���C�g�T���v��
        CustomImageView civ = (CustomImageView)findViewById(R.id.customImageView1);
        //���`��
        //civ.setImageResource(R.drawable.maru);
        //�󔒕`��
        civ.setImageResource(R.drawable.blank);
        //���\�[�XID���擾
        int resId = civ.getimageResource();
        //�g�[�X�g�ŕ\��
        Toast.makeText(this,String.valueOf(resId),Toast.LENGTH_LONG).show();
        */
        
        resultText = (TextView)findViewById(R.id.resulttext);
        
        //CoustomImageViews�z����쐬���Ablank������B
        //���炩���߃t�B�[���h�Ƃ���3�~3�̔z���錾
        customImageViews = new CustomImageView[3][3];
        //�摜ID�̊��蓖��(���ڂ�Ȃ�)
        customImageViews[0][0] = (CustomImageView)findViewById(R.id.gameR0C0);
        customImageViews[0][1] = (CustomImageView)findViewById(R.id.gameR0C1);
        customImageViews[0][2] = (CustomImageView)findViewById(R.id.gameR0C2);
        
        customImageViews[1][0] = (CustomImageView)findViewById(R.id.gameR1C0);
        customImageViews[1][1] = (CustomImageView)findViewById(R.id.gameR1C1);
        customImageViews[1][2] = (CustomImageView)findViewById(R.id.gameR1C2);
        
        customImageViews[2][0] = (CustomImageView)findViewById(R.id.gameR2C0);
        customImageViews[2][1] = (CustomImageView)findViewById(R.id.gameR2C1);
        customImageViews[2][2] = (CustomImageView)findViewById(R.id.gameR2C2);
        
        //���Z�b�g�{�^��ID�̊��蓖��
        Button resetbutton = (Button)findViewById(R.id.resetbutton);
        
        //����textviewID�̊��蓖��
//        final TextView resultText = (TextView)findViewById(R.id.resulttext);
        
        
        //�����摜(blank)�̕`��
        init();
        
        
        //custonImageViews�z�񂪉����ꂽ�ꁛ�~�`��
        for(int i =0; i<customImageViews.length;i++){
        	for(int j=0;j<customImageViews[i].length;j++){
        		 customImageViews[i][j].setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//�N���b�N���̏������L�q
						if(!winflg){
							imageBtnCliked(v);
							judge();
						}
					}
				});
        	}
        }
        //���Z�b�g�{�^���̏���
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
    	//CustomImageView�N���X�ɃL���X�g����
    	CustomImageView civ = (CustomImageView)v;
    	
    	//�󔒂������灛���́~��`��
    	//���݂̏�Ԃ��擾���āA�`��\����m��
    	int rsid = civ.getimageResource();
    	//�󔒂���Ȃ�������
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
    	//��ʏ�����
    	for(int i =0; i<customImageViews.length;i++){
        	for(int j=0;j<customImageViews[i].length;j++){
        		customImageViews[i][j].setImageResource(R.drawable.blank);
        	}
        }
        //�t���O������
    	flg = false;
    }
    
    private void judge(){
//    	���ɂ�����Ă��邩    	
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
