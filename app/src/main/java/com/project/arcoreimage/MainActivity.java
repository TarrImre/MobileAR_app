package com.project.arcoreimage;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.arcoreimage.R;
import com.google.ar.core.Anchor;
import com.google.ar.core.AugmentedImage;
import com.google.ar.core.AugmentedImageDatabase;
import com.google.ar.core.Config;
import com.google.ar.core.Frame;
import com.google.ar.core.Session;
import com.google.ar.core.TrackingState;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final double MIN_OPENGL_VERSION = 3.0;
    private boolean isAdded = false;
    ArFragment arFragment;
    private ImageButton backToMain;
    private ImageButton animalDetailsButton;
    public TextView animalNames;
    MediaPlayer player;
    public Boolean clickAble=false;
    public String setAnimalName;
    public String setAnimalDescription;
    @Override
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        if (!checkIsSupportedDeviceOrFinish(this))
            return;

        setContentView(R.layout.activity_main);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
        arFragment.getPlaneDiscoveryController().hide();
        arFragment.getArSceneView().getScene().addOnUpdateListener(this::onUpateFrame);

        backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainPage();
            }
        });

        animalDetailsButton = findViewById(R.id.animalDetailsButton);
        animalDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAble=true;
                openAnimalDetails();
            }
        });
    }

    private void openMainPage(){
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
        finish();
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    private void onUpateFrame(FrameTime frametime) {
        Frame frame = arFragment.getArSceneView().getArFrame();

        animalNames = (TextView) findViewById(R.id.animalNames);

        Collection<AugmentedImage> augmentedimages = frame.getUpdatedTrackables(AugmentedImage.class);
        for (AugmentedImage augmentedimage : augmentedimages) {

            if (augmentedimage.getTrackingState() == TrackingState.TRACKING) {

                if(augmentedimage.getName().equals("bear.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.bear);
                    setAnimalName=getString(R.string.bear_Name);
                    setAnimalDescription=getString(R.string.bear_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.bearsound);
                }
                if(augmentedimage.getName().equals("cat.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.cat);
                    setAnimalName=getString(R.string.cat_Name);
                    setAnimalDescription=getString(R.string.cat_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.catsound);
                }
                if(augmentedimage.getName().equals("cow.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.cow);
                    setAnimalName=getString(R.string.cow_Name);
                    setAnimalDescription=getString(R.string.cow_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.cowsound);
                }
                if(augmentedimage.getName().equals("dog.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.dog);
                    setAnimalName=getString(R.string.dog_Name);
                    setAnimalDescription=getString(R.string.dog_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.dogsound);
                }
                if(augmentedimage.getName().equals("elephant.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.elephant);
                    setAnimalName=getString(R.string.elephant_Name);
                    setAnimalDescription=getString(R.string.elephant_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.elephantsound);
                }
                if(augmentedimage.getName().equals("ferret.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.ferret);
                    setAnimalName=getString(R.string.ferret_Name);
                    setAnimalDescription=getString(R.string.ferret_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.ferretsound);
                }
                if(augmentedimage.getName().equals("hippo.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.hippopotamus);
                    setAnimalName=getString(R.string.hippo_Name);
                    setAnimalDescription=getString(R.string.hippo_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.hipposound);
                }
                if(augmentedimage.getName().equals("horse.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.horse);
                    setAnimalName=getString(R.string.horse_Name);
                    setAnimalDescription=getString(R.string.horse_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.horsesound);
                }
                if(augmentedimage.getName().equals("koala.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.koala_bear);
                    setAnimalName=getString(R.string.koala_Name);
                    setAnimalDescription=getString(R.string.koala_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.koalasound);
                }
                if((augmentedimage.getName().equals("lion.jpg") && !isAdded) || (augmentedimage.getName().equals("lionv2.jpg") && !isAdded)) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.lion);
                    setAnimalName=getString(R.string.lion_Name);
                    setAnimalDescription=getString(R.string.lion_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.lionsound);
                }
                if(augmentedimage.getName().equals("reindeer.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.reindeer);
                    setAnimalName=getString(R.string.reindeer_Name);
                    setAnimalDescription= getString(R.string.reindeer_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.reindeersound);
                }
                if(augmentedimage.getName().equals("wolverine.jpg") && !isAdded) {
                    placeObject(arFragment, augmentedimage.createAnchor(augmentedimage.getCenterPose()), R.raw.wolverine);
                    setAnimalName=getString(R.string.wolverine_Name);
                    setAnimalDescription= getString(R.string.wolverine_Description);
                    setAnimalNamesSounds(setAnimalName,R.raw.wolverinesound);
                }
            }
        }
    }

    private void openAnimalDetails(){
        if(clickAble) {
            GlobalClass.globalAnimalName = setAnimalName;
            GlobalClass.globalAnimalDescription=setAnimalDescription;
            Intent intent = new Intent(this, AnimalDetails.class);
            startActivity(intent);
            finish();
        }
    }

    public void setAnimalNamesSounds(String name, @RawRes int sound){
        ImageView scanIcon = (ImageView) findViewById(R.id.scanIcon);
        scanIcon.setVisibility(View.INVISIBLE);
        animalDetailsButton.setVisibility(View.VISIBLE);
        animalNames.setText(name);
        isAdded = true;
        if (player == null) {
            player = MediaPlayer.create(this, sound);
        }
        player.start();
    }

    public boolean setupAugmentedImagesDB(Config config, Session session) {
        AugmentedImageDatabase augmentedImageDatabase;
      //  Bitmap bitmap = loadAugmentedImage();
      //  if (bitmap == null) {
      //      return false;
      //  }

        try {
            InputStream inputStream = getAssets().open("animalimages.imgdb");
            augmentedImageDatabase = AugmentedImageDatabase.deserialize(session,inputStream);
            config.setAugmentedImageDatabase(augmentedImageDatabase);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    private void placeObject(ArFragment arFragment, Anchor anchor, int uri) {
        ModelRenderable.builder()
            .setSource(arFragment.getContext(), uri)
            .build()
            .thenAccept(modelRenderable -> addNodeToScene(arFragment, anchor, modelRenderable))
            .exceptionally(throwable -> {
                    Toast.makeText(arFragment.getContext(), "Error:" + throwable.getMessage(), Toast.LENGTH_LONG).show();
                    return null;
                }
            );
    }

    private void addNodeToScene(ArFragment arFragment, Anchor anchor, Renderable renderable) {
        AnchorNode anchorNode = new AnchorNode(anchor);
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setRenderable(renderable);
        node.setParent(anchorNode);
        arFragment.getArSceneView().getScene().addChild(anchorNode);
        node.select();


        ImageButton again = (ImageButton) findViewById(R.id.againButton);

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });


    }


    private boolean checkIsSupportedDeviceOrFinish(final Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            Log.e(TAG, "Sceneform requires Android N or later");
            Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show();
            activity.finish();
            return false;
        }
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }


}
