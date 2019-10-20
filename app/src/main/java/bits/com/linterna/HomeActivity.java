package bits.com.linterna;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    ImageView btnBombilla;
    Camera camera;
    Camera.Parameters parameters;
    boolean isFlash = false;
    boolean isOn = true;
    //TODO Metodo para que de detenga la app
    /*@Override
    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnBombilla = findViewById(R.id.img_bombila);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.
                checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {android.Manifest.permission.CAMERA}, 0);
        } else {
            if (getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.
                    FEATURE_CAMERA_FLASH)) {
                camera = Camera.open();
                parameters = camera.getParameters();
                isFlash = true;
            }
        }

        btnBombilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlash) {

                    if (!isOn) {
                        btnBombilla.setImageResource(R.drawable.foco0n1);
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        camera.startPreview();
                        isOn = true;
                    } else {
                        btnBombilla.setImageResource(R.drawable.foco0f1);
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(parameters);
                        camera.stopPreview();
                        isOn = false;
                    }
                }
            }
        });
    }
}