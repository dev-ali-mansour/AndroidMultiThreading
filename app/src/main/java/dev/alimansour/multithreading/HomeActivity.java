package dev.alimansour.multithreading;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private EditText userNameEditText, passwordEditText;
    private Button loginButton;
    private int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            new Authentication().execute(
                    userNameEditText.getText().toString(),
                    passwordEditText.getText().toString());
        });

//        new Calculation().calculate(5, 7);
        new BackgroundCalculation().execute(5, 6, 7);
        Log.d("HomeActivity", "From OnCreate: result = " + result);
    }

    class Calculation {
        public void calculate(int x, int y) {
            result = x + y;
        }
    }

    class BackgroundCalculation extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {
            int result = 0;
            for (int number : integers) {
                result += number;
            }

            return result;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            result = integer;
            Log.d("HomeActivity", "From AsyncTask: result = " + result);
        }
    }

    class Authentication extends AsyncTask<String, Void, Void> {
        private String username = "";
        private boolean isAuthenticated = false;

        @Override
        protected Void doInBackground(String... strings) {
            try {
                Thread.sleep(10000);
                username = strings[0];
                String password = strings[1];
                if ((username.equalsIgnoreCase("user")
                        || username.equalsIgnoreCase("admin"))
                        && password.equals("123456")) {
                    isAuthenticated = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (isAuthenticated) {
                Toast.makeText(getApplicationContext(), "Welcome back " + username, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Sorry your username or password is incorrect!", Toast.LENGTH_LONG).show();
            }
        }
    }

}