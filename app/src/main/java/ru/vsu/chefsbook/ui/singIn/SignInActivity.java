package ru.vsu.chefsbook.ui.SingIn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import ru.vsu.chefsbook.R;
import ru.vsu.chefsbook.api.providers.UserAPIProvider;
import ru.vsu.chefsbook.ui.main.MainActivity;

public class SignInActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 0;
    private Button signInButton;
    private Button cancelButton;
    private GoogleSignInClient googleSignInClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signInButton = findViewById(R.id.signInButton);
        cancelButton = findViewById(R.id.cancelButton);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(SignInActivity.this, MainActivity.class));
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(SignInActivity.this, MainActivity.class));
            }
        });
    }

        private void signIn() {
            Intent signInIntent = googleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }

        private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
            try {
                GoogleSignInAccount account = completedTask.getResult(ApiException.class);
                startActivity(new Intent(SignInActivity.this, MainActivity.class));
                UserAPIProvider userAPIProvider = new UserAPIProvider();
                userAPIProvider.createUser(account.getId(), null);
            } catch (ApiException e) {
                int statusCode = e.getStatusCode();
                Log.w("Google Sign In Error", "signInResult:failed code=" + statusCode);
                Toast toast = Toast.makeText(SignInActivity.this, R.string.failedToSignIn, Toast.LENGTH_LONG);
                toast.setMargin(0, 0.1f);
                toast.show();
            }
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RC_SIGN_IN) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                handleSignInResult(task);
            }
    }

}
