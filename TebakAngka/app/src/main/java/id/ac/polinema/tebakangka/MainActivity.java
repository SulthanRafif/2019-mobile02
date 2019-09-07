package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private EditText Angka;
	private Button tombolTebak, tombolReset;

	int min = 1;
	int maks = 100;

	int angkaAcak = initRandomNumber();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Angka = findViewById(R.id.number_input);
		tombolTebak = findViewById(R.id.guess_button);
		tombolReset = findViewById(R.id.reset_button);

	}

	// TODO: generate angka random di sini
	private int initRandomNumber() {
		int acak = (int) (Math.random() * ((maks - min) + 1)) + min;
		return acak;
	}

	public void handleGuess(View view) {
		if(Angka.getText().toString().equals("")){
			Toast.makeText(this, "Isi tebakan anda", Toast.LENGTH_SHORT).show();
		}

		else{
			int tebakanAngka = Integer.parseInt(Angka.getText().toString());

			if(tebakanAngka > maks)	{
				Toast.makeText(this, "Tebakan lebih dari 100", Toast.LENGTH_SHORT).show();
			}

			else if(tebakanAngka < min)	{
				Toast.makeText(this, "Tebakan angka kurang dari 1", Toast.LENGTH_SHORT).show();
			}

			else if(tebakanAngka > angkaAcak) {
				Toast.makeText(this, "Tebakan angka terlalu besar", Toast.LENGTH_SHORT).show();
			}

			else if(tebakanAngka < angkaAcak) {
				Toast.makeText(this, "Tebakan angka terlalu kecil", Toast.LENGTH_SHORT).show();
			}

			else{
				Toast.makeText(this, "Tebakan tepat", Toast.LENGTH_SHORT).show();
				tombolTebak.setEnabled(false);
				Angka.setEnabled(false);
				tombolReset.setEnabled(true);
			}
		}
	}

	public void handleReset(View view) {
		Angka.setText("");
		tombolTebak.setEnabled(true);
		Angka.setEnabled(true);
		angkaAcak = initRandomNumber();
		tombolReset.setEnabled(false);
	}
}
