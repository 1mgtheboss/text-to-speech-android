package mg.texttospeech;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextToSpeech mTTS;
	private EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}
	
	@Override
	   public void onPause(){
	      if(mTTS !=null){
	    	  mTTS.stop();
	    	  mTTS.shutdown();
	      }
	      super.onPause();
	   }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void convert(View view){
		
		mEditText=(EditText)findViewById(R.id.editText1);
		mTTS=new TextToSpeech(getApplicationContext(), 
			      new TextToSpeech.OnInitListener() {
			      @Override
			      public void onInit(int status) {
			         if(status != TextToSpeech.ERROR){
			             mTTS.setLanguage(Locale.US);

			             String text = mEditText.getText().toString();
			   	      Toast.makeText(getApplicationContext(), text, 
			   	      Toast.LENGTH_SHORT).show();
			   	      mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);	 
			            }				
			         }
			      });
	           

	   }

}
