package com.example.p2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView texto;
	private ImageView imagen;
	private Button boton;
	private Context context;
	private Button boton2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		texto = (TextView) findViewById(R.id.Textomain);
		imagen = (ImageView) findViewById(R.id.imgP2);
		boton = (Button) findViewById(R.id.button1);
		context = (Context) this;
		
		boton.setOnClickListener(new OnClickListener() {
			
			

			@Override
			public void onClick(View v) {
				if(imagen.getVisibility() == View.VISIBLE) {
					imagen.setVisibility(View.INVISIBLE);
				} else{
					Toast.makeText(context, "Me lo tirooo", Toast.LENGTH_SHORT).show();
					imagen.setVisibility(View.VISIBLE);
					context.startActivity(new Intent(context,ListActivity.class));
				}
				
			}
		});
		
		boton2 = (Button) findViewById(R.id.button2);

		boton2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Lanzo Fragment", Toast.LENGTH_SHORT).show();
				context.startActivity(new Intent(context, MenusActivity.class));
			}
		});
		
		
	}


}
