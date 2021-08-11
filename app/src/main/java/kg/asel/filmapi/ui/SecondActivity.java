package kg.asel.filmapi.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import kg.asel.filmapi.R;
import kg.asel.filmapi.data.MokerModel;
import kg.asel.filmapi.databinding.ActivitySecondBinding;
import kg.asel.filmapi.frameworks.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String getTitle = getIntent().getStringExtra("title");
        String getContent = getIntent().getStringExtra("content");
        String getUser = getIntent().getStringExtra("user");
        String getGroup = getIntent().getStringExtra("group");
        String getId = getIntent().getStringExtra("id");

        binding.editTitle.setText(getTitle);
        binding.editContent.setText(getContent);
        binding.editUser.setText(getUser);
        binding.editGroup.setText(getGroup);



        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = binding.editTitle.getText().toString();
                String content = binding.editContent.getText().toString();

                RetrofitBuilder.getInstance().createMokerModel(new MokerModel(title, content,
                        Integer.valueOf(binding.editUser.getText().toString().trim()),Integer.valueOf(binding.editGroup.getText().toString().trim()) )).enqueue(new Callback<MokerModel>() {
                    @Override
                    public void onResponse(Call<MokerModel> call, Response<MokerModel> response) {

                    }

                    @Override
                    public void onFailure(Call<MokerModel> call, Throwable t) {

                    }
                });

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });

        binding.btnUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetrofitBuilder.getInstance().upgrade(""+getId, new MokerModel(binding.editTitle.getText().toString().trim(), binding.editContent.getText().toString().trim(),
                        Integer.valueOf(binding.editUser.getText().toString().trim()),Integer.valueOf(binding.editGroup.getText().toString().trim()))).enqueue(new Callback<MokerModel>() {
                    @Override
                    public void onResponse(Call<MokerModel> call, Response<MokerModel> response) {

                    }

                    @Override
                    public void onFailure(Call<MokerModel> call, Throwable t) {

                    }
                });

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}