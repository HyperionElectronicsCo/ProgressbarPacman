package com.example.progressbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar progressBar;
	private
    Handler handler = new Handler();
	private int progressStatus = 0;
    private TextView textView;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		final Drawable thumb = getResources().getDrawable(R.drawable.Pacman1);
		final Drawable thumb2 = getResources().getDrawable(R.drawable.Pacman2);
		Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
        progressBar = (SeekBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
		textView = (TextView) findViewById(R.id.textView);
		progressBar.setThumb(thumb);
		progressBar.setBackgroundResource(R.drawable.n2az1ncp5auo2czwv055_20210819060842583);
		progressBar.setMin(0);
		progressBar.setMax(100);
	// Start long running operation in a background thread
	new
	Thread(
	new
	Runnable() {
	public void run()
	{
			progressBar.setVisibility(View.VISIBLE);
		
		while
		(progressStatus <
		 100
		 ) { progressStatus +=
				1
				;
// Update the progress bar and display the
//current value in the text view
			handler.post(
				new
				Runnable() {
					public void run()
					{
						progressBar.setProgress(progressStatus); textView.setText(progressStatus+
																				"/"
																				+progressBar.getMax()); 
						if
						((progressBar.getProgress() == 100))
						{
							progressBar.setVisibility(View.GONE);
							textView.setVisibility(View.GONE);
						}
						if ((progressStatus % 2) == 0) {
							// number is even
							progressBar.setThumb(thumb2);
						}

						else {
							// number is odd
							progressBar.setThumb(thumb);
						}
																				} 
																			});
																				
			try
			{
// Sleep for 200 milliseconds.
				Thread.sleep(
					69
				);
				}
			catch
			(InterruptedException e) { e.printStackTrace(); 
			} 
		}
	} 
			}).start();
		
		
}

}
