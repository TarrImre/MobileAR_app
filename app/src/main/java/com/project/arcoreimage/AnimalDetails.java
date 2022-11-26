package com.project.arcoreimage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.arcoreimage.R;

import java.io.IOException;
import java.io.InputStream;

public class AnimalDetails extends AppCompatActivity {

    private TextView animalNameText;
    private TextView animalDescriptionText;
    private ImageView iw;
    private ImageButton backToScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getApplication().setTheme(R.style.Base_ThemeOverlay_AppCompat_Dark);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_animal_details);

        animalNameText = (TextView) findViewById(R.id.animalDetailsText);
        animalDescriptionText = (TextView) findViewById(R.id.animalDescriptionText);
        iw = (ImageView) findViewById(R.id.replaceBannerImage);
        backToScan= (ImageButton) findViewById(R.id.backToScan);
        backToScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanPage();
            }
        });

        animalNameText.setText(GlobalClass.globalAnimalName);
        animalDescriptionText.setText(GlobalClass.globalAnimalDescription);

        if(animalNameText.getText()==getString(R.string.bear_Name)){
            imageReplace("bear.jpg");
        }
        if(animalNameText.getText()==getString(R.string.cat_Name)){
            imageReplace("cat.jpg");
        }
        if(animalNameText.getText()==getString(R.string.cow_Name)){
            imageReplace("cow.jpg");
        }
        if(animalNameText.getText()==getString(R.string.dog_Name)){
            imageReplace("dog.jpg");
        }
        if(animalNameText.getText()==getString(R.string.elephant_Name)){
            imageReplace("elephant.jpg");
        }
        if(animalNameText.getText()==getString(R.string.ferret_Name)){
            imageReplace("ferret.jpg");
        }
        if(animalNameText.getText()==getString(R.string.hippo_Name)){
            imageReplace("hippo.jpg");
        }
        if(animalNameText.getText()==getString(R.string.horse_Name)){
            imageReplace("horse.jpg");
        }
        if(animalNameText.getText()==getString(R.string.koala_Name)){
            imageReplace("koala.jpg");
        }
        if(animalNameText.getText()==getString(R.string.lion_Name)){
            imageReplace("lion.jpg");
        }
        if(animalNameText.getText()==getString(R.string.reindeer_Name)){
            imageReplace("reindeer.jpg");
        }
        if(animalNameText.getText()==getString(R.string.wolverine_Name)){
            imageReplace("wolverine.jpg");
        }
    }

    public void openScanPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void imageReplace(String imgName){
        try {
            InputStream ims = getAssets().open(imgName);
            Drawable d = Drawable.createFromStream(ims, null);
            iw.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}